package com.ghaemkarimi.daneshjooyar.mvp.presenter

import com.ghaemkarimi.daneshjooyar.db.model.DaoVideoModel
import com.ghaemkarimi.daneshjooyar.mvp.ext.LifeCycle
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnBindData
import com.ghaemkarimi.daneshjooyar.mvp.model.VideoActivityModel
import com.ghaemkarimi.daneshjooyar.mvp.view.VideoActivityView

class VideoActivityPresenter(
    private val view: VideoActivityView,
    private val model: VideoActivityModel,
    private val idVideo: Int,
    private val videoCount: Int
) : LifeCycle {

    override fun onCreate() {
        setData()
    }

    override fun onDestroy() {
        model.onDestroy()
    }

    fun saveStateVideo(): Pair<Int, Boolean> = view.saveStateVideo()

    fun getStateVideo(currentPosition: Int, isPlaying: Boolean) {
        view.getStateVideo(currentPosition, isPlaying)
    }

    private fun setData() {

        view.setData(idVideo, object : OnBindData {
            override fun setVideo(id: Int) {
                model.getVideo(id, object : OnBindData {
                    override fun getVideo(video: DaoVideoModel, seconds: List<Int>) {
                        view.setVideoData(video, seconds, videoCount, object : OnBindData {
                            override fun updateDuration(duration: Int, idVideo: Int) {
                                model.updateDuration(duration, idVideo)
                            }
                        })
                    }
                })
            }
        })

    }

}