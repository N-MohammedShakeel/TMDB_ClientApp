package com.example.tmdb_cleanarchitecture.data.repository.artist.datasourceImpl

import com.example.tmdb_cleanarchitecture.data.api.TMDBService
import com.example.tmdb_cleanarchitecture.data.model.artist.ArtistList
import com.example.tmdb_cleanarchitecture.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val TMDBService: TMDBService,
    private val apiKey:String
):ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return TMDBService.getPopularArtists(apiKey)
    }
}