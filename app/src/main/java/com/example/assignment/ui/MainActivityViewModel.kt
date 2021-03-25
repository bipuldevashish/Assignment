package com.example.assignment.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment.models.UserDetails
import com.example.assignment.repository.Repository
import kotlinx.coroutines.launch

class MainActivityViewModel(private val repository: Repository): ViewModel() {

    val response: MutableLiveData<UserDetails> = MutableLiveData()

        fun getUserDetails(){
            viewModelScope.launch {
                val apiResponse: UserDetails = repository.getUserDetails()
                response.value = apiResponse
            }
        }

}