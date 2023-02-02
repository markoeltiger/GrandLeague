package com.example.grandleague.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MatchesResponse(
    @Json(name = "competition")
    val competition: Competition,
    @Json(name = "count")
    val count: Int,
    @Json(name = "filters")
    val filters: Filters,
    @Json(name = "matches")
    val matches: List<Matche>
)