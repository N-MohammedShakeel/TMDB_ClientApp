package com.example.tmdb_cleanarchitecture.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdb_cleanarchitecture.domain.usecase.GetMovieUseCase
import com.example.tmdb_cleanarchitecture.domain.usecase.UpdateMoviesUseCase

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMovieUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            return MovieViewModel(getMoviesUseCase, updateMoviesUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}