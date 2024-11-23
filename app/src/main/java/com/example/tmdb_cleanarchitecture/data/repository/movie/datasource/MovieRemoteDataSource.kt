package com.example.tmdb_cleanarchitecture.data.repository.movie.datasource

import com.example.tmdb_cleanarchitecture.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}