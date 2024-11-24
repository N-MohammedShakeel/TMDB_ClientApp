package com.example.tmdb_cleanarchitecture.presentation.di.core

import com.example.tmdb_cleanarchitecture.data.db.ArtistDao
import com.example.tmdb_cleanarchitecture.data.db.MovieDao
import com.example.tmdb_cleanarchitecture.data.db.TvShowDao
import com.example.tmdb_cleanarchitecture.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdb_cleanarchitecture.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.example.tmdb_cleanarchitecture.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdb_cleanarchitecture.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvshowDao: TvShowDao): TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvshowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

}