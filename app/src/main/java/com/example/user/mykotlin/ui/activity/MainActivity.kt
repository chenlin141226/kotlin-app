package com.example.user.mykotlin.ui.activity

import android.support.v7.widget.Toolbar
import com.example.user.mykotlin.R
import com.example.user.mykotlin.utils.FragmentUtils
import com.example.user.mykotlin.utils.ToolBarManager
import com.itheima.player.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.find

class MainActivity : BaseActivity(), AnkoLogger ,ToolBarManager{
    //惰性加载
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        initMainToolBar()
    }

    override fun initListener() {
        bottomBar.setOnTabSelectListener {
            val transaction = supportFragmentManager.beginTransaction()
            //transaction.replace(R.id.container,FragmentUtil.fragmentUtil.getFragment(it)!!,it.toString())
            FragmentUtils.fragmentUtils.getFragment(it)?.let { it1 -> transaction.replace(R.id.container, it1,it.toString()) }
            transaction.commit()
        }
    }

}
