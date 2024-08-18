package com.ghaemkarimi.daneshjooyar.mvp.ext

import com.ghaemkarimi.daneshjooyar.adapter.model.VideoModel
import com.ghaemkarimi.daneshjooyar.db.model.DaoSeenSecondsModel
import com.ghaemkarimi.daneshjooyar.db.model.DaoVideoModel
import java.time.Duration

interface OnBindData {

    fun getVideos(videos: List<VideoModel>) {}

    fun getVideo(video: DaoVideoModel) {}

    fun getSeconds(seconds: List<Int>) {}

    fun updateSeen(state: Boolean, idVideo: Int) {}

    fun updateDuration(duration: Int, idVideo: Int) {}

    fun saveSeconds(second: DaoSeenSecondsModel) {}

    fun setVideo(id: Int) {}

}