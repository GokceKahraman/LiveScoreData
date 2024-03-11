package com.example.livescoredata.data.dto

import com.google.gson.annotations.SerializedName

data class TeamScoreDTO(
    @SerializedName("r")
    var goal: Int = 0,
)