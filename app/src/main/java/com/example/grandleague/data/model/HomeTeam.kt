package com.example.grandleague.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HomeTeam(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String
)