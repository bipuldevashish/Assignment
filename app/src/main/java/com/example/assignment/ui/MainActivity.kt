package com.example.assignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.assignment.R
import com.example.assignment.repository.Repository

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)
        viewModel.getUserDetails()
        viewModel.response.observe(this, Observer { response ->

            if (response.isSuccessful) {
                Log.d(TAG, "onCreate: " + (response.body()?.data?.size))
            }

        })
    }
}