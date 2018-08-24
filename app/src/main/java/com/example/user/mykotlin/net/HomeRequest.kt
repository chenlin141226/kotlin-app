package com.example.user.mykotlin.net

import com.example.user.mykotlin.utils.URLProviderUtils
import com.itheima.player.model.bean.HomeItemBean

/**
 * homeView的request
 */
class HomeRequest(type:Int,offset:Int,handler: ResponseHandler<List<HomeItemBean>>) :
        MRequest<List<HomeItemBean>>(type,URLProviderUtils.getHomeUrl(offset,20),handler){

}