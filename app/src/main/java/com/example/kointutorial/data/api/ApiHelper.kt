package com.example.kointutorial.data.api

import com.example.kointutorial.data.model.User
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers(): Response<List<User>>
}