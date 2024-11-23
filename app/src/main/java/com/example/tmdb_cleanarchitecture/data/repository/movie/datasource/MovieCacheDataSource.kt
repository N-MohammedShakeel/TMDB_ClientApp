package com.example.tmdb_cleanarchitecture.data.repository.movie.datasource

import com.example.tmdb_cleanarchitecture.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)
}