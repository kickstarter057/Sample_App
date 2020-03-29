package com.sampleapp.di

import com.sampleapp.homePage.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinder {

    @ContributesAndroidInjector
    abstract fun MainActivityInjector(): MainActivity
}