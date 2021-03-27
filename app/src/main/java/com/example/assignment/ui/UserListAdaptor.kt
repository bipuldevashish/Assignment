package com.example.assignment.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R
import com.example.assignment.models.Users
import com.example.assignment.util.Utils.loadImage

private const val TAG = "UserListAdaptor"

class UserListAdaptor :
    PagingDataAdapter<Users, UserListAdaptor.UserListViewHolder>(USER_COMPARATOR) {


    companion object {
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<Users>() {
            override fun areItemsTheSame(oldItem: Users, newItem: Users): Boolean =
                oldItem == newItem


            override fun areContentsTheSame(oldItem: Users, newItem: Users): Boolean =
                oldItem == newItem

        }
    }

    inner class UserListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageView = itemView.findViewById<ImageView>(R.id.circular_imageView)
        private val userName = itemView.findViewById<TextView>(R.id.tv_name)
        private val userEmail = itemView.findViewById<TextView>(R.id.tv_email)

        fun bind(item: Users) {
            userName.text = item.first_name + " " + item.last_name
            userEmail.text = item.email
            imageView.loadImage(item.avatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        return UserListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_details, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        getItem(position)?.let { (holder as? UserListViewHolder)?.bind(item = it) }
    }




}