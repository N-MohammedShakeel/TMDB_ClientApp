package com.example.tmdb_cleanarchitecture.data.repository.artist.datasource

import com.example.tmdb_cleanarchitecture.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>

}