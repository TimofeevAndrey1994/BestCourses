package com.example.bestcourses.data.impl

import com.example.bestcourses.data.db.AppDataBase
import com.example.bestcourses.data.dto.CourseRequest
import com.example.bestcourses.data.dto.CoursesResponse
import com.example.bestcourses.data.mappers.CourseMapper
import com.example.bestcourses.data.mappers.FavouriteCourseMapper
import com.example.bestcourses.data.network.NetworkClient
import com.example.bestcourses.domain.api.CoursesRepository
import com.example.bestcourses.domain.model.Course
import com.example.bestcourses.domain.model.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.withContext

class CoursesRepositoryImpl(
    private val networkClient: NetworkClient,
    private val courseMapper: CourseMapper,
    private val dataBase: AppDataBase,
    private val favouriteCourseMapper: FavouriteCourseMapper
) : CoursesRepository {
    override fun getCourses(): Flow<Resource<List<Course>>> {
        return flow {
            val response = networkClient.doRequest(CourseRequest())
            when (response.resultCode) {
                200 -> {
                    val courses = (response as CoursesResponse).courses?.map { courseMapper.map(it!!) }
                    courses?.forEach {
                        val courseEntity = dataBase.getCourseDao().getFavouriteCourseById(it.id ?: -1)
                        if (courseEntity != null) it.hasLike = true  else it.hasLike = false
                    }
                    emit(Resource.Success(courses ?: emptyList() , null))
                }
                else -> emit(Resource.Error(null))
            }
        }
    }

    override fun getAllFavouriteCourses(): Flow<Resource<List<Course>>> {
        return dataBase.getCourseDao().getFavouriteCourses()
            .map { it.map { courseEntity -> favouriteCourseMapper.map(courseEntity) } }
            .transform { courses -> emit(Resource.Success(courses, null)) }
    }

    override suspend fun saveCourseToFavouriteTable(course: Course) {
        dataBase.getCourseDao().saveCourseToFavouriteTable(favouriteCourseMapper.map(course))
    }

    override suspend fun deleteCourseFromFavouriteTable(course: Course) {
        dataBase.getCourseDao().deleteCourseFromFavouriteTable(course.id ?: -1)
    }
}

