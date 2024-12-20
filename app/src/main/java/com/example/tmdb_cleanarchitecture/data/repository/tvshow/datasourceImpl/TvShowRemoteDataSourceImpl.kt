package com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasourceImpl

import com.example.tmdb_cleanarchitecture.data.api.TMDBService
import com.example.tmdb_cleanarchitecture.data.model.tvshow.TvShowList
import com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): TvShowRemoteDataSource {

    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}