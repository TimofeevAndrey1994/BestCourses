package com.example.bestcourses.data.mappers

import com.example.bestcourses.data.db.entity.CourseEntity
import com.example.bestcourses.domain.model.Course

class FavouriteCourseMapper {
    fun map(courseEntity: CourseEntity): Course {
        return Course(
            courseEntity.hasLike,
            courseEntity.id,
            courseEntity.price,
            courseEntity.publishDate,
            courseEntity.rate,
            courseEntity.startDate,
            courseEntity.text,
            courseEntity.title
        )
    }

    fun map(course: Course): CourseEntity {
        return CourseEntity(
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