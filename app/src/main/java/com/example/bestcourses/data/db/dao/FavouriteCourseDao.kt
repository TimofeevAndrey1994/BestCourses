package com.example.bestcourses.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bestcourses.data.db.entity.CourseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteCourseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCourseToFavouriteTable(courseEntity: CourseEntity)
    @Query("DELETE FROM favourite_courses WHERE id=:courseId")
    suspend fun deleteCourseFromFavouriteTable(courseId: Int)
    @Query("SELECT * FROM favourite_courses")
    fun getFavouriteCourses(): Flow<List<CourseEntity>>
    @Query("SELECT * FROM favourite_courses WHERE id=:courseId")
    suspend fun getFavouriteCourseById(courseId: Int): CourseEntity?
}
