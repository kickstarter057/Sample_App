package com.sampleapp.homePage.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sampleapp.homePage.model.developerModel.DeveloperModel
import com.sampleapp.homePage.model.repoModel.HomepageModel
import com.sampleapp.networkManager.ApiInterface
import com.sampleapp.utils.LiveDataWrapper
import com.sampleapp.utils.Status
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

object HomePageRepo {

    fun makeDevCall(mApiInterface: ApiInterface) : LiveData<LiveDataWrapper<ArrayList<DeveloperModel>>> {
        val model = MutableLiveData<LiveDataWrapper<ArrayList<DeveloperModel>>> ()
        mApiInterface.getDevRepo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ArrayList<DeveloperModel>> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: ArrayList<DeveloperModel>) {
                    if (!t.isNullOrEmpty()) {
                        model.value = LiveDataWrapper.success(t, Status.S)
                    }
                }

                override fun onError(e: Throwable) {
                    model.value = LiveDataWrapper.error(null, Status.E)
                }
            })

        return model
    }

    fun makeRepoCall(mApiInterface: ApiInterface) : LiveData<LiveDataWrapper<ArrayList<HomepageModel>>> {
            val model = MutableLiveData<LiveDataWrapper<ArrayList<HomepageModel>>>()
            mApiInterface.getRepo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ArrayList<HomepageModel>> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(t: ArrayList<HomepageModel>) {
                        if (!t.isNullOrEmpty()) {
                            model.value = LiveDataWrapper(t, Status.S)
                        }
                    }

                    override fun onError(e: Throwable) {
                        model.value = LiveDataWrapper(null, Status.E)
                    }
                })

            return model
    }

}