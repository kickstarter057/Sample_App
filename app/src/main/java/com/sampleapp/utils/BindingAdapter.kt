package com.sampleapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(img: ImageView, url: String?) {
        Glide.with(img.context.applicationContext)
            .load(url)
            .apply(RequestOptions.circleCropTransform())
            .into(img)
    }
}