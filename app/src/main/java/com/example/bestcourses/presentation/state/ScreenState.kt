package com.example.bestcourses.presentation.state

import com.example.bestcourses.domain.model.Course

sealed class ScreenState {
    class Content(val courses: List<Course>) : ScreenState()
    data object Error : ScreenState()
    data object Loading : ScreenState()
}