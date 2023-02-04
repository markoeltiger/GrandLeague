package com.example.grandleague.repository


import android.util.Log
import com.example.grandleague.data.model.MatchesResponse
import com.example.grandleague.data.storage.remote.MatchesApiService
import com.example.grandleague.util.Constatnts
import javax.inject.Inject

class MatchesRepo  @Inject constructor(
    private val apiService:MatchesApiService
){
    suspend fun getMatches(): MatchesResponse {

        return apiService.getLeagueMatches(Constatnts.API_KEY)
    }

}
