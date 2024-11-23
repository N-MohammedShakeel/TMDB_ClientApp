package com.example.tmdb_cleanarchitecture.data.repository.artist.datasource

import com.example.tmdb_cleanarchitecture.data.model.artist.Artist


interface ArtistLocalDataSource {

    suspend fun getArtistsFromDB():List<Artist>
    suspend fun saveArtistsToDB(artists: List<Artist>)
    suspend fun clearAll()
}