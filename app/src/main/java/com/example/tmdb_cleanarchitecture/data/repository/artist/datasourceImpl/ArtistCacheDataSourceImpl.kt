package com.example.tmdb_cleanarchitecture.data.repository.artist.datasourceImpl

import com.example.tmdb_cleanarchitecture.data.db.ArtistDao
import com.example.tmdb_cleanarchitecture.data.model.artist.Artist
import com.example.tmdb_cleanarchitecture.data.repository.artist.datasource.ArtistCacheDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistCacheDataSourceImpl(
    private val artistDao: ArtistDao
): ArtistCacheDataSource {
    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }
}