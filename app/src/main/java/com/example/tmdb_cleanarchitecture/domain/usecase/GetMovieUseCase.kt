package com.example.tmdb_cleanarchitecture.domain.usecase

import com.example.tmdb_cleanarchitecture.data.model.movie.Movie
import com.example.tmdb_cleanarchitecture.domain.repository.MovieRepository

class GetMovieUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.getMovies()
}