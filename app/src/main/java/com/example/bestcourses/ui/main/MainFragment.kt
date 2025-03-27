package com.example.bestcourses.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.bestcourses.databinding.FragmentMainBinding
import com.example.bestcourses.ui.base.BaseFragmentBinding

class MainFragment : BaseFragmentBinding<FragmentMainBinding> (){

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater, container, false)
    }

}