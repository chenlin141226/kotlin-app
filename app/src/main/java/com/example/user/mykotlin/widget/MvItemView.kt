package com.example.user.mykotlin.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.example.user.mykotlin.R
import com.itheima.player.model.bean.VideosBean

class MvItemView :RelativeLayout{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        View.inflate(context, R.layout.item_mv,this)
    }

    /**
     * 刷新每一个itemview列表
     */
    fun setData(data: VideosBean) {

    }

}