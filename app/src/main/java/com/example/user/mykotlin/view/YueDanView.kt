package com.example.user.mykotlin.view

import com.itheima.player.model.bean.YueDanBean

interface YueDanView {
     fun onError(msg: String?)
     fun loadSuccess(list:YueDanBean?)
     fun loadMore(result: YueDanBean?)
}