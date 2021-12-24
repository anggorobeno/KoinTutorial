package com.example.kointutorial.di.module

import com.example.kointutorial.data.repository.MainRepository
import org.koin.dsl.module


    val repoModule = module {
        single {
            MainRepository(get())
        }
    }
