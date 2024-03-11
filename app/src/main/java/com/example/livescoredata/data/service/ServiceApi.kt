package com.example.livescoredata.data.service

import com.example.livescoredata.data.dto.MatchResponseDTO
import retrofit2.Response
import retrofit2.http.GET

interface ServiceApi {

    @GET("statistics/sport/SOCCER/matches")
    suspend fun getFinishedMatches(): Response<MatchResponseDTO>

}
