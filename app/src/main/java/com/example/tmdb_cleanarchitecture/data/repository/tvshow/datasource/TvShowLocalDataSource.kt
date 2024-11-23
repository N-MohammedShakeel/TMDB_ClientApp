package com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasource

import com.example.tmdb_cleanarchitecture.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB():List<TvShow>
    suspend fun saveTvShowsToDB(tvshows: List<TvShow>)
    suspend fun clearAll()
}