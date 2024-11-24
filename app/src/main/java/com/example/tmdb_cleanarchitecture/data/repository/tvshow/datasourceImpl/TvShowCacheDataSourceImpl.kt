package com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasourceImpl

import com.example.tmdb_cleanarchitecture.data.model.tvshow.TvShow
import com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasource.TvShowCacheDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowCacheDataSourceImpl(): TvShowCacheDataSource {

    private var tvshowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvshowList
    }

    override suspend fun saveTvShowsToCache(tvshows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvshowList.clear()
            tvshowList = ArrayList(tvshows)
        }
    }
}