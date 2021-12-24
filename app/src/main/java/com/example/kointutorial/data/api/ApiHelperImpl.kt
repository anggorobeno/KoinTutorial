package com.example.kointutorial.data.api

import com.example.kointutorial.data.model.User
import retrofit2.Response

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override suspend fun getUsers(): Response<List<User>> = apiService.getUsers()
}