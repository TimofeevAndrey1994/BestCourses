package com.example.bestcourses.ui.splash

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.bestcourses.databinding.FragmentSplashBinding
import com.example.bestcourses.ui.base.BaseFragmentBinding

class SplashFragment : BaseFragmentBinding<FragmentSplashBinding>() {

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(inflater, container, false)
    }

}