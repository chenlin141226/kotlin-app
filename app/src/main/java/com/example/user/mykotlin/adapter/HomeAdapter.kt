package com.example.user.mykotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.user.mykotlin.base.BaseListAdapter
import com.example.user.mykotlin.widget.HomeItemView
import com.example.user.mykotlin.widget.LoadMoreView
import com.itheima.player.model.bean.HomeItemBean
import java.text.FieldPosition

class HomeAdapter : BaseListAdapter<HomeItemBean,HomeItemView>() {
    override fun refreshItemView(itemView: HomeItemView, data: HomeItemBean) {
        itemView.setData(data)
    }

    override fun getItemView(context: Context?): HomeItemView {
        return HomeItemView(context)
    }

}