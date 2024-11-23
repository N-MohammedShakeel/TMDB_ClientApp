package com.example.tmdb_cleanarchitecture.domain.usecase

import com.example.tmdb_cleanarchitecture.data.model.movie.Movie
import com.example.tmdb_cleanarchitecture.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()

}