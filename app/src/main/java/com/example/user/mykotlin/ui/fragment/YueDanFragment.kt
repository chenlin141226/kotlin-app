package com.example.user.mykotlin.ui.fragment

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.user.mykotlin.R
import com.example.user.mykotlin.adapter.YueDanAdapter
import com.example.user.mykotlin.base.BaseFragment
import com.example.user.mykotlin.presenter.impl.YueDanPresenterImpl
import com.example.user.mykotlin.view.YueDanView
import com.itheima.player.model.bean.YueDanBean
import kotlinx.android.synthetic.main.home_fragment.*

class YueDanFragment : BaseFragment(), YueDanView {


    //数据加载失败回调
    override fun onError(msg: String?) {
        refreshLayout?.isRefreshing = false
        myToast(msg.toString())
    }

    //加载更多回调
    override fun loadMore(list: YueDanBean?) {
        refreshLayout?.isRefreshing = false
        adapter.loadMore(list?.playLists)
    }

    //数据加载成功回调
    override fun loadSuccess(list: YueDanBean?) {
        refreshLayout?.isRefreshing = false
        adapter.updataList(list?.playLists)

    }

    val adapter by lazy { YueDanAdapter() }
    val presenter by lazy { YueDanPresenterImpl(this) }

    override fun initView(): View? {
        return View.inflate(context, R.layout.yuedan_fragment, null)
    }

    //初始化监听 ，adapter
    override fun initListener() {
        recycleview.layoutManager = LinearLayoutManager(context)

        recycleview.adapter = adapter

        //刷新数据
        refreshLayout?.setColorSchemeColors(Color.RED, Color.BLUE, Color.GRAY, Color.GREEN)

        refreshLayout?.setOnRefreshListener {
            presenter.loadDatas()
        }

        recycleview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                //空置状态，并且是最后一条
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //是否是最后一条已经显示
                    val layoutManager = recyclerView.layoutManager
                    if (layoutManager is LinearLayoutManager) {
                        val manager: LinearLayoutManager = layoutManager
                        var lastPosition = manager.findLastVisibleItemPosition()
                        if (lastPosition == adapter.itemCount - 1) {
                            //加载更多
                            presenter.loadMore(adapter.itemCount - 1);
                        }
                    }
                }
            }
        })

    }

    //初始化数据
    override fun initData() {
        presenter.loadDatas()
    }
}