package com.example.tmdb_cleanarchitecture.domain.usecase

import com.example.tmdb_cleanarchitecture.data.model.artist.Artist
import com.example.tmdb_cleanarchitecture.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.getArtists()
}