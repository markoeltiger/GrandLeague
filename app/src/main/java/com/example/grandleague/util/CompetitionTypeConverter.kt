package com.example.grandleague.util

import androidx.room.TypeConverter
import com.example.grandleague.data.model.Competition
import com.example.grandleague.data.model.Matche
import com.google.gson.Gson
import org.json.JSONObject
import javax.xml.transform.Source

class CompetitionTypeConverter {
    @TypeConverter
    fun competitionToString(competition: Competition): String = Gson().toJson(competition)

    @TypeConverter
    fun stringTocompetition(string: String): Competition = Gson().fromJson(string, Competition::class.java)

}