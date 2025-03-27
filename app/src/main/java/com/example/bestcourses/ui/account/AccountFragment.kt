package com.example.bestcourses.ui.account

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.bestcourses.databinding.FragmentAccountBinding
import com.example.bestcourses.ui.base.BaseFragmentBinding

class AccountFragment : BaseFragmentBinding<FragmentAccountBinding>() {

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAccountBinding {
        return FragmentAccountBinding.inflate(inflater, container, false)
    }

}