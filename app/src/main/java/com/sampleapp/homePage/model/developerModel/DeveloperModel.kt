package com.sampleapp.homePage.model.developerModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DeveloperModel {
    var err:Boolean = false
    @SerializedName("username")
    @Expose
    var username: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("avatar")
    @Expose
    var avatar: String? = null
    @SerializedName("repo")
    @Expose
    var repo: Repo? = null
    @SerializedName("sponsorUrl")
    @Expose
    var sponsorUrl: String? = null

}