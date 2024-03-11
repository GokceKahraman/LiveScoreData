package com.example.livescoredata.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.livescoredata.data.dto.MatchResponseDTO
import com.example.livescoredata.data.service.ServiceApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FootballScoresViewModel @Inject constructor(val serviceApi: ServiceApi) : ViewModel() {

    val getFinishedMatches = MutableSharedFlow<MatchResponseDTO>()

    suspend fun getData() {
        val response = serviceApi.getFinishedMatches()
        if (response.isSuccessful) {
            response.body()?.let {
                getFinishedMatches.emit(it)
            }
        }
    }
}