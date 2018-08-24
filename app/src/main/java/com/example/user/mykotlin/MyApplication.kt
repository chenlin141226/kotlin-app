package com.example.user.mykotlin

import android.app.Application

class MyApplication : Application() {

    //半生对象
    companion object {//相当于 java 中的 静态
        private var instance :MyApplication? = null

        fun instance() = instance!! //公共访问方法
    }

    override fun onCreate() {
        super.onCreate()
        instance = this  //赋值
    }
}