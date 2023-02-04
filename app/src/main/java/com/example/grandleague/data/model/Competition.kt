package com.example.grandleague.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Competition(
    @Json(name = "area")
    var area: Area?,
    @Json(name = "code")
    var code: String?,
    @Json(name = "id")
    var id: Int?,
    @Json(name = "lastUpdated")
    var lastUpdated: String?,
    @Json(name = "name")
    var name: String?,
    @Json(name = "plan")
    var plan: String?
)