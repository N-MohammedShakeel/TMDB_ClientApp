package com.example.tmdb_cleanarchitecture.presentation.di.movie

import com.example.tmdb_cleanarchitecture.domain.usecase.GetMovieUseCase
import com.example.tmdb_cleanarchitecture.domain.usecase.UpdateMoviesUseCase
import com.example.tmdb_cleanarchitecture.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
       getMovieUseCase: GetMovieUseCase,
       updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMovieUseCase,updateMoviesUseCase)
    }
}