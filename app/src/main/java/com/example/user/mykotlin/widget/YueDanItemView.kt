package com.example.user.mykotlin.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import com.example.user.mykotlin.R
import com.itheima.player.model.bean.YueDanBean
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.android.synthetic.main.item_yuedan.view.*

class YueDanItemView : RelativeLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        View.inflate(context, R.layout.item_yuedan,this)
    }

    fun setData(data: YueDanBean.PlayListsBean) {
        //歌单名称
        title.text = data.title
        //作者
        author_name.text = data.creator?.nickName
        //歌曲个数
        count.text = data.videoCount.toString()
        //背景
        Picasso.with(context).load(data.playListBigPic).into(bg)
        //创建者头像
        Picasso.with(context).load(data.playListPic).transform(CropCircleTransformation()).into(author_image)
    }
}