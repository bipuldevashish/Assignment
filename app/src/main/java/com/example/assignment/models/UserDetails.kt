package com.example.assignment.models

data class  UserDetails(

    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<Users> = emptyList(),
    val support : Support

)






