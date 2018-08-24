package com.itheima.player.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * ClassName:BaseActivity
 * Description:所有activity的基类
 */
abstract class BaseActivity: AppCompatActivity(),AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initListener()
        initData()
    }


    /**
     * 初始化数据
     */
    open protected fun initData() {
    }


    /**
     * adapter listener
     */
    open protected fun initListener() {
    }

    /**
     * 获取布局id
     */
    abstract fun getLayoutId(): Int

    protected fun myToast(msg : String){
       runOnUiThread { toast(msg) }
    }

    /**
     * 开启activity并且finish当前界面
     * reified 的意思是具体化。而作为 Kotlin 的一个方法 泛型 关键字，它代表你可以在方法体内访问泛型指定的JVM类对象。
     * 必须以 inline 内联方式声明这个方法才有效。
     */
    inline fun <reified T:BaseActivity>startActivityAndFinish(){
        startActivity<T>()
        finish()
    }
}