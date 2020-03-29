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
import com.sampleapp.databinding.FragmentDeveloperBinding
import com.sampleapp.homePage.adapter.DevRvAdapter
import com.sampleapp.homePage.model.developerModel.DeveloperModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class DeveloperFragment : DaggerFragment() {

    private lateinit var mViewBinding: FragmentDeveloperBinding

    @Inject
    lateinit var mApiInterface: ApiInterface
    var mViewModel: HomeViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewBinding = FragmentDeveloperBinding.inflate(inflater)
        mViewBinding.progress = true
        return mViewBinding.root
    }


    fun getAdapter() : DevRvAdapter? {
        return if(mViewBinding.rv.adapter is DevRvAdapter) mViewBinding.rv.adapter as DevRvAdapter else null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory(mApiInterface)
        mViewModel = ViewModelProviders.of(this,factory).get(HomeViewModel::class.java)
        mViewModel?.makeDevCall(true)
        mViewModel?.mDevModel?.observe(this,androidx.lifecycle.Observer {
            mViewBinding.progress = false
            if(it.status == Status.S)
                it.data?.let { it1 -> setData(it1) }
            else if(it.status == Status.E)
                handleErr()
        })
    }

    private fun handleErr() {
        context?.let { ContextCompat.getColor(it, R.color.white) }?.let {
            Snackbar.make(mViewBinding.parentLyt,getString(R.string.something_went_wrong),Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(R.string.retry),object :View.OnClickListener{
                    override fun onClick(v: View?) {
                        mViewModel?.makeDevCall(true)
                    }
                })
                .setActionTextColor(it)
                .show()
        }
    }


    private fun setData(t: ArrayList<DeveloperModel>) {
        val itemDecor = DividerItemDecoration(activity, ClipDrawable.HORIZONTAL)
        mViewBinding.rv.adapter = DevRvAdapter(t)
        mViewBinding.rv.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mViewBinding.rv.addItemDecoration(itemDecor)
    }
}
