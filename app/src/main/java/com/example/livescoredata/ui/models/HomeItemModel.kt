package com.example.livescoredata.ui.models

import com.example.livescoredata.data.dto.MatchDataDTO
import com.example.livescoredata.data.dto.TournamentsDTO

data class HomeItemModel(
    val tournament: TournamentsDTO, val items: ArrayList<MatchDataDTO>
)