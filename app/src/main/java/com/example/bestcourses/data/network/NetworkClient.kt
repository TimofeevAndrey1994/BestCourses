package com.example.bestcourses.data.network

import com.example.bestcourses.data.dto.Response

interface NetworkClient {
    suspend fun doRequest(dto: Any): Response
}