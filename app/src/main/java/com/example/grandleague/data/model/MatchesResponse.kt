package com.example.grandleague.data.model


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.grandleague.util.CompetitionTypeConverter
import com.example.grandleague.util.FiltersTypeConverter
import com.example.grandleague.util.MatcheResponseTypeConverter
import com.example.grandleague.util.SourceTypeConverter
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
@Entity(tableName = "matcheresponse")
@TypeConverters(MatcheResponseTypeConverter::class)

@JsonClass(generateAdapter = true)
data class MatchesResponse(
    @PrimaryKey

    var id :Int  =0,
    @Json(name = "competition")
    @TypeConverters(CompetitionTypeConverter::class)
    var competition: Competition?,
    @Json(name = "count")
    var count: Int?,
    @TypeConverters(FiltersTypeConverter::class)

    @Json(name = "filters")
    var filters: Filters?,
    @Json(name = "matches")
    @TypeConverters(SourceTypeConverter::class)

    var matches: Array<Matche?>
)