package com.example.user.mykotlin.ui.fragment

import android.view.View
import com.example.user.mykotlin.R
import com.example.user.mykotlin.adapter.MvPagerAdapter
import com.example.user.mykotlin.base.BaseFragment
import com.example.user.mykotlin.presenter.impl.MvPresenterImpl
import com.example.user.mykotlin.view.MvView
import com.itheima.player.model.bean.MvAreaBean
import kotlinx.android.synthetic.main.mv_fragment.*

class MVFragment : BaseFragment(), MvView {

    val presenter by lazy { MvPresenterImpl(this) }

    override fun onErro(msg: String?) {
       myToast("加载失败")
    }

    override fun loadSuccess(result: List<MvAreaBean>) {
        myToast("加载数据成功")
        //在Fragment中管里Fragment需要用childFragmentManager
        val adapter = MvPagerAdapter(context,result,childFragmentManager)
        viewPager.adapter = adapter
        tableLayout.setupWithViewPager(viewPager)
    }


    override fun initView(): View? {
        return View.inflate(context, R.layout.mv_fragment, null)
    }

    override fun initData() {
        //加载网络数据
       presenter.loadData()

    }

    override fun initListener() {

    }
}