package com.sampleapp.homePage.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sampleapp.R
import com.sampleapp.databinding.RepoDetailsBinding
import com.sampleapp.utils.setToolbar

class RepoDetails : AppCompatActivity() {

    private lateinit var mActivityBinding : RepoDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityBinding = DataBindingUtil.setContentView(this, R.layout.repo_details)
        setToolbar(mActivityBinding.toolbar.findViewById(R.id.toolbar),"Sample App")
    }
}
