package com.example.bestcourses.domain.di

import com.example.bestcourses.domain.api.CoursesInteractor
import com.example.bestcourses.domain.impl.CoursesInteractorImpl
import org.koin.dsl.module

val domainModule = module {
    single<CoursesInteractor> {
       CoursesInteractorImpl(get())
    }
}