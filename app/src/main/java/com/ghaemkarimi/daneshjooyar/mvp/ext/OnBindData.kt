package com.ghaemkarimi.daneshjooyar.mvp.ext

import com.ghaemkarimi.daneshjooyar.adapter.model.VideoModel
import com.ghaemkarimi.daneshjooyar.db.model.DaoVideoModel

interface OnBindData {

    fun getVideos(videos: List<VideoModel>) {}

    fun getVideo(video: DaoVideoModel) {}

    fun updateSeen(state: Boolean, idVideo: Int) {}

    fun getSeconds(seconds: List<Int>) {}

}