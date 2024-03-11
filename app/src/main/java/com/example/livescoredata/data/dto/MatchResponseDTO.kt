package com.example.livescoredata.data.dto

import com.google.gson.annotations.SerializedName

data class MatchResponseDTO (
    @SerializedName("data")
    val data: List<MatchDataDTO>

    )