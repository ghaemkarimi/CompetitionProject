package com.ghaemkarimi.daneshjooyar.mvp.presenter

import com.ghaemkarimi.daneshjooyar.adapter.model.VideoModel
import com.ghaemkarimi.daneshjooyar.mvp.ext.LifeCycle
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnBindData
import com.ghaemkarimi.daneshjooyar.mvp.ext.SetState
import com.ghaemkarimi.daneshjooyar.mvp.model.CourseActivityModel
import com.ghaemkarimi.daneshjooyar.mvp.view.CourseActivityView

class CourseActivityPresenter(
    private val view: CourseActivityView,
    private val model: CourseActivityModel
) : LifeCycle {

    override fun onCreate() {

        model.saveVideo()
        setData()

    }

    override fun onStart() {

        setRecyclerVideo()

    }

    override fun onDestroy() {
        model.onDestroy()
    }

    private fun setData() {

        view.setRecyclerAbout(model.dataRecyclerAbout())
        view.setData()

    }

    private fun setRecyclerVideo() {

        model.getDataForRecyclerVideo(object : OnBindData{
            override fun getVideos(videos: List<VideoModel>) {
                view.setRecyclerVideo(videos, object : SetState{
                    override fun getState(state: Boolean) {
                        model.saveStateSeen(state)
                    }
                })
            }
        })

    }

}