package com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasource

import com.example.tmdb_cleanarchitecture.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>

}