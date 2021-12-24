package com.example.kointutorial.di.module

import com.example.kointutorial.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


    val viewModelModule = module {
        viewModel {
            MainViewModel(get(),get())
        }
    }
