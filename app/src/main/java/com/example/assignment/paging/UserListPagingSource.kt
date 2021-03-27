package com.example.assignment.paging

import android.util.Log
import androidx.paging.PagingSource
import com.example.assignment.api.ApiService
import com.example.assignment.models.Users
import retrofit2.HttpException
import java.io.IOException

private const val USERS_STARTING_PAGE_INDEX = 1
private const val TAG = "UserListPagingSource"

class UserListPagingSource(
    private val api: ApiService
) : PagingSource<Int, Users>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Users> {
        val position = params.key ?: USERS_STARTING_PAGE_INDEX

        return try {
            val response = api.getUserDetails(position, params.loadSize)
            val users = response.data
            Log.d(TAG, "load: ${users}")
            LoadResult.Page(
                data = users,
                prevKey = if (position == USERS_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (users.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

}