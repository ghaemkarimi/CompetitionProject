package com.ghaemkarimi.daneshjooyar.mvp.ext

import com.ghaemkarimi.daneshjooyar.adapter.model.VideoModel
import com.ghaemkarimi.daneshjooyar.db.model.DaoSeenSecondsModel
import com.ghaemkarimi.daneshjooyar.db.model.DaoVideoModel

interface OnBindData {

    fun getVideos(videos: List<VideoModel>) {}

    fun getVideo(video: DaoVideoModel, seconds: List<Int>) {}

    fun updateSeen(state: Boolean, idVideo: Int) {}

    fun saveSeconds(second: DaoSeenSecondsModel) {}

    fun setVideo(id: Int) {}

}