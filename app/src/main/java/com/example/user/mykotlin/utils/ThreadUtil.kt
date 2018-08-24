package com.example.user.mykotlin.utils

import android.os.Handler
import android.os.Looper

object ThreadUtil {
    val handle  = Handler(Looper.getMainLooper());
    fun runOnMainThread(runnable:Runnable){
          handle.post(runnable)
    }
}