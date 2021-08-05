package com.example.shoeapp

import android.os.Parcelable

@androidx.room.Entity()
data class Shoe (

    var name: String,
    var size: Double,
    var company: String,
    var description: String
)
