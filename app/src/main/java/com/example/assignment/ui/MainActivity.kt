package com.example.assignment.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R
import com.example.assignment.api.ApiService
import com.example.assignment.repository.Repository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


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

        Log.d(TAG, "onCreate: called")
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)


        viewModel.users.observe(this, Observer {
                lifecycleScope.launch {
                    userListAdaptor.submitData(it)
                }
        })
    }
}