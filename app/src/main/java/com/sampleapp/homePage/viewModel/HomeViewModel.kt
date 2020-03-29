package com.sampleapp.homePage.viewModel

import androidx.lifecycle.*
import com.sampleapp.homePage.model.developerModel.DeveloperModel
import com.sampleapp.homePage.model.repoModel.HomepageModel
import com.sampleapp.homePage.repo.HomePageRepo
import com.sampleapp.networkManager.ApiInterface
import com.sampleapp.utils.LiveDataWrapper

class HomeViewModel(val mApiInterface: ApiInterface) : ViewModel() {

    val mDevObservableFlag = MutableLiveData<Boolean>()
    val mDevModel:LiveData<LiveDataWrapper<ArrayList<DeveloperModel>>>
    val mRepoObservableFlag = MutableLiveData<Boolean>()
    val mRepoModel:LiveData<LiveDataWrapper<ArrayList<HomepageModel>>>

    init {
        mDevModel = Transformations.switchMap(mDevObservableFlag) {
            makeDevApiCall()
        }

        mRepoModel = Transformations.switchMap(mRepoObservableFlag) {
            makeRepoApiCall()
        }
    }

    private fun makeRepoApiCall(): LiveData<LiveDataWrapper<ArrayList<HomepageModel>>>? {
        return HomePageRepo.makeRepoCall(mApiInterface)
    }

    private fun makeDevApiCall(): LiveData<LiveDataWrapper<ArrayList<DeveloperModel>>> {
        return HomePageRepo.makeDevCall(mApiInterface)
    }

    fun makeRepoCall(flag:Boolean) {
        mRepoObservableFlag.value = flag
    }

    fun makeDevCall(flag:Boolean) {
        mDevObservableFlag.value = flag
    }

}