package com.example.user.mykotlin.net

import com.example.user.mykotlin.utils.URLProviderUtils
import com.itheima.player.model.bean.YueDanBean

class YueDanRequest(type : Int,offset : Int ,handler: ResponseHandler<YueDanBean> ) : MRequest<YueDanBean>(type,URLProviderUtils.getYueDanUrl(offset,20),handler) {
}