package com.example.mybooks.bookslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mybooks.model.Book

class BookListViewModel: ViewModel() {
    private val bookTitle = MutableLiveData<String>()
    private val bookIsbn = MutableLiveData<String>()

    fun bind(book: Book) {
        bookTitle.value = book.title
        bookIsbn.value = book.isbn
    }

    fun getBookTitle(): MutableLiveData<String> {
        return bookTitle
    }

    fun getBookIsbn(): MutableLiveData<String> {
        return bookIsbn
    }
}