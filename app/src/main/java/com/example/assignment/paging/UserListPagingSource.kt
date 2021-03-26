package com.example.assignment.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.assignment.api.ApiService
import com.example.assignment.models.UserDetails

private const val USERS_STARTING_PAGE_INDEX = 1


//class UserListPagingSource(
//    private val api: ApiService
//) : PagingSource<Int, UserDetails>() {
//    override fun getRefreshKey(state: PagingState<Int, UserDetails>): Int? {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserDetails> {
//            val position = params.key ?: USERS_STARTING_PAGE_INDEX
//            val response = api.getUserDetails(position, params.loadSize)
//    }
//
//}