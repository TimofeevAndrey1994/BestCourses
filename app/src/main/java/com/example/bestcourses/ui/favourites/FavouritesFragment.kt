package com.example.bestcourses.ui.favourites

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.bestcourses.databinding.FragmentFavouritesBinding
import com.example.bestcourses.ui.base.BaseFragmentBinding

class FavouritesFragment : BaseFragmentBinding<FragmentFavouritesBinding> () {
    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavouritesBinding {
        return FragmentFavouritesBinding.inflate(inflater, container, false)
    }
}