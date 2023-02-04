package com.example.grandleague.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Season(
    @Json(name = "currentMatchday")
    var currentMatchday: Int?,
    @Json(name = "endDate")
    var endDate: String?,
    @Json(name = "id")
    var id: Int?,
    @Json(name = "startDate")
    var startDate: String?
)