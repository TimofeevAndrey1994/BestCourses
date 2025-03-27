package com.example.bestcourses.domain.api

import com.example.bestcourses.domain.model.Course
import com.example.bestcourses.domain.model.Resource
import kotlinx.coroutines.flow.Flow

interface CoursesRepository {
    fun getCourses(): Flow<Resource<List<Course>>>
}