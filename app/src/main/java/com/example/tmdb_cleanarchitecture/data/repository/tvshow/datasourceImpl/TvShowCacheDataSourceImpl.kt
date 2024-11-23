package com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasourceImpl

import com.example.tmdb_cleanarchitecture.data.db.TvShowDao
import com.example.tmdb_cleanarchitecture.data.model.tvshow.TvShow
import com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasource.TvShowCacheDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowCacheDataSourceImpl(
    private val tvShowDao: TvShowDao
): TvShowCacheDataSource {
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToCache(tvshows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvshows)
        }
    }
}