package com.example.tmdb_cleanarchitecture.domain.usecase

import com.example.tmdb_cleanarchitecture.data.model.tvshow.TvShow
import com.example.tmdb_cleanarchitecture.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.updateTvShows()
}