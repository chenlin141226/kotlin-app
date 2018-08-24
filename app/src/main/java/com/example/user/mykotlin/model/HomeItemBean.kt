package com.itheima.player.model.bean

/**
 * ClassName:HomeItemBean
 * Description:home界面每个条目的bean
 */

data class HomeItemBean(
    val type: String,
    val id: Int,
    val title: String,
    val description: String,
    val posterPic: String,
    val thumbnailPic: String,
    val url: String,
    val hdUrl: String,
    val uhdUrl: String,
    val videoSize: Int,
    val hdVideoSize: Int,
    val uhdVideoSize: Int,
    val status: Int,
    val traceUrl: String,
    val clickUrl: String,
    val subType: String
)