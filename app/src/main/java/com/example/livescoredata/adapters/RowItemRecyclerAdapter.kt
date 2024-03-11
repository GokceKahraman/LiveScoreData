package com.example.livescoredata.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.livescoredata.R
import com.example.livescoredata.data.dto.MatchDataDTO


class RowItemRecyclerAdapter(private val list: ArrayList<MatchDataDTO>, val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<RowItemRecyclerAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], position < list.size - 1)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewHomeTeamName: TextView = itemView.findViewById(R.id.ht_team1)
        val textViewHomeTeamScore: TextView = itemView.findViewById(R.id.score1)
        val textViewAwayTeamName: TextView = itemView.findViewById(R.id.at_team2)
        val textViewAwayTeamScore: TextView = itemView.findViewById(R.id.score2)
        val divider: View = itemView.findViewById(R.id.divider)
        val starButton: ImageButton = itemView.findViewById(R.id.star_button)

        fun bind(data: MatchDataDTO, isDividerEnabled: Boolean) {
            textViewHomeTeamName.text = data.homeTeam?.name
            textViewHomeTeamScore.text = data.score?.homeTeam?.goal.toString()
            textViewAwayTeamName.text = data.awayTeam?.name
            textViewAwayTeamScore.text = data.score?.awayTeam?.goal.toString()
            divider.visibility = if (isDividerEnabled) View.VISIBLE else View.GONE

            itemView.setOnClickListener {
                itemClickListener.onMatchClick(data)
            }
            starButton.setOnClickListener{
                itemClickListener.onFavoriteClick(data)
                changeButton(data.isFavorite)
            }
        }
        fun changeButton(isFavorite: Boolean){
                if (isFavorite) {
                    starButton.setBackgroundResource(R.drawable.red_star)
                } else {
                    starButton.setBackgroundResource(R.drawable.white_star)
                }
        }

    }
}

interface ItemClickListener {
    fun onMatchClick(match: MatchDataDTO)
    fun onFavoriteClick(match: MatchDataDTO)
}

