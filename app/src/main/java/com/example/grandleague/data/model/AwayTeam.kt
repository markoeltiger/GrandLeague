package com.example.grandleague.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AwayTeam(
    @Json(name = "id")
    var id: Int?,
    @Json(name = "name")
    var name: String?
)