package com.sampleapp.homePage.model.developerModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Repo {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null

}