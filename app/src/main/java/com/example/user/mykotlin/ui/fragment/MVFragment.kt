package com.example.user.mykotlin.ui.fragment

import android.view.View
import com.example.user.mykotlin.R
import com.example.user.mykotlin.base.BaseFragment

class MVFragment : BaseFragment() {
    override fun initView(): View? {
        return View.inflate(context, R.layout.mv_fragment,null)
    }
}