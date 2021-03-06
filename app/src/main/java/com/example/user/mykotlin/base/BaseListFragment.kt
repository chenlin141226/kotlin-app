package com.example.user.mykotlin.base

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.user.mykotlin.R
import com.example.user.mykotlin.adapter.HomeAdapter
import com.example.user.mykotlin.presenter.impl.HomePresenterImpl
import com.example.user.mykotlin.view.HomeView
import com.itheima.player.model.bean.HomeItemBean
import kotlinx.android.synthetic.main.home_fragment.*
import org.jetbrains.anko.support.v4.toast

/**
 * 所有具有下拉刷新和上拉加载更多列表界面的基类
 * HomeView  ->  BaseView
 * Adapter    -> BaseListAdapter
 * Presenter  -> BaseListPresenter
 */
abstract class BaseListFragment<RESPONSE,ITEMBEAN,ITEMVIEW:View>: BaseFragment(), BaseView<RESPONSE> {

    /**
     * homeView 的回调方法 返回成功和失败的数据
     */
    override fun onError(message: String?) {
        refreshLayout?.isRefreshing =false
        toast(message.toString())
    }

    override fun loadSuccess(response:RESPONSE?) {
        //隐藏刷新控件
        refreshLayout?.isRefreshing = false
        adapter.upDataList(getList(response))
    }

    override fun loadMore(response: RESPONSE?) {
        adapter.loadMore(getList(response))
    }


    //惰性加载HomeAdapter 和 presenter
    val adapter by lazy {getSpecialAdapter()}

    val presenter by lazy { getSpecialPresenter() }

    override fun initView(): View? {
        return View.inflate(context, R.layout.home_fragment, null)
    }

    override fun initData() {
        //初始化数据
        presenter.loadDatas()
    }

    override fun initListener() {
        recycleview.layoutManager = LinearLayoutManager(context)
        recycleview.adapter = adapter

        //刷新控件
        refreshLayout?.setColorSchemeColors(Color.RED, Color.BLUE, Color.GRAY, Color.GREEN)
        refreshLayout?.setOnRefreshListener {
            //刷新数据
            presenter.loadDatas()
        }

        //recycleview滑动监听
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

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

            }
        })
    }

    /**
     * 获取适配器adapter
     */
    abstract fun getSpecialAdapter():BaseListAdapter<ITEMBEAN,ITEMVIEW>

    /**
     * 获取presenter
     */
    abstract fun getSpecialPresenter():BaseListPresenter

/**
 *从返回数据中获取list集合
 */
abstract fun getList(response: RESPONSE?): List<ITEMBEAN>?

}