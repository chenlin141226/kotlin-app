package com.example.user.mykotlin.adapter

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.user.mykotlin.ui.fragment.MvPagerFragment
import com.itheima.player.model.bean.MvAreaBean

class MvPagerAdapter(val context: Context?, val list: List<MvAreaBean>, fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        //传递数据到每一个Fragment界面中
        //第一种传递方式
        //val fragment = MvPagerFragment()
        val bundle = Bundle()
        bundle.putString("args", list.get(position).code)
       // fragment.arguments = bundle


        //第二中传递方式
        val fragment = Fragment.instantiate(context,MvPagerFragment::class.java.name,bundle)
        return fragment
    }

    override fun getCount(): Int {
        return list?.size ?: 0
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return list.get(position).name
    }
}