package com.example.assignment.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.assignment.api.ApiService
import com.example.assignment.paging.UserListPagingSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val apiService: ApiService) {

       fun getUserDetails()  =
           Pager(
               config = PagingConfig(
                   pageSize = 10,
                   maxSize = 30,
                   enablePlaceholders = false
               ),
               pagingSourceFactory = { UserListPagingSource(apiService) }
           ).liveData
}