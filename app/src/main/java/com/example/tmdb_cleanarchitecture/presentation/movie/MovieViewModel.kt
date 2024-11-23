package com.example.tmdb_cleanarchitecture.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb_cleanarchitecture.domain.usecase.GetMovieUseCase
import com.example.tmdb_cleanarchitecture.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMovieUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
):ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}