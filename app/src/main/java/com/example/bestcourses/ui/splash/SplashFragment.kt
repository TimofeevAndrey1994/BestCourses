package com.example.bestcourses.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.bestcourses.R
import com.example.bestcourses.databinding.FragmentSplashBinding
import com.example.bestcourses.ui.base.BaseFragmentBinding

class SplashFragment : BaseFragmentBinding<FragmentSplashBinding>() {

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnContinue.setOnClickListener{
            findNavController().navigate(R.id.action_splashFragment_to_enterFragment)
        }
    }

}