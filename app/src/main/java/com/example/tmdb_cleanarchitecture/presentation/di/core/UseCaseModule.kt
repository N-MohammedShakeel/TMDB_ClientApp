package com.example.tmdb_cleanarchitecture.presentation.di.core

import com.example.tmdb_cleanarchitecture.domain.repository.ArtistRepository
import com.example.tmdb_cleanarchitecture.domain.repository.MovieRepository
import com.example.tmdb_cleanarchitecture.domain.repository.TvShowRepository
import com.example.tmdb_cleanarchitecture.domain.usecase.GetArtistUseCase
import com.example.tmdb_cleanarchitecture.domain.usecase.GetMovieUseCase
import com.example.tmdb_cleanarchitecture.domain.usecase.GetTvShowsUseCase
import com.example.tmdb_cleanarchitecture.domain.usecase.UpdateArtistsUseCase
import com.example.tmdb_cleanarchitecture.domain.usecase.UpdateMoviesUseCase
import com.example.tmdb_cleanarchitecture.domain.usecase.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMovieUseCase{
        return GetMovieUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository):GetTvShowsUseCase{
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository):UpdateTvShowsUseCase{
        return UpdateTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository):GetArtistUseCase{
        return GetArtistUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository):UpdateArtistsUseCase{
        return UpdateArtistsUseCase(artistRepository)
    }
}