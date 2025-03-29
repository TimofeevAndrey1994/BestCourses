package com.example.bestcourses.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bestcourses.domain.api.OpenLinkUseCase
import com.example.bestcourses.ui.utils.Constants

class EnterScreenViewModel(private val openLinkUseCase: OpenLinkUseCase) : ViewModel() {

    private val buttonEnterState = MutableLiveData<Boolean>()
    fun observeButtonEnterState(): LiveData<Boolean> = buttonEnterState

    fun checkValidEnterData(email: String?, password: String?) {
        val value = isValidEmail(email ?: "") and (!password.isNullOrEmpty())
        buttonEnterState.postValue(value)
    }

    private fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        return email.matches(emailRegex.toRegex())
    }

    fun openVk() {
        openLinkUseCase.openLink(Constants.VK_LINK)
    }

    fun openOk() {
        openLinkUseCase.openLink(Constants.OK_LINK)
    }

}