package com.example.bestcourses.ui.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.bestcourses.databinding.FragmentFavouritesBinding
import com.example.bestcourses.presentation.FavouriteScreenViewModel
import com.example.bestcourses.presentation.state.ScreenState
import com.example.bestcourses.ui.base.BaseFragmentBinding
import com.example.bestcourses.ui.recycler_view.CourseAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavouritesFragment : BaseFragmentBinding<FragmentFavouritesBinding>() {

    private val favouriteTracksViewModel: FavouriteScreenViewModel by viewModel()
    private val courseAdapter = CourseAdapter()

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavouritesBinding {
        return FragmentFavouritesBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        courseAdapter.setOnBookmarkClickListener { course, _ ->
            favouriteTracksViewModel.onLike(course)
        }
        binding.rvCourses.adapter = courseAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                favouriteTracksViewModel.uiState.collect { state ->
                    renderState(state)
                }
            }
        }
    }

    private fun renderState(state: ScreenState) {
        when (state) {
            is ScreenState.Content -> {
                courseAdapter.addAll(state.courses)
            }

            ScreenState.Error -> {}
            ScreenState.Loading -> {}
        }
    }
}