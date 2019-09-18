package com.example.mybooks.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mybooks.model.Book
import kotlinx.android.synthetic.main.fragment_book_list.view.*
import com.bumptech.glide.Glide
import androidx.databinding.DataBindingUtil
import com.example.mybooks.R
import com.example.mybooks.databinding.FragmentBookListBinding
import com.example.mybooks.viewmodel.BookViewModel


class BookRecyclerViewAdapter(
    private var mAdapters: List<ViewAdapter>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return mAdapters[viewType].onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        mAdapters[position].onBindViewHolder(holder)
        // holder.itemView.setOnClickListener { onClickItem?.invoke(item) }
    }

    override fun getItemCount(): Int = mAdapters.size

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun setAdapters(adapters: List<ViewAdapter>) {
        mAdapters = adapters
    }
}
