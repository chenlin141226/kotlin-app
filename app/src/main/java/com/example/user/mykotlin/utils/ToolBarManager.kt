package com.example.user.mykotlin.utils

import android.content.Intent
import android.support.v7.widget.Toolbar
import com.example.user.mykotlin.R
import com.example.user.mykotlin.ui.activity.SettingActivity

interface ToolBarManager {
     val toolbar: Toolbar

    /**
     * MainActivity
     */
    fun initMainToolBar(){
        //标题
        toolbar.setTitle(R.string.main_titlebar)
        //设置按钮
        toolbar.inflateMenu(R.menu.main)
        //kotlin 和java调用特性
        //如果java接口中只有一个未实现的方法  可以省略接口对象 直接用{}表示未实现的方法
        toolbar.setOnMenuItemClickListener{
            toolbar.context.startActivity(Intent(toolbar.context,SettingActivity::class.java))
            true
        }
    }


    /**
     * SettingActivity
     */
    fun initSettingToolBar(){
        toolbar.setTitle(R.string.setting_titlebar)
    }

}