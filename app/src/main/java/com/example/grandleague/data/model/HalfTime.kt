package com.example.grandleague.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HalfTime(
    @Json(name = "awayTeam")
    val awayTeam: Int,
    @Json(name = "homeTeam")
    val homeTeam: Int
)