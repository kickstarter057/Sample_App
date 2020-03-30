package com.sampleapp.homePage.handler

import android.content.Context
import android.content.Intent
import com.sampleapp.homePage.activity.RepoDetails
import com.sampleapp.homePage.model.developerModel.DeveloperModel

class DevRvHandler(val mContext:Context) {

    fun startDetailsActivity(data: DeveloperModel) {
        val intent = Intent(mContext,RepoDetails::class.java)
        intent.putExtra("url",data.avatar)
        intent.putExtra("name",data.name)
        intent.putExtra("desc",data.username)
        mContext.startActivity(intent)
    }
}