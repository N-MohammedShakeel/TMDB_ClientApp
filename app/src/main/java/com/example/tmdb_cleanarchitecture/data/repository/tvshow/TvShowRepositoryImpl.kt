package com.example.tmdb_cleanarchitecture.data.repository.tvshow

import android.util.Log
import com.example.tmdb_cleanarchitecture.data.model.tvshow.TvShow
import com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdb_cleanarchitecture.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvshowRemoteDataSource:TvShowRemoteDataSource,
    private val tvshowLocalDataSource: TvShowLocalDataSource,
    private val tvshowCacheDataSource: TvShowCacheDataSource

):TvShowRepository {

    override suspend fun getTvShows(): List<TvShow> {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow> {
        val newListOfTvShowss = getTvShowsFromAPI()
        tvshowLocalDataSource.clearAll()
        tvshowCacheDataSource.saveTvShowsToCache(newListOfTvShowss)
        tvshowCacheDataSource.saveTvShowsToCache(newListOfTvShowss)

        return newListOfTvShowss
    }

    suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var TvShowList:List<TvShow>

        try {
            val response = tvshowRemoteDataSource.getTvShows()
            val body = response.body()
            if(body!=null){
                TvShowList = body.tvShows!!
            }

        }catch (e:Exception){
            Log.i("MyTag",e.message.toString())
        }
        return TvShowList
    }

    suspend fun getTvShowsFromDB(): List<TvShow> {
        lateinit var TvShowList:List<TvShow>

        try {
            TvShowList = tvshowLocalDataSource.getTvShowsFromDB()

        }catch (e:Exception){
            Log.i("MyTag",e.message.toString())
        }

        if (TvShowList.isNotEmpty()){
            return TvShowList
        }else{
            TvShowList = getTvShowsFromAPI()
            tvshowLocalDataSource.saveTvShowsToDB(TvShowList)
        }

        return TvShowList
    }


    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var TvShowList:List<TvShow>

        try {
            TvShowList = tvshowCacheDataSource.getTvShowsFromCache()

        }catch (e:Exception){
            Log.i("MyTag",e.message.toString())
        }

        if (TvShowList.isNotEmpty()){
            return TvShowList
        }else{
            TvShowList = getTvShowsFromDB()
            tvshowCacheDataSource.saveTvShowsToCache(TvShowList)
        }

        return TvShowList
    }


}