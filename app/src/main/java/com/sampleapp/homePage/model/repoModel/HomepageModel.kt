package com.sampleapp.homePage.model.repoModel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class HomepageModel : BaseObservable() {

    var err:Boolean = false
    @SerializedName("author")
    @Expose
    var author: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("avatar")
    @Expose
    var avatar: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("stars")
    @Expose
    var stars: Int? = null
    @SerializedName("forks")
    @Expose
    var forks: Int? = null
    @SerializedName("currentPeriodStars")
    @Expose
    var currentPeriodStars: Int? = null
    @SerializedName("builtBy")
    @Expose
    var builtBy: List<BuiltBy>? = null
    @SerializedName("language")
    @Expose
    var language: String? = null
    @SerializedName("languageColor")
    @Expose
    var languageColor: String? = null
}
