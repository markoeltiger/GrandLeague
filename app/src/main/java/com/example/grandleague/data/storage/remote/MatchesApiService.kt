package com.example.grandleague.data.storage.remote


import com.example.grandleague.data.model.MatchesResponse
import com.example.grandleague.util.Constatnts
import retrofit2.http.GET
import retrofit2.http.Header

interface MatchesApiService {
@GET(Constatnts.MATCHES_ENDPOINT)
suspend fun getLeagueMatches(
    @Header("X-Auth-Token") token: String
    ): MatchesResponse

}