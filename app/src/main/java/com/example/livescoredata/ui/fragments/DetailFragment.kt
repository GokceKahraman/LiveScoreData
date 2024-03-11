package com.example.livescoredata.ui.fragments

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.livescoredata.R
import com.example.livescoredata.adapters.TournamentGroupListRecyclerAdapter
import com.example.livescoredata.data.dto.MatchDataDTO
import com.example.livescoredata.data.dto.MatchResponseDTO
import com.example.livescoredata.data.dto.TeamDTO
import com.example.livescoredata.data.dto.TournamentsDTO
import com.example.livescoredata.databinding.DetailFragmentBinding
import com.example.livescoredata.databinding.FootballMatchScoresListFragmentBinding
import com.example.livescoredata.viewmodel.FootballScoresViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

// TAKIM BİLGİLERİ
// Detay ekran tasarım önemli değildir.
@AndroidEntryPoint
class DetailFragment : Fragment(){

    private lateinit var binding: DetailFragmentBinding
    private var match: MatchDataDTO? = null
    val footballScoresViewModel: FootballScoresViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailFragmentBinding.inflate(inflater, container, false)

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
        val team1Name: TextView = view?.findViewById(R.id.team1_name) ?: return
        val team1Puan: TextView = view?.findViewById(R.id.team1_puan) ?: return
        val team1ShortName: TextView = view?.findViewById(R.id.team1_short_name) ?: return
        val team1RedCard: TextView = view?.findViewById(R.id.team1_red_card) ?: return
        val team2Name: TextView = view?.findViewById(R.id.team2_name) ?: return
        val team2Puan: TextView = view?.findViewById(R.id.team2_puan) ?: return
        val team2ShortName: TextView = view?.findViewById(R.id.team2_short_name) ?: return
        val team2RedCard: TextView = view?.findViewById(R.id.team2_red_card) ?: return
        val starButton: ImageButton = view?.findViewById(R.id.star_button) ?: return

        fun bind(data: TeamDTO) {
            team1Name.text = data.name
            team1Puan.text = data.puan
            team1ShortName.text = data.shortName
            team1RedCard.text = data.redCard
            team2Name.text = data.name
            team2Puan.text = data.puan
            team2ShortName.text = data.shortName
            team2RedCard.text = data.redCard
        }
    }
}