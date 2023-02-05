package com.example.grandleague.util

import androidx.room.TypeConverter
import com.example.grandleague.data.model.Competition
import com.example.grandleague.data.model.Filters
import com.example.grandleague.data.model.Matche
import com.google.gson.Gson
import org.json.JSONObject
import javax.xml.transform.Source

class FiltersTypeConverter {
    @TypeConverter
    fun filtersToString(filters: Filters): String = Gson().toJson(filters)

    @TypeConverter
    fun stringTofilters(string: String): Filters = Gson().fromJson(string, Filters::class.java)

}