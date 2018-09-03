package com.example.user.mykotlin.base

/**
 * 所有下拉刷新和上拉加载更多列表界面的prensenter
 */
interface BaseListPresenter {

    fun loadDatas()
    fun loadMore(i: Int)

    //解绑presenter和view层
    fun destoryView()
}