package com.sampleapp.homePage.activity

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.sampleapp.R
import com.sampleapp.databinding.ActivityMainBinding
import com.sampleapp.homePage.adapter.HomePagerAdapter
import com.sampleapp.homePage.fragment.DeveloperFragment
import com.sampleapp.homePage.fragment.Repositories
import com.sampleapp.utils.setToolbar
import dagger.android.support.DaggerAppCompatActivity


class MainActivity : DaggerAppCompatActivity() {

    private lateinit var mActivityBinding: ActivityMainBinding
    private var mAdapter : HomePagerAdapter? = null
    private var mRepoFragment : Repositories? =null
    private var mDeveloperFragment : DeveloperFragment? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setToolbar(mActivityBinding.toolbar.findViewById(R.id.toolbar),"Sample App")
        initView()
    }

    private fun initView() {
        mRepoFragment = Repositories()
        mDeveloperFragment = DeveloperFragment()
        setUpViewPager()
    }

    private fun setUpViewPager() {
        val list = ArrayList<Fragment>()
        val titles = ArrayList<String>()
        titles.add(getString(R.string.repo))
        titles.add(getString(R.string.dev))
        mRepoFragment?.let { list.add(it) }
        mDeveloperFragment?.let { list.add(it) }
        mAdapter = HomePagerAdapter(list,supportFragmentManager,titles)
        mActivityBinding.pager.adapter = mAdapter
        mActivityBinding.tabLyt.setupWithViewPager(mActivityBinding.pager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home,menu)
        val mgr = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.search)?.actionView as SearchView
        searchView.setSearchableInfo(mgr.getSearchableInfo(componentName))
        searchView.queryHint = getString(R.string.search_dev_repo)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchUser(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchUser(newText)
                return true
            }
        })

        return true
    }

    private fun searchUser(query:String?) {

        if(mAdapter?.getCurrentFragment()?.get(mActivityBinding.pager.currentItem) is DeveloperFragment)
            mDeveloperFragment?.getAdapter()?.filter?.filter(query)

        if(mAdapter?.getCurrentFragment()?.get(mActivityBinding.pager.currentItem) is Repositories)
            mRepoFragment?.getAdapter()?.filter?.filter(query)
    }

}


