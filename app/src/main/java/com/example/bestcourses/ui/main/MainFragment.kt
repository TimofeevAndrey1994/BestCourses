package com.example.bestcourses.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bestcourses.databinding.FragmentMainBinding
import com.example.bestcourses.presentation.MainScreenViewModel
import com.example.bestcourses.presentation.state.ScreenState
import com.example.bestcourses.ui.base.BaseFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragmentBinding<FragmentMainBinding> (){

    private val mainScreenViewModel: MainScreenViewModel by viewModel()

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainScreenViewModel.getCourses()
        mainScreenViewModel.observeScreenState().observe(viewLifecycleOwner) { state ->
            renderState(state)
        }
    }

    private fun renderState(state: ScreenState){
        when(state){
            is ScreenState.Content -> TODO()
            ScreenState.Error -> TODO()
            ScreenState.Loading -> TODO()
        }
    }

}