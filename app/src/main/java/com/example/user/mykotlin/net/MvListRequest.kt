package com.example.user.mykotlin.net

import com.example.user.mykotlin.utils.URLProviderUtils
import com.itheima.player.model.bean.MvPagerBean

class MvListRequest(type : Int, code:String,offset:Int,handler: ResponseHandler<MvPagerBean>)
      : MRequest<MvPagerBean>(type,URLProviderUtils.getMVListUrl(code,offset,20),handler){
}