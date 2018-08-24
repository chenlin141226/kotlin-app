package com.example.user.mykotlin.presenter.impl

import com.example.user.mykotlin.net.HomeRequest
import com.example.user.mykotlin.net.ResponseHandler
import com.example.user.mykotlin.presenter.interf.HomePresenter
import com.example.user.mykotlin.view.HomeView
import com.itheima.player.model.bean.HomeItemBean

/**
 * homeView的实现类
 */
class HomePresenterImpl(var homeView: HomeView?) : HomePresenter, ResponseHandler<List<HomeItemBean>> {

    val TYPE_INIT_OR_REFRESH = 1
    val TYPE_LOAD_MORE = 2

    /**
     * 解绑view和presenter
     */
    fun destoryView(){
        if(homeView!=null){
            homeView = null
        }
    }


    override fun onError(type: Int, msg: String?) {
        homeView?.onError(msg)
    }

    override fun onSuccess(type: Int, result: List<HomeItemBean>) {
        when (type) {
            TYPE_INIT_OR_REFRESH -> homeView?.loadSuccess(result)
            TYPE_LOAD_MORE -> homeView?.loadMore(result)
        }
    }


    override fun loadDatas() {
        HomeRequest(TYPE_INIT_OR_REFRESH, 0, this).excute()

        /*val path = URLProviderUtils.getHomeUrl(0, 20)
        val client = OkHttpClient()
        val request = Request.Builder().url(path).get().build()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val result = response?.body()?.string()
                Log.i("tag", result)
                val gson = Gson()
                val list = gson.fromJson<List<HomeItemBean>>(result, object : TypeToken<List<HomeItemBean>>() {}.type)

                ThreadUtil.runOnMainThread(object : Runnable {
                    override fun run() {
                        homeView.loadSuccess(list)
                    }

                })
            }

            override fun onFailure(call: Call?, e: IOException?) {
                ThreadUtil.runOnMainThread(object : Runnable {
                    override fun run() {
                        homeView.onError(e?.message)
                    }
                })
            }

        })*/

    }

    override fun loadMore(offset: Int) {

        HomeRequest(TYPE_LOAD_MORE, offset, this).excute()
        /*     val path = URLProviderUtils.getHomeUrl(0, 20)
             val client = OkHttpClient()
             val request = Request.Builder().url(path).get().build()
             client.newCall(request).enqueue(object : Callback {
                 override fun onResponse(call: Call?, response: Response?) {
                     val result = response?.body()?.string()
                     Log.i("tag", result)
                     val gson = Gson()
                     val list = gson.fromJson<List<HomeItemBean>>(result, object : TypeToken<List<HomeItemBean>>() {}.type)

                     ThreadUtil.runOnMainThread(object : Runnable {
                         override fun run() {
                             homeView.loadMore(list)
                         }
                     })
                 }

                 override fun onFailure(call: Call?, e: IOException?) {
                     ThreadUtil.runOnMainThread(object : Runnable {
                         override fun run() {
                             homeView.onError(e?.message)
                         }
                     })
                 }

             })*/
    }
}