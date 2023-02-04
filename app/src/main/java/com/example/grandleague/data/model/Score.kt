package com.example.grandleague.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Score(
    @Json(name = "duration")
    var duration: String?,
    @Json(name = "extraTime")
    var extraTime: ExtraTime?,
    @Json(name = "fullTime")
    var fullTime: FullTime?,
    @Json(name = "halfTime")
    var halfTime: HalfTime?,
    @Json(name = "penalties")
    var penalties: Penalties?,
    @Json(name = "winner")
    var winner: String?
)