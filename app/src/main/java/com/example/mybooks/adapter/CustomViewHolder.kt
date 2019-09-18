package com.example.mybooks.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.mybooks.databinding.FragmentBookListBinding
import com.example.mybooks.model.Book
import com.example.mybooks.viewmodel.BookViewModel

interface CustomViewHolder {
    fun bind(book: Book)
}