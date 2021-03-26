package com.example.assignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R
import com.example.assignment.repository.Repository

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: MainActivityViewModel
    lateinit var userListAdaptor: UserListAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userListAdaptor = UserListAdaptor()
        recyclerView = findViewById(R.id.recycler_view)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = userListAdaptor
        }

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)
        viewModel.getUserDetails()
        viewModel.response.observe(this, Observer { response ->

            if (response.isSuccessful) {
                Log.d(TAG, "onCreate: " + (response.body()?.data))

                response.body()?.data?.let { userListAdaptor.setData(it) }
            }

        })
    }
}