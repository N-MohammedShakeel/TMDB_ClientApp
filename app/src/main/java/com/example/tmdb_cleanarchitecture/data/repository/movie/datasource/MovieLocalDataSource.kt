package com.example.tmdb_cleanarchitecture.data.repository.movie.datasource

import com.example.tmdb_cleanarchitecture.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}