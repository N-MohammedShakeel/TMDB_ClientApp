package com.example.tmdb_cleanarchitecture.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.tmdb_cleanarchitecture.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataDase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            TMDBDatabase::class.java,
            "tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase) = tmdbDatabase.movieDao()

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase) = tmdbDatabase.tvDao()

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase) = tmdbDatabase.artistDao()


}