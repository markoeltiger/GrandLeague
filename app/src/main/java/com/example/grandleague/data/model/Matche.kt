package com.example.grandleague.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
 import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.Converter


@JsonClass(generateAdapter = true)
data class Matche(
    @Json(name = "awayTeam")
     var awayTeam: AwayTeam?,
    @Json(name = "group")

    var group: Any?,
    @Json(name = "homeTeam")

    var homeTeam: HomeTeam?,
    @PrimaryKey

    @Json(name = "id")
    var id: Int?,
    @Json(name = "lastUpdated")
    var lastUpdated: String?,
    @Json(name = "matchday")
    var matchday: Int?,
    @Json(name = "odds")

    var odds: Odds?,
    @Json(name = "referees")

    var referees: List<Referee?>?,
    @Json(name = "score")

    var score: Score?,
    @Json(name = "season")

    var season: Season?,
    @Json(name = "stage")
    var stage: String?,
    @Json(name = "status")
    var status: String?,
    @Json(name = "utcDate")
    var utcDate: String?
)