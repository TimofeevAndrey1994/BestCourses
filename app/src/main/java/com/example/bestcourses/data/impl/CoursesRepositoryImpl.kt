package com.example.bestcourses.data.impl

import com.example.bestcourses.data.dto.CourseRequest
import com.example.bestcourses.data.dto.CoursesResponse
import com.example.bestcourses.data.mappers.CourseMapper
import com.example.bestcourses.data.network.NetworkClient
import com.example.bestcourses.domain.api.CoursesRepository
import com.example.bestcourses.domain.model.Course
import com.example.bestcourses.domain.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CoursesRepositoryImpl(
    private val networkClient: NetworkClient,
    private val courseMapper: CourseMapper
) : CoursesRepository {
    override fun getCourses(): Flow<Resource<List<Course>>> {
        return flow {
            val response = networkClient.doRequest(CourseRequest())
            when (response.resultCode) {
                200 -> {
                    val courses = (response as CoursesResponse).courses
                    emit(Resource.Success(courses.map { courseMapper.map(it) }, null))
                }

                else -> emit(Resource.Error(null))
            }
        }
    }
}