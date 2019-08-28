package com.example.mybooks.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Book(
    var title: String,
    var isbn: String,
    var pageCount: Int,
    var thumbnailUrl: String,
    var shortDescription: String,
    var longDescription: String,
    var status: String,
    var authors: List<String>,
    var categories: List<String>
) : Parcelable