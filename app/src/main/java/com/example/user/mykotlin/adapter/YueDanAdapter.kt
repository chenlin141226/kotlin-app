package com.example.user.mykotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.user.mykotlin.widget.HomeItemView
import com.example.user.mykotlin.widget.LoadMoreView
import com.example.user.mykotlin.widget.YueDanItemView
import com.itheima.player.model.bean.YueDanBean

class YueDanAdapter : RecyclerView.Adapter<YueDanAdapter.YueDanHolder>() {

    private  var list = ArrayList<YueDanBean.PlayListsBean>()


    /**
     * 加载和刷新数据
     */
    fun updataList(list: List<YueDanBean.PlayListsBean>?) {
        list?.let {
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    /**
     * 加载更多数据
     */
    fun loadMore(playLists: List<YueDanBean.PlayListsBean>?) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YueDanHolder {
        if(viewType == 1){
            //最后一条
            return YueDanAdapter.YueDanHolder(LoadMoreView(parent.context))
        }else{
            return YueDanAdapter.YueDanHolder(YueDanItemView(parent?.context))
        }
    }


    override fun onBindViewHolder(holder: YueDanHolder, position: Int) {
        if(position == list.size){
            return
        }
        var data = list.get(position)
        var itemView = holder.itemView as YueDanItemView
        itemView.setData(data)
    }

    override fun getItemViewType(position: Int): Int {
        if(position == list.size){
            return 1
        }else{
            return 2
        }
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int {
       return list.size+1
    }

    class YueDanHolder(itemView : View) : RecyclerView.ViewHolder(itemView){}

}