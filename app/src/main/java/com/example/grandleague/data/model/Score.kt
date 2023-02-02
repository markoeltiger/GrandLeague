package com.example.grandleague.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Score(
    @Json(name = "duration")
    val duration: String,
    @Json(name = "extraTime")
    val extraTime: ExtraTime,
    @Json(name = "fullTime")
    val fullTime: FullTime,
    @Json(name = "halfTime")
    val halfTime: HalfTime,
    @Json(name = "penalties")
    val penalties: Penalties,
    @Json(name = "winner")
    val winner: String
)