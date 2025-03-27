package com.example.bestcourses.presentation.di

import com.example.bestcourses.presentation.FavouriteScreenViewModel
import com.example.bestcourses.presentation.MainScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel {
        MainScreenViewModel(get())
    }
    viewModel {
        FavouriteScreenViewModel(get())
    }
}