package com.example.tmdb_cleanarchitecture.data.repository.artist.datasourceImpl

import com.example.tmdb_cleanarchitecture.data.model.artist.Artist
import com.example.tmdb_cleanarchitecture.data.repository.artist.datasource.ArtistCacheDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistCacheDataSourceImpl(): ArtistCacheDataSource {

    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistList.clear()
            artistList = ArrayList(artists)
        }
    }
}