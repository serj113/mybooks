package com.example.mybooks

import com.example.mybooks.model.Book
import com.example.mybooks.viewmodel.BookViewModel
import junit.framework.Assert.assertEquals
import org.junit.Test
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.junit.Before
import org.junit.Rule
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class BookViewModelUnitTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()
    private val observer: Observer<String> = mock()
    var bookVM: BookViewModel = BookViewModel()

    inline fun <reified T> mock(): T = mock(T::class.java)

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `test bind book`() {
        // Given
        val book = Book(
            "buku",
            "123",
            100,
            "thumbnail",
            "short",
            "long",
            "PUBLISHED",
            listOf(),
            listOf()
        )

        // When
        bookVM.bind(book)

        // Then
        assertEquals("buku", bookVM.getBookTitle().value)
    }

    @Test
    fun `test bind book 2`() {
        // Given
        val book = Book(
            "buku",
            "123",
            100,
            "thumbnail",
            "short",
            "long",
            "PUBLISHED",
            listOf(),
            listOf()
        )
        bookVM.getBookIsbn().observeForever(observer)

        // When
        bookVM.bind(book)

        // Then
        val captor = ArgumentCaptor.forClass(String::class.java)
        captor.run {
            verify(observer, times(1)).onChanged(capture())
            assertEquals("123", value)
        }
    }
}