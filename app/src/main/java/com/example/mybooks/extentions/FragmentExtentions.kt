package com.example.mybooks.extentions

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment

fun Fragment.setTitle(title: String) {
    activity?.title = title
}

fun Fragment.goTo(directions: NavDirections) {
    NavHostFragment.findNavController(this).navigate(directions)
}