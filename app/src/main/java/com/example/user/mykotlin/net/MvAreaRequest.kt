package com.example.user.mykotlin.net

import com.example.user.mykotlin.utils.URLProviderUtils
import com.itheima.player.model.bean.MvAreaBean

class MvAreaRequest(handler: ResponseHandler<List<MvAreaBean>>) : MRequest<List<MvAreaBean>>(0,URLProviderUtils.getMVareaUrl(),handler) {
}