package com.example.livescoredata.ui.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.livescoredata.R
import com.example.livescoredata.adapters.ItemClickListener
import com.example.livescoredata.adapters.TournamentGroupListRecyclerAdapter
import com.example.livescoredata.data.dto.MatchDataDTO
import com.example.livescoredata.data.dto.MatchResponseDTO
import com.example.livescoredata.databinding.FootballMatchScoresListFragmentBinding

import com.example.livescoredata.ui.models.HomeItemModel
import com.example.livescoredata.viewmodel.FootballScoresViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FootballMatchScoresListFragment : Fragment(), ItemClickListener {

    private lateinit var binding: FootballMatchScoresListFragmentBinding
    private val footballScoresViewModel: FootballScoresViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FootballMatchScoresListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                launch {
                    footballScoresViewModel.getData()
                }
                launch {
                    footballScoresViewModel.getFinishedMatches.collect { response ->
                        buildPage(response)
                    }
                }
            }
        }
    }

    private fun buildPage(response: MatchResponseDTO) {
        val sortedItems = response.data.filter { it.score?.st == 5 }
        val filteredItems = sortedItems.sortedBy { it.date }
        val homeList = arrayListOf<HomeItemModel>()
        filteredItems.forEach { match ->
            val t = homeList.find { it.tournament.id == match.tournament.id }
            t?.items?.add(match) ?: kotlin.run {
                homeList.add(HomeItemModel(match.tournament, arrayListOf(match)))
            }
        }
        binding.footballTournamentRecyclerView.adapter =
            TournamentGroupListRecyclerAdapter(homeList, this)
    }

    override fun onMatchClick(match: MatchDataDTO) {
      //  findNavController(R.id.action_footballMatchScoresListFragment_to_detailFragment)
    }




    override fun onFavoriteClick(match: MatchDataDTO) {
        //isFavorite.copy()

    }
}
