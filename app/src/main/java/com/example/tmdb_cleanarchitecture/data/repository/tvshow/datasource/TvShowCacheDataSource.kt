package com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasource

import com.example.tmdb_cleanarchitecture.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun saveTvShowsToCache(tvshows:List<TvShow>)
}