package com.example.bestcourses.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bestcourses.domain.api.CoursesInteractor
import com.example.bestcourses.domain.model.Course
import com.example.bestcourses.presentation.state.ScreenState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MainScreenViewModel(private val coursesInteractor: CoursesInteractor) : ViewModel() {

    private val screenState = MutableLiveData<ScreenState>()
    fun observeScreenState(): LiveData<ScreenState> = screenState

    private val _updateItem = MutableSharedFlow<Pair<Course, Int>>()
    val updateItem: SharedFlow<Pair<Course, Int>> = _updateItem.asSharedFlow()

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

    fun onLike(course: Course, position: Int) {
        viewModelScope.launch {
            if (course.hasLike == true) {
                course.hasLike = false
                coursesInteractor.deleteCourseFromFavouriteTable(course)
            } else {
                course.hasLike = true
                coursesInteractor.saveCourseToFavouriteDb(course)
            }
            _updateItem.emit(Pair(course, position))
        }
    }
}