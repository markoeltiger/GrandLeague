package com.example.grandleague.data.storage.remote


import com.example.grandleague.data.model.MatchesResponse
import com.example.grandleague.util.Constatnts
import retrofit2.http.GET

interface MatchesApiService {
@GET(Constatnts.MATCHES_ENDPOINT)
suspend fun getLeagueMatches(

    ): MatchesResponse

}