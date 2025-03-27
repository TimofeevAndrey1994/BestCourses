package com.example.bestcourses.domain.api

import com.example.bestcourses.domain.model.Course
import kotlinx.coroutines.flow.Flow

interface CoursesInteractor {
    fun getCourses(): Flow<List<Course>?>
}