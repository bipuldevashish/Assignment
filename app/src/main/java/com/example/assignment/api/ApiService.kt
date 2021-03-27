package com.example.assignment.api

import com.example.assignment.models.UserDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/users")
    suspend fun getUserDetails(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): UserDetails
}