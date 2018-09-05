package com.example.user.mykotlin.adapter

import android.content.Context
import com.example.user.mykotlin.base.BaseListAdapter
import com.example.user.mykotlin.widget.MvItemView
import com.itheima.player.model.bean.VideosBean

/**
 * MvFragment每一个条目view的adapter  泛型 条目的bean  条目view对象
 *
 */
class MvListAdapter : BaseListAdapter<VideosBean,MvItemView>() {
    override fun refreshItemView(itemView: MvItemView, data: VideosBean) {
        //传递数据 在view处理
        itemView.setData(data)
    }

    override fun getItemView(context: Context?): MvItemView {
        return MvItemView(context)
    }
}