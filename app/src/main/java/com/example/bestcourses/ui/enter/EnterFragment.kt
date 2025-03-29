package com.example.bestcourses.ui.enter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.bestcourses.R
import com.example.bestcourses.databinding.FragmentEnterBinding
import com.example.bestcourses.presentation.EnterScreenViewModel
import com.example.bestcourses.ui.base.BaseFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class EnterFragment : BaseFragmentBinding<FragmentEnterBinding>() {

    private val enterScreenViewModel: EnterScreenViewModel by viewModel()

    private var textWatcher: TextWatcher? = null

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEnterBinding {
        return FragmentEnterBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                with(binding){
                    enterScreenViewModel.checkValidEnterData(etEmail.text.toString(), etPassword.text.toString())
                }
            }
            override fun afterTextChanged(s: Editable?) {}
        }

        with(binding) {
            etEmail.addTextChangedListener(textWatcher)
            etPassword.addTextChangedListener(textWatcher)
            btnEnter.setOnClickListener {
                findNavController().navigate(R.id.action_enterFragment_to_mainFragment)
            }
            btnVk.setOnClickListener {
                enterScreenViewModel.openVk()
            }
            btkOk.setOnClickListener {
                enterScreenViewModel.openOk()
            }
            enterScreenViewModel.observeButtonEnterState().observe(viewLifecycleOwner) { value ->
                btnEnter.isEnabled = value
            }
        }
    }
}