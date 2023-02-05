package com.example.grandleague.data.storage.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.grandleague.data.model.Matche
import com.example.grandleague.data.model.MatchesResponse
import com.example.grandleague.util.CompetitionTypeConverter
import com.example.grandleague.util.FiltersTypeConverter
import com.example.grandleague.util.MatcheResponseTypeConverter
import com.example.grandleague.util.SourceTypeConverter

private const val DATABASE_NAME = "league"

private const val DATA_BASE_VERSION = 2
@Database(
    entities = [
        MatchesResponse::class,

    ],
    version = DATA_BASE_VERSION,
    exportSchema = false
)
@TypeConverters(CompetitionTypeConverter::class,FiltersTypeConverter::class,SourceTypeConverter::class,
    MatcheResponseTypeConverter::class
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun  matchesDao(): MatchesDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                )
                     .allowMainThreadQueries().fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }}

}