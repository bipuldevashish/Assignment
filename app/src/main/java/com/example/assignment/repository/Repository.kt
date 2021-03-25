package com.example.assignment.repository

import com.example.assignment.api.ApiService
import com.example.assignment.api.RetrofitInstance
import com.example.assignment.models.UserDetails

class Repository(private val apiService: ApiService) {

       suspend fun getUserDetails() :UserDetails {
            return RetrofitInstance.api.getUserDetails()
        }

}