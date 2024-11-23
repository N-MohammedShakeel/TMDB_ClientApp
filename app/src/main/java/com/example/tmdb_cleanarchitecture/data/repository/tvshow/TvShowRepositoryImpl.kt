package com.example.tmdb_cleanarchitecture.data.repository.tvshow

import android.util.Log
import com.example.tmdb_cleanarchitecture.data.model.tvshow.TvShow
import com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import com.example.tmdb_cleanarchitecture.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import com.example.tmdb_cleanarchitecture.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val TvShowRemoteDataSourceImpl: TvShowRemoteDataSourceImpl,
    private val TvShowLocalDataSourceImpl: TvShowLocalDataSourceImpl,
    private val TvShowCacheDataSourceImpl: TvShowCacheDataSourceImpl
):TvShowRepository {

    override suspend fun getTvShows(): List<TvShow> {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow> {
        val newListOfTvShowss = getTvShowsFromAPI()
        TvShowLocalDataSourceImpl.clearAll()
        TvShowCacheDataSourceImpl.saveTvShowsToCache(newListOfTvShowss)
        TvShowCacheDataSourceImpl.saveTvShowsToCache(newListOfTvShowss)

        return newListOfTvShowss
    }

    suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var TvShowList:List<TvShow>

        try {

            val response = TvShowRemoteDataSourceImpl.getTvShows()
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
            TvShowList = TvShowLocalDataSourceImpl.getTvShowsFromDB()

        }catch (e:Exception){
            Log.i("MyTag",e.message.toString())
        }

        if (TvShowList.isNotEmpty()){
            return TvShowList
        }else{
            TvShowList = getTvShowsFromAPI()
            TvShowLocalDataSourceImpl.saveTvShowsToDB(TvShowList)
        }

        return TvShowList
    }


    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var TvShowList:List<TvShow>

        try {
            TvShowList = TvShowCacheDataSourceImpl.getTvShowsFromCache()

        }catch (e:Exception){
            Log.i("MyTag",e.message.toString())
        }

        if (TvShowList.isNotEmpty()){
            return TvShowList
        }else{
            TvShowList = getTvShowsFromDB()
            TvShowCacheDataSourceImpl.saveTvShowsToCache(TvShowList)
        }

        return TvShowList
    }


}