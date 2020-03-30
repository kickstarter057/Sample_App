package com.sampleapp.homePage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.sampleapp.databinding.DevSingleLytBinding
import com.sampleapp.homePage.handler.DevRvHandler
import com.sampleapp.homePage.model.developerModel.DeveloperModel

class DevRvAdapter(val mList:ArrayList<DeveloperModel>) : RecyclerView.Adapter<DevRvAdapter.MyHolder>(), Filterable{
    var mTempList = ArrayList<DeveloperModel> ()

    init {
        mTempList.addAll(mList)
    }

    override fun getFilter(): Filter {

        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val list = ArrayList<DeveloperModel>()
                val res = FilterResults()
                if(!constraint?.isEmpty()!!) {
                    val text = constraint?.toString().toLowerCase().trim()
                    list.addAll(mList.filter { it.name?.toLowerCase()?.contains(text)!!})
                    res.values = list
                } else {
                    res.values = mTempList
                    res.count = mTempList.size
                }
                return res
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                mList.clear()
                mList.addAll(results?.values as List<DeveloperModel>)
                notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = DevSingleLytBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.mBinding.data= mList[position]
        holder.mBinding.handler = DevRvHandler(holder.mBinding.root.context)
        holder.mBinding.executePendingBindings()
    }


    class MyHolder (val mBinding: DevSingleLytBinding): RecyclerView.ViewHolder(mBinding.root)
}