package com.example.mybooks.extentions

import androidx.fragment.app.Fragment

fun Fragment.setTitle(title: String) {
    activity?.title = title
}