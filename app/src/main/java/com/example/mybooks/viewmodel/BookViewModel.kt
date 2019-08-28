package com.example.mybooks.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mybooks.model.Book

class BookViewModel: ViewModel() {
    private val bookTitle = MutableLiveData<String>()
    private val bookIsbn = MutableLiveData<String>()
    private val bookPageCount = MutableLiveData<Int>()
    private val bookDescription = MutableLiveData<String>()
    private val bookStatus = MutableLiveData<String>()
    private val bookAuthors = MutableLiveData<List<String>>()
    private val bookCategories = MutableLiveData<List<String>>()

    fun bind(book: Book) {
        bookTitle.value = book.title
        bookIsbn.value = book.isbn
        bookPageCount.value = book.pageCount
        bookDescription.value = book.longDescription
        bookStatus.value = book.status
        bookAuthors.value = book.authors
        bookCategories.value = book.categories
    }

    fun getBookTitle(): MutableLiveData<String> {
        return bookTitle
    }

    fun getBookIsbn(): MutableLiveData<String> {
        return bookIsbn
    }

    fun getBookPageCount(): MutableLiveData<String> {
        var mutablePageCount = MutableLiveData<String>()
        mutablePageCount.value = bookPageCount.value.toString()
        return mutablePageCount
    }

    fun getBookDescription(): MutableLiveData<String> {
        return bookDescription
    }

    fun getBookStatus(): MutableLiveData<String> {
        return bookStatus
    }

    fun getBookAuthors(): MutableLiveData<String> {
        var authors = ""
        if (bookAuthors.value != null) {
            for (author in bookAuthors.value!!) {
                authors += author
                if (author != bookAuthors.value?.last()) {
                    authors += ", "
                }
            }
        }
        val mutableAuthors = MutableLiveData<String>()
        mutableAuthors.value = authors
        return mutableAuthors
    }

    fun getBookCategories(): MutableLiveData<String> {
        var categories = ""
        if (bookCategories.value != null) {
            for (category in bookCategories.value!!) {
                categories += category
                if (category != bookCategories.value?.last()) {
                    categories += ", "
                }
            }
        }
        val mutableAuthors = MutableLiveData<String>()
        mutableAuthors.value = categories
        return mutableAuthors
    }
}