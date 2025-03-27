package com.example.bestcourses.ui.utils

import android.app.Application
import com.example.bestcourses.data.di.dataModule
import com.example.bestcourses.data.di.networkModule
import com.example.bestcourses.domain.di.domainModule
import com.example.bestcourses.presentation.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(dataModule, domainModule, viewModelsModule, networkModule)
        }
    }
}