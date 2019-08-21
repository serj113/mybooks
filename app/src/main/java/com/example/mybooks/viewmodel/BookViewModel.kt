package com.example.mybooks.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mybooks.model.Book

class BookViewModel: ViewModel() {
    private val bookTitle = MutableLiveData<String>()
    private val bookIsbn = MutableLiveData<String>()
    private val bookDescription = MutableLiveData<String>()

    fun bind(book: Book) {
        bookTitle.value = book.title
        bookIsbn.value = book.isbn
        bookDescription.value = book.shortDescription
    }

    fun getBookTitle(): MutableLiveData<String> {
        return bookTitle
    }

    fun getBookIsbn(): MutableLiveData<String> {
        return bookIsbn
    }

    fun getBookDescription(): MutableLiveData<String> {
        return bookDescription
    }
}