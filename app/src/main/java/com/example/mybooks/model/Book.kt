package com.example.mybooks.model

data class Book(
    var title: String,
    var isbn: String,
    var pageCount: Int,
    var thumbnailUrl: String,
    var shortDescription: String,
    var status: String
)