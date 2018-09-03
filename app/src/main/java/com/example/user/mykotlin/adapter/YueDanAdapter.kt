package com.example.user.mykotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.user.mykotlin.base.BaseListAdapter
import com.example.user.mykotlin.widget.HomeItemView
import com.example.user.mykotlin.widget.LoadMoreView
import com.example.user.mykotlin.widget.YueDanItemView
import com.itheima.player.model.bean.YueDanBean

class YueDanAdapter :BaseListAdapter<YueDanBean.PlayListsBean,YueDanItemView>() {
    override fun refreshItemView(itemView: YueDanItemView, data: YueDanBean.PlayListsBean) {
        itemView.setData(data)
    }

    override fun getItemView(context: Context?): YueDanItemView {
        return YueDanItemView(context)
    }


}