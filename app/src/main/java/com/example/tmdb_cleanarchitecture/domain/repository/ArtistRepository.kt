package com.example.tmdb_cleanarchitecture.domain.repository

import com.example.tmdb_cleanarchitecture.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>
    suspend fun updateArtists(): List<Artist>




}