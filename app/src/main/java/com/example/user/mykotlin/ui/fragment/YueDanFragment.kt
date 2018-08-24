package com.example.user.mykotlin.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.user.mykotlin.R
import com.example.user.mykotlin.adapter.YueDanAdapter
import com.example.user.mykotlin.base.BaseFragment
import kotlinx.android.synthetic.main.home_fragment.*

class YueDanFragment : BaseFragment() {
   val adapter by lazy { YueDanAdapter() }

    override fun initView(): View? {
        return View.inflate(context, R.layout.yuedan_fragment,null)
    }

    override fun initListener() {
        recycleview.layoutManager = LinearLayoutManager(context)

        recycleview.adapter = adapter
    }
}