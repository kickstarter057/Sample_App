package com.sampleapp.homePage.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sampleapp.networkManager.ApiInterface

class ViewModelFactory(val mApiInterface: ApiInterface) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(mApiInterface) as T
    }
}