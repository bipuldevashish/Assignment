package com.example.assignment.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.assignment.R

object Utils {

    fun ImageView.loadImage(uri: String?) {
        val options = RequestOptions()
            .placeholder(R.drawable.ic_user)
            .circleCrop()
            .error(R.mipmap.ic_launcher_round)
        Glide.with(this.context)
            .setDefaultRequestOptions(options)
            .load(uri)
            .into(this)
    }

}