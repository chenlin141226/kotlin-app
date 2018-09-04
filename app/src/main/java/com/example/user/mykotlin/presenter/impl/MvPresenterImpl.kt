package com.example.user.mykotlin.presenter.impl

import com.example.user.mykotlin.net.MvAreaRequest
import com.example.user.mykotlin.net.ResponseHandler
import com.example.user.mykotlin.presenter.interf.MvPresenter
import com.example.user.mykotlin.view.MvView
import com.itheima.player.model.bean.MvAreaBean

/**
 * mv  Prensenter的实现类
 */
class MvPresenterImpl(var mView : MvView) : MvPresenter, ResponseHandler<List<MvAreaBean>> {
    override fun onError(type: Int, msg: String?) {
        //网络请求失败
        mView.onErro(msg)
    }

    override fun onSuccess(type: Int, result: List<MvAreaBean>) {
        //网络请求成功
        mView.loadSuccess(result)
    }

    /**
     * 加载数据的方法
     */
    override fun loadData() {
        //发送网络请求
        MvAreaRequest(this).excute()
    }

}