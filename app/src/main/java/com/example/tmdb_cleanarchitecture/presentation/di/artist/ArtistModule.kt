package com.example.tmdb_cleanarchitecture.presentation.di.artist

import com.example.tmdb_cleanarchitecture.domain.usecase.GetArtistUseCase
import com.example.tmdb_cleanarchitecture.domain.usecase.UpdateArtistsUseCase
import com.example.tmdb_cleanarchitecture.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ):ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistUseCase,updateArtistsUseCase)
    }
}