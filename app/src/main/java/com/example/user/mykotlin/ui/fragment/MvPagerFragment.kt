package com.example.user.mykotlin.ui.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.example.user.mykotlin.base.BaseFragment

/**
 * mv界面每一个
 */
class MvPagerFragment : BaseFragment() {

    var name : String? = null
    override fun init() {
        //获取传递的数据
        name = arguments?.getString("args")
    }

    override fun initView(): View? {
       // val view = View.inflate(context, R.layout.pager_fragment, null)

        val tv = TextView(context)
        tv.gravity = Gravity.CENTER
        tv.setTextColor(Color.RED)
        tv.text = javaClass.simpleName+name
        return tv
    }

}