package com.example.tmdb_cleanarchitecture.data.repository.movie

import android.util.Log
import com.example.tmdb_cleanarchitecture.data.model.movie.Movie
import com.example.tmdb_cleanarchitecture.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdb_cleanarchitecture.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdb_cleanarchitecture.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdb_cleanarchitecture.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {

    override suspend fun getMovies(): List<Movie> = getMoviesFromCache()

    override suspend fun updateMovies(): List<Movie> {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            movieList = body?.movies ?: ArrayList()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        return movieList
    }

    private suspend fun getMoviesFromDB(): List<Movie> {
        var movieList = movieLocalDataSource.getMoviesFromDB()
        if (movieList.isEmpty()) {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        var movieList = movieCacheDataSource.getMoviesFromCache()
        if (movieList.isEmpty()) {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}