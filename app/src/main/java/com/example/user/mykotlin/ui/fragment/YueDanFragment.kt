package com.example.user.mykotlin.ui.fragment

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.user.mykotlin.R
import com.example.user.mykotlin.adapter.YueDanAdapter
import com.example.user.mykotlin.base.BaseFragment
import com.example.user.mykotlin.base.BaseListAdapter
import com.example.user.mykotlin.base.BaseListFragment
import com.example.user.mykotlin.base.BaseListPresenter
import com.example.user.mykotlin.presenter.impl.YueDanPresenterImpl
import com.example.user.mykotlin.view.YueDanView
import com.example.user.mykotlin.widget.YueDanItemView
import com.itheima.player.model.bean.YueDanBean
import kotlinx.android.synthetic.main.home_fragment.*

class YueDanFragment :BaseListFragment<YueDanBean,YueDanBean.PlayListsBean,YueDanItemView>() {
    override fun getSpecialAdapter(): BaseListAdapter<YueDanBean.PlayListsBean, YueDanItemView> {
        return YueDanAdapter()
    }

    override fun getSpecialPresenter(): BaseListPresenter {
        return YueDanPresenterImpl(this)
    }

    override fun getList(response: YueDanBean?): List<YueDanBean.PlayListsBean>? {
        return response?.playLists
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //解绑presenter
        presenter.destoryView()
    }
}