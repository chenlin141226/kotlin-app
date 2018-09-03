package com.example.user.mykotlin.presenter.impl

import com.example.user.mykotlin.base.BaseView
import com.example.user.mykotlin.net.ResponseHandler
import com.example.user.mykotlin.net.YueDanRequest
import com.example.user.mykotlin.presenter.interf.YueDanPresenter
import com.example.user.mykotlin.view.YueDanView
import com.itheima.player.model.bean.YueDanBean

class YueDanPresenterImpl(var yuedanView : BaseView<YueDanBean>?) : YueDanPresenter, ResponseHandler<YueDanBean> {
    override fun destoryView() {
         if(yuedanView != null){
             yuedanView = null
         }
    }

    val TYPE_INIT_OR_REFRESH = 1
    val TYPE_LOAD_MORE = 2
    /**
     * 加载数据失败
     */
    override fun onError(type: Int, msg: String?) {
        yuedanView?.onError(msg)
    }


    /**
     * 加载书成功
     */
    override fun onSuccess(type: Int, result: YueDanBean) {
        when(type){
            TYPE_INIT_OR_REFRESH ->  yuedanView?.loadSuccess(result)

            TYPE_LOAD_MORE -> yuedanView?.loadMore(result)
        }

    }

    /**
     * 加载数据 成功和失败回调（this中）
     */
    override fun loadDatas() {
         YueDanRequest(TYPE_INIT_OR_REFRESH,0,this).excute()
    }


    /**
     * 加载更多
     */
    override fun loadMore(offset: Int) {
        YueDanRequest( TYPE_LOAD_MORE,0,this).excute()
    }


}