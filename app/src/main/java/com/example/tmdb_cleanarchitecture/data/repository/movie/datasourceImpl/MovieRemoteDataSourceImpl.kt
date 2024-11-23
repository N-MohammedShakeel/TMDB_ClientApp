package com.example.tmdb_cleanarchitecture.data.repository.movie.datasourceImpl

import com.example.tmdb_cleanarchitecture.data.api.TMDBService
import com.example.tmdb_cleanarchitecture.data.model.movie.MovieList
import com.example.tmdb_cleanarchitecture.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val TMDBService: TMDBService,
    private val apiKey:String
): MovieRemoteDataSource {

//    override suspend fun getMovies(): Response<MovieList> {
//        return TMDBService.getPopularMovies(apiKey)
//    }

    // The above code is enhanced to a more kotlin way
    override suspend fun getMovies(): Response<MovieList> = TMDBService.getPopularMovies(apiKey)

}