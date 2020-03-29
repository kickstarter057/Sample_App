package com.sampleapp.networkManager

import com.sampleapp.homePage.model.developerModel.DeveloperModel
import com.sampleapp.homePage.model.repoModel.HomepageModel
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {

    @GET(ApiConstant.REPO_API )
    fun getRepo():Observable<ArrayList<HomepageModel>>

    @GET(ApiConstant.DEV_API)
    fun getDevRepo():Observable<ArrayList<DeveloperModel>>

}