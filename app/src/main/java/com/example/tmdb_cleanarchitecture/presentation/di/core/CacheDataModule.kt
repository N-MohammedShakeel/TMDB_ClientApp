package com.example.tmdb_cleanarchitecture.presentation.di.core

import com.example.tmdb_cleanarchitecture.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdb_cleanarchitecture.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.example.tmdb_cleanarchitecture.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdb_cleanarchitecture.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provieMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provieTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provieArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}