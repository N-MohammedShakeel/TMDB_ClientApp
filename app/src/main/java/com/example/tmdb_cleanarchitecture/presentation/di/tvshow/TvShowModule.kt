package com.example.tmdb_cleanarchitecture.presentation.di.tvshow

import com.example.tmdb_cleanarchitecture.domain.usecase.GetTvShowsUseCase
import com.example.tmdb_cleanarchitecture.domain.usecase.UpdateTvShowsUseCase
import com.example.tmdb_cleanarchitecture.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase,updateTvShowsUseCase)
    }
}