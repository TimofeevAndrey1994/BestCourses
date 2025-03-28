package com.example.bestcourses.domain.model

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T, message: String?): Resource<T>(data, message)
    class Error<T>(message: String?): Resource<T>(message = message)
}