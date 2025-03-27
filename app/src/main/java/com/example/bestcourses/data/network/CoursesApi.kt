package com.example.bestcourses.data.network

import com.example.bestcourses.data.dto.CoursesResponse
import retrofit2.http.GET

interface CoursesApi {
    @GET("/u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download")
    fun getCourses(): CoursesResponse
}