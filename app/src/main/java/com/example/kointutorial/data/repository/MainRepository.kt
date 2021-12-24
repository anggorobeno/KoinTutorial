package com.example.kointutorial.data.repository

import com.example.kointutorial.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getUsers() =  apiHelper.getUsers()
}