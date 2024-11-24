package com.example.tmdb_cleanarchitecture.presentation.movie

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdb_cleanarchitecture.R
import com.example.tmdb_cleanarchitecture.databinding.ActivityMovieBinding
import com.example.tmdb_cleanarchitecture.presentation.di.Injector
import jakarta.inject.Inject


class MovieActivity : AppCompatActivity() {

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter
    private lateinit var binding: ActivityMovieBinding

    @Inject
    lateinit var factory: MovieViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)

        // Inject dependencies using the Injector interface
        (application as Injector).createMovieSubComponent().inject(this)

        // Initialize ViewModel with the factory
        movieViewModel = ViewModelProvider(this,factory).get(MovieViewModel::class.java)

        // Initialize RecyclerView
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE

        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer { movieList ->
            if (movieList != null) {
                adapter.setList(movieList)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }
}
