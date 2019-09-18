package com.example.mybooks.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.mybooks.databinding.FragmentBookListRightBinding
import com.example.mybooks.model.Book
import com.example.mybooks.viewmodel.BookViewModel

class BookRightViewHolder(private val binding: FragmentBookListRightBinding) : RecyclerView.ViewHolder(binding.root), CustomViewHolder {
    private val viewModel = BookViewModel()

    override fun bind(book: Book) {
        viewModel.bind(book)
        binding.viewModel = viewModel
    }
}