package com.sampleapp.utils

import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.sampleapp.R

fun <A : AppCompatActivity> A.setToolbar(toolbar:Toolbar,title:String) {
    toolbar.findViewById<TextView>(R.id.title).text=title
    setSupportActionBar(toolbar)
}

fun <A:AppCompatActivity> A.showToast(msg:String?) {
    Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
}

fun <R: RecyclerView> R.setAdapter(lambda:()->Unit) {
    this.apply { lambda }
}
