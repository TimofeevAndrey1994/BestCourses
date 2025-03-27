package com.example.bestcourses.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.bestcourses.databinding.FragmentMainBinding
import com.example.bestcourses.presentation.MainScreenViewModel
import com.example.bestcourses.presentation.state.ScreenState
import com.example.bestcourses.ui.base.BaseFragmentBinding
import com.example.bestcourses.ui.recycler_view.CourseAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragmentBinding<FragmentMainBinding>() {

    private val mainScreenViewModel: MainScreenViewModel by viewModel()

    private val adapter = CourseAdapter()

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.setOnBookmarkClickListener { course, pos ->
            mainScreenViewModel.onLike(course, pos)
        }
        binding.rvCourses.adapter = adapter

        binding.tvByDate.setOnClickListener {
            mainScreenViewModel.sortCoursesByDate()
        }

        mainScreenViewModel.observeScreenState().observe(viewLifecycleOwner) { state ->
            renderState(state)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                mainScreenViewModel.updateItem.collect { pair ->
                    adapter.updateItem(pair.second, pair.first)
                }
            }
        }
    }

    private fun renderState(state: ScreenState) {
        when (state) {
            is ScreenState.Content -> {
                adapter.addAll(state.courses)
            }

            ScreenState.Error -> {}
            ScreenState.Loading -> {}
        }
    }
}