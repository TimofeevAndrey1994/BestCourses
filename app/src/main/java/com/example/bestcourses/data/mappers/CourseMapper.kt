package com.example.bestcourses.data.mappers

import com.example.bestcourses.data.dto.CourseDTO
import com.example.bestcourses.domain.model.Course

class CourseMapper {
    fun map(course: CourseDTO): Course {
        return Course(
            course.hasLike,
            course.id,
            course.price,
            course.publishDate,
            course.rate,
            course.startDate,
            course.text,
            course.title
        )
    }
}