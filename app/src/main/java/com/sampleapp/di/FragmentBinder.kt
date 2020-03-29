package com.sampleapp.di

import com.sampleapp.homePage.fragment.DeveloperFragment
import com.sampleapp.homePage.fragment.Repositories
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBinder {

    @ContributesAndroidInjector
    abstract fun RepositoriesInjector(): Repositories

    @ContributesAndroidInjector
    abstract fun DeveloperFragmentInjector(): DeveloperFragment
}