package com.example.tmdb_cleanarchitecture.presentation.di

import com.example.tmdb_cleanarchitecture.presentation.di.artist.ArtistSubComponent
import com.example.tmdb_cleanarchitecture.presentation.di.movie.MovieSubComponent
import com.example.tmdb_cleanarchitecture.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}