package com.example.tmdb_cleanarchitecture.domain.repository

import com.example.tmdb_cleanarchitecture.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>
    suspend fun updateTvShows(): List<TvShow>
}