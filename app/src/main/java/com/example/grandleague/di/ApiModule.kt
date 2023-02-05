package com.example.grandleague.di


import android.content.Context
import com.example.grandleague.data.storage.local.db.AppDatabase
import com.example.grandleague.data.storage.remote.MatchesApiService
import com.example.grandleague.util.Constatnts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
@Provides
@Singleton
fun provideApi(@Named("football") builder:Retrofit.Builder):MatchesApiService{
    return builder
        .build()
        .create(MatchesApiService::class.java)

}
    @Provides
    @Singleton
    @Named("football")
     fun provideRetrofit():Retrofit.Builder{
        return  Retrofit.Builder()
            .baseUrl(Constatnts.API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())

    }


    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) : AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Singleton
    @Provides
    fun provideChannelsDao(db: AppDatabase) = db.matchesDao()

}