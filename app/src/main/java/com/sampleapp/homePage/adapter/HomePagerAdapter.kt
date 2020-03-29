package com.sampleapp.homePage.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class HomePagerAdapter(
    private val mListFragment: ArrayList<Fragment>,
    mFm: FragmentManager,
    private val titles: ArrayList<String>
) : FragmentStatePagerAdapter(mFm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    override fun getItem(position: Int): Fragment {
        return mListFragment.get(position)
    }

    fun getCurrentFragment() : ArrayList<Fragment>? = mListFragment

    override fun getCount(): Int {
        return mListFragment.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

}