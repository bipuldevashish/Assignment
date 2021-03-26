package com.example.assignment.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R
import com.example.assignment.models.Users
import com.example.assignment.util.Utils.loadImage

private const val TAG = "UserListAdaptor"

class UserListAdaptor: RecyclerView.Adapter<UserListAdaptor.UserListViewHolder>() {

    private var data = emptyList<Users>()


    inner class UserListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val imageView = itemView.findViewById<ImageView>(R.id.circular_imageView)
        private val userName = itemView.findViewById<TextView>(R.id.tv_name)
        private val userEmail = itemView.findViewById<TextView>(R.id.tv_email)

        fun bind(data: Users) {
            userName.text = data.first_name + " " + data.last_name
            userEmail.text = data.email
            imageView.loadImage(data.avatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        return UserListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user_details,parent,false))
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {

        val currentItem = data[position]

        for(item in data){
        }
            holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount: ${data.size}")
        return data.size
    }

    fun setData(data: List<Users>){
        this.data = data
        notifyDataSetChanged()
    }

}