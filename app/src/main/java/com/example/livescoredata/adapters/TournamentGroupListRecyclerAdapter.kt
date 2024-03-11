package com.example.livescoredata.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.livescoredata.R
import com.example.livescoredata.data.dto.MatchDataDTO
import com.example.livescoredata.ui.models.HomeItemModel

class TournamentGroupListRecyclerAdapter(val list: ArrayList<HomeItemModel>, val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<TournamentGroupListRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tournament_group, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerViewRowItems: RecyclerView = itemView.findViewById(R.id.row_item)
        val leagueName: TextView = itemView.findViewById(R.id.league_name)
        val leagueFlag: ImageView = itemView.findViewById(R.id.league_flag)
        fun bind(data: HomeItemModel) {
            leagueName.text = data.tournament.name
            recyclerViewRowItems.adapter = RowItemRecyclerAdapter(data.items, itemClickListener)
            Glide.with(leagueFlag).load(data.tournament.flag).into(leagueFlag)
        }

    }
}

