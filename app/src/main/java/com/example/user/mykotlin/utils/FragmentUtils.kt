package com.example.user.mykotlin.utils

import com.example.user.mykotlin.R
import com.example.user.mykotlin.base.BaseFragment
import com.example.user.mykotlin.ui.fragment.HomeFragment
import com.example.user.mykotlin.ui.fragment.MVFragment
import com.example.user.mykotlin.ui.fragment.VBangFragment
import com.example.user.mykotlin.ui.fragment.YueDanFragment

/**
 * ClassName:FragmentUtil
 * Description:管理fragment的util类
 */
class FragmentUtils private constructor(){//私有化构造方法
    val homeFragment by lazy { HomeFragment() }
    val mvFragment by lazy { MVFragment() }
    val vBangFragment by lazy { VBangFragment() }
    val yueDanFragment by lazy { YueDanFragment() }

    //半生对象 相当于java中的静态
    companion object {
        val fragmentUtils by lazy { FragmentUtils() }
    }



    fun getFragment(tabId : Int):BaseFragment?{
        when(tabId){
            R.id.tab_home -> return homeFragment
            R.id.tab_mv   -> return mvFragment
            R.id.tab_vbang-> return vBangFragment
            R.id.tab_yuedan -> return yueDanFragment
        }
        return null
    }
}