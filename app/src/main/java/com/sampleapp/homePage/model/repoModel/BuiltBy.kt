package com.sampleapp.homePage.model.repoModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BuiltBy {

    @SerializedName("href")
    @Expose
    var href: String? = null
    @SerializedName("avatar")
    @Expose
    var avatar: String? = null
    @SerializedName("username")
    @Expose
    var username: String? = null

}