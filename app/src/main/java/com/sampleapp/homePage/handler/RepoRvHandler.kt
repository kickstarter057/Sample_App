package com.sampleapp.homePage.handler

import android.content.Context
import android.content.Intent
import com.sampleapp.homePage.activity.RepoDetails
import com.sampleapp.homePage.model.repoModel.HomepageModel

class RepoRvHandler(val mContext:Context) {

    fun startDetailsActivity(data: HomepageModel) {
        val intent = Intent(mContext,RepoDetails::class.java)
        intent.putExtra("url",data.avatar)
        intent.putExtra("name",data.name)
        intent.putExtra("desc",data.description)
        mContext.startActivity(intent)
    }
}