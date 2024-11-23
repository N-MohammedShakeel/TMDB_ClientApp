package com.example.tmdb_cleanarchitecture.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb_cleanarchitecture.domain.usecase.GetArtistUseCase
import com.example.tmdb_cleanarchitecture.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
):ViewModel() {

    fun getArtists() = liveData{
        val artistsList = getArtistsUseCase.execute()
        emit(artistsList)
    }

    fun updateArtists() = liveData{
        val artistsList = updateArtistsUseCase.execute()
        emit(artistsList)
    }
}