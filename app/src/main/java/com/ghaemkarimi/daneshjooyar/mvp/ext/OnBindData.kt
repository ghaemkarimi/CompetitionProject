package com.ghaemkarimi.daneshjooyar.mvp.ext

import com.ghaemkarimi.daneshjooyar.adapter.model.VideoModel

interface OnBindData {

    fun getVideos(videos: List<VideoModel>) {}

}