package com.example.bestcourses.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bestcourses.domain.api.CoursesInteractor
import com.example.bestcourses.presentation.state.ScreenState
import kotlinx.coroutines.launch

class MainScreenViewModel(private val coursesInteractor: CoursesInteractor) : ViewModel() {

    private val screenState = MutableLiveData<ScreenState>()
    fun observeScreenState(): LiveData<ScreenState> = screenState

    fun getCourses() {
        viewModelScope.launch {
            screenState.postValue(ScreenState.Loading)
            coursesInteractor.getCourses().collect { courses ->
                if (!courses.isNullOrEmpty()) {
                    screenState.postValue(ScreenState.Content(courses))
                } else {
                    screenState.postValue(ScreenState.Error)
                }
            }
        }
    }

}