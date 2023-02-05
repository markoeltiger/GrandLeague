package com.example.grandleague.repository


import com.example.grandleague.data.model.MatchesResponse
import com.example.grandleague.data.storage.local.db.MatchesDao
import com.example.grandleague.data.storage.remote.MatchesApiService
import com.example.grandleague.util.Constatnts
import javax.inject.Inject

class MatchesRepo  @Inject constructor(
    private val apiService:MatchesApiService,
    private val matchesDao: MatchesDao


    ){
    suspend fun getMatches(): MatchesResponse {
        insertToDao(apiService.getLeagueMatches(Constatnts.API_KEY))
        return apiService.getLeagueMatches(Constatnts.API_KEY)
    }
    suspend fun insertToDao (matches: MatchesResponse){

        matchesDao.insertMatches(matches)

    }
    suspend fun getFromDao ():MatchesResponse{

        return matchesDao.getAllMatches()

    }
}
