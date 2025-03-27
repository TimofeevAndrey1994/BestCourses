package com.example.bestcourses.domain.impl

import com.example.bestcourses.domain.api.CoursesInteractor
import com.example.bestcourses.domain.api.CoursesRepository
import com.example.bestcourses.domain.model.Course
import com.example.bestcourses.domain.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class CoursesInteractorImpl(private val coursesRepository: CoursesRepository) : CoursesInteractor {
    override fun getCourses(): Flow<List<Course>?> {
        return coursesRepository.getCourses().map { resourse ->
            when (resourse) {
                is Resource.Error -> null
                is Resource.Success -> resourse.data
            }
        }
    }

    override suspend fun saveCourseToFavouriteDb(course: Course) {
        coursesRepository.saveCourseToFavouriteTable(course)
    }

    override suspend fun deleteCourseFromFavouriteTable(course: Course) {
        coursesRepository.deleteCourseFromFavouriteTable(course)
    }

    override fun getFavouriteCourses(): Flow<List<Course>> {
        return coursesRepository.getAllFavouriteCourses()
            .map {resource ->
                when(resource){
                    is Resource.Error -> {
                        emptyList()
                    }
                    is Resource.Success -> resource.data ?: emptyList()
                }
            }
    }
}