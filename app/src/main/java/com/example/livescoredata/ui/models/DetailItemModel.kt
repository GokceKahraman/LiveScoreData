package com.example.livescoredata.ui.models

import com.example.livescoredata.data.dto.MatchDataDTO
import com.example.livescoredata.data.dto.TeamDTO

data class DetailItemModel(
    val details: TeamDTO, val items: ArrayList<MatchDataDTO>
)