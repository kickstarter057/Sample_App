package com.sampleapp.utils

class LiveDataWrapper<T>(t:T?,status: Status){
    var data : T ? =t
    var status : Status? = status

    companion object {
        fun <T> success(t:T,status: Status) : LiveDataWrapper<T> = LiveDataWrapper(t,status)
        fun <T> error(t:T?,status: Status) : LiveDataWrapper<T> = LiveDataWrapper(t,status)
    }
}

enum class Status {
    S,
    E
}