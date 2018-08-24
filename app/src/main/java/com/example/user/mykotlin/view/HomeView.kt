package com.example.user.mykotlin.view

import com.itheima.player.model.bean.HomeItemBean

/**
 * 负责Home界面和presenter的交互
 */
interface HomeView {
    /**
     * 获取数据失败
     */
    fun onError(message: String?)

    /**
     * 初始化或者刷新数据成功
     */
    fun loadSuccess(list: List<HomeItemBean>?) {

    }

    /**
     * 加载更多成功
     */
    fun loadMore(list: List<HomeItemBean>?) {

    }

}