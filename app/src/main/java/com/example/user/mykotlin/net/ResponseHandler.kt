package com.example.user.mykotlin.net

/**
 * 网络请求的回调
 */
interface ResponseHandler<RESPONSE> {
    fun onError(type:Int,msg:String?)
    fun onSuccess(type:Int,result:RESPONSE)
}