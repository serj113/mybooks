package com.example.mybooks.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mybooks.R
import com.example.mybooks.databinding.FragmentBookListRightBinding
import com.example.mybooks.model.Book
import kotlinx.android.synthetic.main.fragment_book_list_right.view.*

class RightBookViewAdapter(private val book: Book) : ViewAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding: FragmentBookListRightBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.fragment_book_list_right, parent, false)
        return BookRightViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder) {
        holder as BookRightViewHolder
        Glide.with(holder.itemView.context)
            .load(book.thumbnailUrl)
            .into(holder.itemView.book_image)
        holder.bind(book)
    }
}