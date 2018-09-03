package com.example.user.mykotlin.base

import com.itheima.player.model.bean.HomeItemBean

/**
 * 所有上拉加载下拉刷新加载更多界面的view基类
 */
interface BaseView<RESPONSE> {

    /**
     * 获取数据失败
     */
    fun onError(message: String?)

    /**
     * 初始化或者刷新数据成功
     */
    fun loadSuccess(response:RESPONSE?) {

    }

    /**
     * 加载更多成功
     */
    fun loadMore(response:RESPONSE?) {

    }
}