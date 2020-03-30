package com.sampleapp.homePage.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.sampleapp.R
import com.sampleapp.databinding.RepoDetailsBinding
import com.sampleapp.utils.BindingAdapter
import com.sampleapp.utils.setToolbar

class RepoDetails : AppCompatActivity() {

    private lateinit var mActivityBinding : RepoDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityBinding = DataBindingUtil.setContentView(this, R.layout.repo_details)
        setToolbar(mActivityBinding.toolbar.findViewById(R.id.toolbar),intent.getStringExtra("name"),true,true)
        initData()
    }

    private fun initData() {
        BindingAdapter.loadImageDetails(mActivityBinding.image,intent.getStringExtra("url"))
        mActivityBinding.desc.text = intent.getStringExtra("desc")
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
