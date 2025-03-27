package com.example.bestcourses.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bestcourses.data.db.dao.FavouriteCourseDao
import com.example.bestcourses.data.db.entity.CourseEntity

@Database(version = 1, entities = [CourseEntity::class])
abstract class AppDataBase: RoomDatabase() {
    abstract fun getCourseDao(): FavouriteCourseDao
}