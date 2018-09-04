package com.example.user.mykotlin.adapter

import android.content.Context
import com.example.user.mykotlin.base.BaseListAdapter
import com.example.user.mykotlin.widget.MvItemView
import com.itheima.player.model.bean.VideosBean

class MvListAdapter : BaseListAdapter<VideosBean,MvItemView>() {
    override fun refreshItemView(itemView: MvItemView, data: VideosBean) {
        itemView.setData(data)
    }

    override fun getItemView(context: Context?): MvItemView {
        return MvItemView(context)
    }
}