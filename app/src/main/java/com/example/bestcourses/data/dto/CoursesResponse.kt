package com.example.bestcourses.data.dto

import com.example.bestcourses.domain.model.CourseDTO

data class CoursesResponse(val courses: List<CourseDTO>): Response()
