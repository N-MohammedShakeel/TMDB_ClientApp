package com.example.tmdb_cleanarchitecture.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdb_cleanarchitecture.data.model.tvshow.TvShow

@Dao
interface TvShowDao {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(movies: List<TvShow>)
    
    @Query("DELETE FROM popular_tvShows")
    suspend fun deleteAllTvShows()
    
    @Query("SELECT * FROM popular_tvShows")
    suspend fun getTvShows(): List<TvShow>
    
}