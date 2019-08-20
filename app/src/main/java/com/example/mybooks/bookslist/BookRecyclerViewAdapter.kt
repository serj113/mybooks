package com.example.mybooks.bookslist

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mybooks.model.Book
import kotlinx.android.synthetic.main.fragment_book_list.view.*
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.Glide
import androidx.databinding.DataBindingUtil
import com.example.mybooks.R
import com.example.mybooks.databinding.FragmentBookListBinding


class BookRecyclerViewAdapter(
    private val mValues: List<Book>,
    private val onClickItem: ((Book) -> Unit)?
) : RecyclerView.Adapter<BookRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: FragmentBookListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.fragment_book_list, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        Glide.with(holder.itemView.context)
            .load(item.thumbnailUrl)
            .apply(RequestOptions().override(55, 55))
            .into(holder.itemView.book_image)

        holder.bind(item)
        holder.itemView.setOnClickListener { onClickItem?.invoke(item) }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(private val binding: FragmentBookListBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = BookListViewModel()

        fun bind(book: Book) {
            viewModel.bind(book)
            binding.viewModel = viewModel
        }
    }
}
