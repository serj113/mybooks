package com.example.mybooks.bookslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.example.mybooks.R
import com.example.mybooks.extentions.goTo
import com.example.mybooks.extentions.setTitle
import com.example.mybooks.model.Book
import com.google.gson.reflect.TypeToken
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.fragment_book_item_list.*
import java.io.IOException


class BooksListFragment : Fragment() {

    private var booksJson = ""
    private lateinit var moshi: Moshi
    private lateinit var jsonAdapter: JsonAdapter<List<Book>>
    private var books: List<Book> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
        loadJson()
        moshi = Moshi.Builder().build()
        val type = object : TypeToken<List<Book>>() {}.type
        jsonAdapter = moshi.adapter(type)
        jsonAdapter.fromJson(booksJson)?.let {
            books = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setTitle("List of Books")
        return inflater.inflate(R.layout.fragment_book_item_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = BookRecyclerViewAdapter(books) { book ->
            goToBookDetail(book)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.book_list_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_about) {
            goToAbout()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun goToAbout() {
        goTo(BooksListFragmentDirections.actionBooksListFragmentToAboutFragment())
    }

    private fun goToBookDetail(book: Book) {
        val directions = BooksListFragmentDirections.actionBooksListFragmentToBookDetailFragment()
        directions.arguments.putParcelable("book", book)
        goTo(directions)
    }

    private fun loadJson() {
        try {
            val `is` = context?.assets?.open("books.json")
            val size = `is`?.available()
            size?.let {
                val buffer = ByteArray(size)
                `is`?.read(buffer)
                booksJson = String(buffer)
            }
            `is`?.close()
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }
}
