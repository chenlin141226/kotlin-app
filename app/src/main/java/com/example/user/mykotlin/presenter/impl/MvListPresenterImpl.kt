package com.example.user.mykotlin.presenter.impl

import com.example.user.mykotlin.base.BaseListPresenter
import com.example.user.mykotlin.net.MvListRequest
import com.example.user.mykotlin.net.ResponseHandler
import com.example.user.mykotlin.presenter.interf.MvListpresenter
import com.example.user.mykotlin.view.MvListView
import com.itheima.player.model.bean.MvPagerBean

class MvListPresenterImpl(var code:String, var mvListView:MvListView?) : MvListpresenter, ResponseHandler<MvPagerBean> {

    val TYPE_INIT_OR_REFRESH = 1
    val TYPE_LOAD_MORE = 2

    //wa
    override fun onError(type: Int, msg: String?) {
        mvListView?.onError(msg)
    }

    override fun onSuccess(type: Int, result: MvPagerBean) {

      when(type){
          TYPE_INIT_OR_REFRESH ->   mvListView?.loadSuccess(result)
          TYPE_LOAD_MORE -> mvListView?.loadMore(result)
      }

    }

    //继承BaseListPresenter实现的方法

    override fun loadDatas() {
        MvListRequest(TYPE_INIT_OR_REFRESH,code,0,this).excute()
    }

    override fun loadMore(offset: Int) {
        MvListRequest(TYPE_LOAD_MORE,code,offset,this).excute()
    }

    override fun destoryView() {
        if(mvListView!=null){
            mvListView = null
        }
    }
}