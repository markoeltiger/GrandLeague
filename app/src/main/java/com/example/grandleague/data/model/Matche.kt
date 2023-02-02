package com.example.grandleague.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Matche(
    @Json(name = "awayTeam")
    val awayTeam: AwayTeam,
    @Json(name = "group")
    val group: Any,
    @Json(name = "homeTeam")
    val homeTeam: HomeTeam,
    @Json(name = "id")
    val id: Int,
    @Json(name = "lastUpdated")
    val lastUpdated: String,
    @Json(name = "matchday")
    val matchday: Int,
    @Json(name = "odds")
    val odds: Odds,
    @Json(name = "referees")
    val referees: List<Referee>,
    @Json(name = "score")
    val score: Score,
    @Json(name = "season")
    val season: Season,
    @Json(name = "stage")
    val stage: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "utcDate")
    val utcDate: String
)