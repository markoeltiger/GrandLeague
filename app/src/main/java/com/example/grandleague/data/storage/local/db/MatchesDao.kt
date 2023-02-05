package com.example.grandleague.data.storage.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.grandleague.data.model.Matche
import com.example.grandleague.data.model.MatchesResponse

@Dao

interface MatchesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)

    suspend fun insertMatches(matche: MatchesResponse)
    @Query(
        "SELECT * FROM matcheresponse"
    )
    suspend fun getAllMatches(): MatchesResponse

}