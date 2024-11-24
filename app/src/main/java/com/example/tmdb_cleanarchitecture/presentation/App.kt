package com.example.tmdb_cleanarchitecture.presentation

import android.app.Application
import com.example.tmdb_cleanarchitecture.BuildConfig
import com.example.tmdb_cleanarchitecture.presentation.di.Injector
import com.example.tmdb_cleanarchitecture.presentation.di.artist.ArtistSubComponent
import com.example.tmdb_cleanarchitecture.presentation.di.core.AppComponent
import com.example.tmdb_cleanarchitecture.presentation.di.core.AppModule
import com.example.tmdb_cleanarchitecture.presentation.di.core.DaggerAppComponent
import com.example.tmdb_cleanarchitecture.presentation.di.core.NetModule
import com.example.tmdb_cleanarchitecture.presentation.di.core.RemoteDataModule
import com.example.tmdb_cleanarchitecture.presentation.di.movie.MovieSubComponent
import com.example.tmdb_cleanarchitecture.presentation.di.tvshow.TvShowSubComponent

class App :Application(),Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        // Need to build project before importing DaggerAppComponent
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}