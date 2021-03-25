package com.example.assignment.repository

import com.example.assignment.api.RetrofitInstance
import com.example.assignment.models.UserDetails
import retrofit2.Response

class Repository {

       suspend fun getUserDetails() : Response<UserDetails> {
            return RetrofitInstance.api.getUserDetails(1)
        }

}