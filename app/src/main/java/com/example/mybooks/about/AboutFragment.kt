package com.example.mybooks.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.mybooks.R
import com.example.mybooks.extentions.setTitle

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setTitle("About")
        return inflater.inflate(R.layout.about_fragment, container, false)
    }
}
