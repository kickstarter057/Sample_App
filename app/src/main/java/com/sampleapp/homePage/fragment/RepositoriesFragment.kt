package com.sampleapp.homePage.fragment

import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sampleapp.homePage.viewModel.HomeViewModel
import com.sampleapp.homePage.viewModel.ViewModelFactory
import com.sampleapp.networkManager.ApiInterface
import com.sampleapp.utils.Status
import com.google.android.material.snackbar.Snackbar
import com.sampleapp.R
import com.sampleapp.databinding.FragmentRepositoriesBinding
import com.sampleapp.homePage.adapter.RepoRvAdapter
import com.sampleapp.homePage.model.repoModel.HomepageModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class Repositories : DaggerFragment() {


    private lateinit var mViewBinding: FragmentRepositoriesBinding

    @Inject
    lateinit var mApiInterface: ApiInterface
    var mViewModel: HomeViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewBinding = FragmentRepositoriesBinding.inflate(inflater)
        mViewBinding.progress = true
        return mViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory =  ViewModelFactory(mApiInterface)
        mViewModel = ViewModelProviders.of(this,factory).get(HomeViewModel::class.java)
        mViewModel?.makeRepoCall(true)
        mViewModel?.mRepoModel?.observe(this,androidx.lifecycle.Observer {
            mViewBinding.progress = false
            if(it.status == Status.S)
                it.data?.let { it1 -> setData(it1) }
            else if(it.status == Status.E)
                handleErr()
        })
    }

    private fun handleErr() {
        context?.let { ContextCompat.getColor(it, R.color.white) }?.let {
            Snackbar.make(mViewBinding.parentLyt,getString(R.string.something_went_wrong), Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(R.string.retry),object :View.OnClickListener{
                    override fun onClick(v: View?) {
                        mViewModel?.makeRepoCall(true)
                    }
                })
                .setActionTextColor(it)
                .show()
        }
    }


    fun getAdapter() : RepoRvAdapter? {
        return if(mViewBinding.rv.adapter is RepoRvAdapter) mViewBinding.rv.adapter as RepoRvAdapter else null
    }


    private fun setData(t: ArrayList<HomepageModel>) {
        val itemDecor = DividerItemDecoration(activity, ClipDrawable.HORIZONTAL)
        mViewBinding.rv.adapter = RepoRvAdapter(t)
        mViewBinding.rv.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mViewBinding.rv.addItemDecoration(itemDecor)
    }
}
