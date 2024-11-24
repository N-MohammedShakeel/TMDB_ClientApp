package com.example.tmdb_cleanarchitecture.presentation.di.core

import com.example.tmdb_cleanarchitecture.data.api.TMDBService
import com.example.tmdb_cleanarchitecture.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdb_cleanarchitecture.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.example.tmdb_cleanarchitecture.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdb_cleanarchitecture.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apikey:String) {


    @Singleton
    @Provides
    fun provideMovieDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService,apikey
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService,apikey
        )
    }

    @Singleton
    @Provides
    fun provideArtistDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService,apikey
        )
    }
}
