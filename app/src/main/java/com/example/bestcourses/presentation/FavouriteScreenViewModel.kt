package com.example.bestcourses.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bestcourses.domain.api.CoursesInteractor
import com.example.bestcourses.domain.model.Course
import com.example.bestcourses.presentation.state.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavouriteScreenViewModel(private val coursesInteractor: CoursesInteractor) : ViewModel() {

    private val _uiState = MutableStateFlow<ScreenState>(ScreenState.Loading)
    val uiState: StateFlow<ScreenState> = _uiState

    init {
        viewModelScope.launch {
            _uiState.value = ScreenState.Loading
            coursesInteractor.getFavouriteCourses().collect { courses ->
                _uiState.value = ScreenState.Content(courses)
            }
        }
    }

    fun onLike(course: Course) {
        viewModelScope.launch {
            if (course.hasLike == true) {
                course.hasLike = false
                coursesInteractor.deleteCourseFromFavouriteTable(course)
            } else {
                course.hasLike = true
                coursesInteractor.saveCourseToFavouriteDb(course)
            }
        }
    }
}
