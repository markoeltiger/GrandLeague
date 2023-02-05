package com.example.grandleague.util

import androidx.room.TypeConverter
import com.example.grandleague.data.model.Competition
import com.example.grandleague.data.model.Matche
import com.google.gson.Gson
import org.json.JSONObject
import javax.xml.transform.Source

class SourceTypeConverter {

    @TypeConverter
    fun matchToString(matche: Array<Matche>): String = Gson().toJson(matche)

    @TypeConverter
    fun stringTomatche(string: String): Array<Matche> =
        Gson().fromJson(string, Array<Matche>::class.java)

}
