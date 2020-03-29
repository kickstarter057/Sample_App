package com.example.myapplication

import com.sampleapp.di.DaggerAppComponant
import com.sampleapp.di.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MyApp: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponant.builder().networkModule(NetworkModule(this)).build()
    }
}