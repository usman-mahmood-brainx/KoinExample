package com.example.koinexample

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("www.google.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }
    single<MainRepository> {
        MainRepositoryImp(get())
    }
    viewModel {
        MainViewModel(get())
    }
}

val activityModule = module {
    scope<MainActivity>{
        scoped(qualifier = named("hello")) { "Hello" }
    }
}