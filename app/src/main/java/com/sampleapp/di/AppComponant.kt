package com.sampleapp.di

import com.example.myapplication.MyApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class, NetworkModule::class,
    ActivityBinder::class, FragmentBinder::class))
interface AppComponant :AndroidInjector<MyApp>{

    @Component.Builder
    interface Builder{

        fun networkModule(networkModule: NetworkModule): Builder

        fun build(): AppComponant
    }
}