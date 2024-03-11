package com.example.livescoredata.data.dto

import com.google.gson.annotations.SerializedName


data class TournamentsDTO (
    @SerializedName("i")
    var id: Int = 0,
    @SerializedName("n")
    var name: String? = null,
    @SerializedName("sn")
    var shortName: String? = null,
    @SerializedName("flag")
    var flag: String? = null,
)


