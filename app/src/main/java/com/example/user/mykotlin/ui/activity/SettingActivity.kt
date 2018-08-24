package com.example.user.mykotlin.ui.activity

import android.support.v7.widget.Toolbar
import com.example.user.mykotlin.R
import com.example.user.mykotlin.utils.ToolBarManager
import com.itheima.player.base.BaseActivity
import org.jetbrains.anko.find

class SettingActivity : BaseActivity() ,ToolBarManager{
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    override fun getLayoutId(): Int {
        return R.layout.setting_activity
    }

    override fun initData() {
        initSettingToolBar()
    }
}