package com.example.livescoredata.data.dto

import com.google.gson.annotations.SerializedName

data class TeamDTO(
    @SerializedName("n")
    var name: String?,
    @SerializedName("p")
    var puan: String?,
    @SerializedName("sn")
    var shortName: String?,
    @SerializedName("rc")
    var redCard: String?
)