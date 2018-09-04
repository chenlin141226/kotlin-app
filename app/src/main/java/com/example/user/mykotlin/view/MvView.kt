package com.example.user.mykotlin.view

import com.itheima.player.model.bean.MvAreaBean

interface MvView {
     fun onErro(msg: String?)
     fun loadSuccess(result: List<MvAreaBean>)
}