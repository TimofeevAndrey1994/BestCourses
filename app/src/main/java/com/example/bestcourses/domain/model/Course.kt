package com.example.bestcourses.domain.model


import com.google.gson.annotations.SerializedName

data class Course(
    @SerializedName("hasLike")
    val hasLike: Boolean? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("price")
    val price: String? = null,
    @SerializedName("publishDate")
    val publishDate: String? = null,
    @SerializedName("rate")
    val rate: String? = null,
    @SerializedName("startDate")
    val startDate: String? = null,
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("title")
    val title: String? = null
)