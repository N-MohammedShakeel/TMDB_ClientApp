package com.example.tmdb_cleanarchitecture.domain.repository

import com.example.tmdb_cleanarchitecture.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>
    suspend fun updateMovies(): List<Movie>
}