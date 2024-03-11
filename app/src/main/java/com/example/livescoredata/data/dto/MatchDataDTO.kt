package com.example.livescoredata.data.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class MatchDataDTO(
    @SerializedName("d")
    var date: Long = 0,
    @SerializedName("ht")
    var homeTeam: TeamDTO? = null,
    @SerializedName("at")
    var awayTeam: TeamDTO? = null,
    @SerializedName("sc")
    var score: ScoreDTO? = null,
    @SerializedName("to")
    var tournament: TournamentsDTO,

    var isFavorite: Boolean = false

)
