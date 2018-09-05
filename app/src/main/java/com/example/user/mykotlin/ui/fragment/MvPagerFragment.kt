package com.example.user.mykotlin.ui.fragment

import com.example.user.mykotlin.adapter.MvListAdapter
import com.example.user.mykotlin.base.BaseListAdapter
import com.example.user.mykotlin.base.BaseListFragment
import com.example.user.mykotlin.base.BaseListPresenter
import com.example.user.mykotlin.presenter.impl.MvListPresenterImpl
import com.example.user.mykotlin.view.MvListView
import com.example.user.mykotlin.widget.MvItemView
import com.itheima.player.model.bean.MvPagerBean
import com.itheima.player.model.bean.VideosBean

/**
 * mv界面每一个Fragment
 */
class MvPagerFragment : BaseListFragment<MvPagerBean,VideosBean,MvItemView>(), MvListView {
    var code : String? = null

    override fun init() {
        code = arguments?.getString("args")
    }
    override fun getSpecialAdapter(): BaseListAdapter<VideosBean, MvItemView> {
        return MvListAdapter()
    }

    override fun getSpecialPresenter(): BaseListPresenter {
        return MvListPresenterImpl(code!!,this)
    }

    override fun getList(response: MvPagerBean?): List<VideosBean>? {
        return response?.videos
    }

}