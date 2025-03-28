package com.example.bestcourses.domain.model


import com.google.gson.annotations.SerializedName

data class Course(
    var hasLike: Boolean? = null,
    val id: Int? = null,
    val price: String? = null,
    val publishDate: String? = null,
    val rate: String? = null,
    val startDate: String? = null,
    val text: String? = null,
    val title: String? = null
)