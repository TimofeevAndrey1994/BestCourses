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
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class MainScreenViewModel(private val coursesInteractor: CoursesInteractor) : ViewModel() {

    private var coursesList: List<Course> = emptyList()

    private val screenState = MutableLiveData<ScreenState>()
    fun observeScreenState(): LiveData<ScreenState> = screenState

    private val _updateItem = MutableSharedFlow<Pair<Course, Int>>()
    val updateItem: SharedFlow<Pair<Course, Int>> = _updateItem.asSharedFlow()

    init {
        getCourses()
    }

    private fun getCourses() {
        viewModelScope.launch {
            screenState.postValue(ScreenState.Loading)
            coursesInteractor.getCourses().collect { courses ->
                if (!courses.isNullOrEmpty()) {
                    coursesList = courses
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
                coursesList[position].hasLike = false
                coursesInteractor.deleteCourseFromFavouriteTable(course)
            } else {
                coursesList[position].hasLike = true
                course.hasLike = true
                coursesInteractor.saveCourseToFavouriteDb(course)
            }
            _updateItem.emit(Pair(course, position))
        }
    }

    fun sortCoursesByDate() {
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale("ru"))
        coursesList = coursesList.sortedWith(compareBy { formatter.parse(it.startDate) })
        screenState.postValue(ScreenState.Content(coursesList))
    }
}