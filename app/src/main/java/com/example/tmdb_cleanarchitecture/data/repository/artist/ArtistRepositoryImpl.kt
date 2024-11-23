package com.example.tmdb_cleanarchitecture.data.repository.artist

import android.util.Log
import com.example.tmdb_cleanarchitecture.data.model.artist.Artist
import com.example.tmdb_cleanarchitecture.data.model.movie.Movie
import com.example.tmdb_cleanarchitecture.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdb_cleanarchitecture.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdb_cleanarchitecture.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.example.tmdb_cleanarchitecture.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistCacheDataSource: ArtistLocalDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistRemoteDataSource: ArtistRemoteDataSource

) :ArtistRepository{

    override suspend fun getArtists(): List<Artist> {
        return getArtistsFromAPI()
    }

    override suspend fun updateArtists(): List<Artist> {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistCacheDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToDB(newListOfArtists)

        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList:List<Artist>

        try {

            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if(body!=null){
                artistList = body.artists!!
            }

        }catch (e:Exception){
            Log.i("MyTag",e.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList:List<Artist>

        try {
            artistList = artistLocalDataSource.getArtistsFromDB()

        }catch (e:Exception){
            Log.i("MyTag",e.message.toString())
        }

        if (artistList.isNotEmpty()){
            return artistList
        }else{
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }

        return artistList
    }


    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList:List<Artist>

        try {
            artistList = artistCacheDataSource.getArtistsFromDB()

        }catch (e:Exception){
            Log.i("MyTag",e.message.toString())
        }

        if (artistList.isNotEmpty()){
            return artistList
        }else{
            artistList = getArtistsFromAPI()
            artistCacheDataSource.saveArtistsToDB(artistList)
        }

        return artistList
    }

}