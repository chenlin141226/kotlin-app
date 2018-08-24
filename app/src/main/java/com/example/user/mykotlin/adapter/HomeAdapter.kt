package com.example.user.mykotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.user.mykotlin.widget.HomeItemView
import com.example.user.mykotlin.widget.LoadMoreView
import com.itheima.player.model.bean.HomeItemBean
import java.text.FieldPosition

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {
    private var list = ArrayList<HomeItemBean>()

    /**
     * 更新数据
     */
    fun upDataList(list:List<HomeItemBean>?){
        list?.let {
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    fun loadMore(list:List<HomeItemBean>?){
        list?.let {
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        if(viewType == 1){
              //最后一条
            return HomeHolder(LoadMoreView(parent.context))
        }else{
            return HomeHolder(HomeItemView(parent.context))
        }

       return HomeHolder(HomeItemView(parent.context))
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

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        if(position == list.size){
            return
        }
        val data = list.get(position)
        val itemView = holder.itemView as HomeItemView
        itemView.setData(data)
    }

    class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
     }
}