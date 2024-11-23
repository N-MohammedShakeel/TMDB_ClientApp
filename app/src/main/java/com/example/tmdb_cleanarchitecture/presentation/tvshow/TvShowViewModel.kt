package com.example.tmdb_cleanarchitecture.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb_cleanarchitecture.domain.usecase.GetArtistUseCase
import com.example.tmdb_cleanarchitecture.domain.usecase.GetTvShowsUseCase
import com.example.tmdb_cleanarchitecture.domain.usecase.UpdateArtistsUseCase
import com.example.tmdb_cleanarchitecture.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModel() {

    fun getTvShows() = liveData{
        val tvshowsList = getTvShowsUseCase.execute()
        emit(tvshowsList)
    }

    fun updateTvShows() = liveData{
        val tvshowsList = updateTvShowsUseCase.execute()
        emit(tvshowsList)
    }
}