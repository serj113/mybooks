package com.example.mybooks.bookdetail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide

import com.example.mybooks.R
import com.example.mybooks.databinding.BookDetailFragmentBinding
import com.example.mybooks.model.Book
import com.example.mybooks.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.book_detail_fragment.*

class BookDetailFragment : Fragment() {

    private lateinit var viewModel: BookViewModel
    private lateinit var book: Book

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: BookDetailFragmentBinding = DataBindingUtil.inflate(layoutInflater, R.layout.book_detail_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)
        if (arguments != null) {
            book = BookDetailFragmentArgs.fromBundle(arguments!!).book ?: Book("", "", 0, "", "", "")
        }
        viewModel.bind(book)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (context != null) {
            Glide.with(context!!)
                .load(book.thumbnailUrl)
                .into(book_thumbnail)
        }
    }
}
