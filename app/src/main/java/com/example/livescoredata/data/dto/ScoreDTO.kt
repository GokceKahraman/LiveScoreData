package com.example.livescoredata.data.dto

import com.google.gson.annotations.SerializedName

data class ScoreDTO(
    @SerializedName("st")
    var st: Int = 0,
    @SerializedName("abbr")
    var abbregation: String? = null,
    @SerializedName("ht")
    var homeTeam: TeamScoreDTO? = null,
    @SerializedName("at")
    var awayTeam: TeamScoreDTO? = null,
)
