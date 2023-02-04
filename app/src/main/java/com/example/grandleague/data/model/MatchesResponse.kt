package com.example.grandleague.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MatchesResponse(
    @Json(name = "competition")
    var competition: Competition?,
    @Json(name = "count")
    var count: Int?,
    @Json(name = "filters")
    var filters: Filters?,
    @Json(name = "matches")
    var matches: List<Matche?>?
)