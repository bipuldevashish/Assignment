package com.example.assignment.api

import com.example.assignment.models.UserDetails
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/users?page=1")
    suspend fun getUserDetails(): UserDetails
}