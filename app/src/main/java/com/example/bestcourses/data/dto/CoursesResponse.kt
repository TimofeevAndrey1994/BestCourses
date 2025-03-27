package com.example.bestcourses.data.dto


import com.google.gson.annotations.SerializedName

data class CoursesResponse(
    @SerializedName("courses")
    val courses: List<CourseDTO?>? = null
) : Response()