package com.ghaemkarimi.daneshjooyar.mvp.presenter

import android.view.Window
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
        view.setVideo(model.videoUri())

    }

    override fun hideStatusBar(window: Window) {
        view.hideStatusBar(window)
    }

    override fun onStart() {

        setRecyclerVideo()

    }

    override fun onDestroy() {
        model.onDestroy()
    }

    fun saveStateVideo() = view.saveStateVideo()

    fun getStateVideo(currentPosition: Int, isPlaying: Boolean) {
        view.getStateVideo(currentPosition, isPlaying)
    }

    private fun setData() {

        view.setRecyclerAbout(model.dataRecyclerAbout())
        view.setData()

    }

    private fun setRecyclerVideo() {

        model.getDataForRecyclerVideo(object : OnBindData {
            override fun getVideos(videos: List<VideoModel>) {
                view.setRecyclerVideo(videos, object : SetState {

                    override fun getState(state: Boolean) {
                        model.saveStateSeen(state)
                    }

                    override fun onPause() {
                        view.onPause()
                    }

                })
            }
        })

    }

}