package com.futuneotech.freneoh.utils

import android.util.Log
import com.futuneotech.freneoh.BuildConfig

fun dLog(tag: String = "", message: Any = "") {
    if (BuildConfig.DEBUG)
        Log.d("hackino$tag", "$message")
}

fun eLog(tag: String = "", message: Any = "") {
    if (BuildConfig.DEBUG)
        Log.e("hackino$tag", "$message")
}
