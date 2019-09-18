package com.example.mybooks.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mybooks.R
import com.example.mybooks.databinding.FragmentBookListBinding
import com.example.mybooks.model.Book
import kotlinx.android.synthetic.main.fragment_book_list.view.*

class LeftBookViewAdapter(private val book: Book) : ViewAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding: FragmentBookListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.fragment_book_list, parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder) {
        holder as BookViewHolder
        Glide.with(holder.itemView.context)
            .load(book.thumbnailUrl)
            .into(holder.itemView.book_image)
        holder.bind(book)
    }
}