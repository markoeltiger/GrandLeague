package com.example.grandleague.util

import androidx.room.TypeConverter
import com.example.grandleague.data.model.Competition
import com.example.grandleague.data.model.Matche
import com.example.grandleague.data.model.MatchesResponse
import com.google.gson.Gson
import org.json.JSONObject
import javax.xml.transform.Source

class MatcheResponseTypeConverter {

    @TypeConverter
    fun matchresponseToString(matche: MatchesResponse): String = Gson().toJson(matche)

    @TypeConverter
    fun stringTomatcheresponse(string: String): MatchesResponse = Gson().fromJson(string, MatchesResponse::class.java)

}