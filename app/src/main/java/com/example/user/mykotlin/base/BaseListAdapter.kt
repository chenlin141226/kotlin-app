package com.example.user.mykotlin.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.user.mykotlin.adapter.HomeAdapter
import com.example.user.mykotlin.widget.HomeItemView
import com.example.user.mykotlin.widget.LoadMoreView
import com.itheima.player.model.bean.HomeItemBean

/**
 * 下拉刷新和上拉加载更多列表界面Adapter基类
 *
 */
abstract class BaseListAdapter<ITEMBEAN,ITEMVIEW:View> : RecyclerView.Adapter<BaseListAdapter.BaseListlder>() {

    private var list = ArrayList<ITEMBEAN>()


    fun upDataList(list:List<ITEMBEAN>?){
        list?.let {
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    fun loadMore(list:List<ITEMBEAN>?){
        list?.let {
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):BaseListlder {
        if(viewType == 1){
            //最后一条
            return BaseListlder(LoadMoreView(parent.context))
        }else{
            return BaseListlder(getItemView(parent.context))
        }
    }


    override fun getItemCount(): Int {
        //+1 是加载更多
        return list.size+1
    }

    override fun getItemViewType(position: Int): Int {
        if(position == list.size){
            return 1
        }else{
            return 0
        }
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder:BaseListlder, position: Int) {
        if(position == list.size){
            return
        }
        val data = list.get(position)
        val itemView = holder.itemView as ITEMVIEW
        refreshItemView(itemView,data)
    }

    class BaseListlder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    /**
     * 刷新条目view
     */
    abstract fun refreshItemView(itemView: ITEMVIEW,data:ITEMBEAN)

    /**
     * 获取条目view
     */
    abstract fun getItemView(context: Context?): ITEMVIEW
}