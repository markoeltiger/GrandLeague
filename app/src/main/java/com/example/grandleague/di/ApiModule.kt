package com.example.grandleague.di


import com.example.grandleague.data.storage.remote.MatchesApiService
import com.example.grandleague.util.Constatnts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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



}