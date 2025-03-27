package com.example.bestcourses.data.db.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "favourite_courses")
data class CourseEntity(
    val hasLike: Boolean? = null,
    @PrimaryKey
    val id: Int? = null,
    val price: String? = null,
    val publishDate: String? = null,
    val rate: String? = null,
    val startDate: String? = null,
    val text: String? = null,
    val title: String? = null
)