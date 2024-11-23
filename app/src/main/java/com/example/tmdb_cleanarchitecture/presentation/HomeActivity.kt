package com.example.tmdb_cleanarchitecture.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.tmdb_cleanarchitecture.R
import com.example.tmdb_cleanarchitecture.databinding.ActivityHomeBinding
import com.example.tmdb_cleanarchitecture.presentation.artist.ArtistActivity
import com.example.tmdb_cleanarchitecture.presentation.movie.MovieActivity
import com.example.tmdb_cleanarchitecture.presentation.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var homeBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = DataBindingUtil.setContentView(this , R.layout.activity_home)

        homeBinding.movieButton.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        homeBinding.tvshowButton.setOnClickListener {
            val intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)
        }

        homeBinding.artistButton.setOnClickListener {
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }

    }
}