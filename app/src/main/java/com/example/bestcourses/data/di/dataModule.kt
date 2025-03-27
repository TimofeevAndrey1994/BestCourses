package com.example.bestcourses.data.di

import androidx.room.Room
import com.example.bestcourses.data.db.AppDataBase
import com.example.bestcourses.data.impl.CoursesRepositoryImpl
import com.example.bestcourses.data.mappers.CourseMapper
import com.example.bestcourses.data.mappers.FavouriteCourseMapper
import com.example.bestcourses.data.network.CoursesApi
import com.example.bestcourses.data.network.NetworkClient
import com.example.bestcourses.data.network.RetrofitNetworkClient
import com.example.bestcourses.domain.api.CoursesRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single<CoursesRepository> {
        CoursesRepositoryImpl(get(), get(), get(), get())
    }
    single<NetworkClient> {
        RetrofitNetworkClient(get(), get())
    }
    factory {
        CourseMapper()
    }
    factory {
        FavouriteCourseMapper()
    }
}

val networkModule = module {
    single<CoursesApi> {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://drive.usercontent.google.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(CoursesApi::class.java)
    }
}

val dataBaseModule = module {
    single {
        Room.databaseBuilder(androidApplication(), AppDataBase::class.java, "dataBase.db").build()
    }
}