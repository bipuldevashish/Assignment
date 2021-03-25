package com.example.assignment.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class UserDetails(
    val page: Int,                  //   shows the current page number
    val per_page: Int,             //    shows the number of photos returned with each page
    val total_results: Int,
    val userData: List<Users>
) : Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        TODO("userData")
    ) {
    }

    data class Users(
        val id: Int,
        val email: String?,
        val first_name: String?,
        val last_name: String?,
        val avatar: String?
    ): Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeInt(id)
            parcel.writeString(email)
            parcel.writeString(first_name)
            parcel.writeString(last_name)
            parcel.writeString(avatar)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Users> {
            override fun createFromParcel(parcel: Parcel): Users {
                return Users(parcel)
            }

            override fun newArray(size: Int): Array<Users?> {
                return arrayOfNulls(size)
            }
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(page)
        parcel.writeInt(per_page)
        parcel.writeInt(total_results)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserDetails> {
        override fun createFromParcel(parcel: Parcel): UserDetails {
            return UserDetails(parcel)
        }

        override fun newArray(size: Int): Array<UserDetails?> {
            return arrayOfNulls(size)
        }
    }
}


