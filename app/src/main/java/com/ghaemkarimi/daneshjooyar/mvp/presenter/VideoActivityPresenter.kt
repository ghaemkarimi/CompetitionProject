package com.ghaemkarimi.daneshjooyar.mvp.presenter

import android.view.Window
import com.ghaemkarimi.daneshjooyar.db.model.DaoSeenSecondsModel
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
        if (!model.isSet()) setData(idVideo)
    }

    override fun hideStatusBar(window: Window) {
        view.hideStatusBar(window)
    }

    fun saveStateVideo() = view.saveStateVideo()

    fun getStateVideo(currentPosition: Int, isPlaying: Boolean, idVideo: Int) {
        if (model.isSet()) setData(idVideo)
        view.getStateVideo(currentPosition, isPlaying)
    }

    private fun setData(idMain: Int) {

        view.setData(idMain, object : OnBindData {
            override fun setVideo(id: Int) {
                model.getVideo(id, object : OnBindData {
                    override fun getVideo(video: DaoVideoModel) {
                        model.getSeconds(id, object : OnBindData {
                            override fun getSeconds(seconds: List<Int>) {
                                view.setVideoData(video, videoCount, seconds, object : OnBindData {

                                    override fun updateDuration(duration: Int, idVideo: Int) {
                                        model.updateDuration(duration, idVideo)
                                    }

                                    override fun saveSeconds(second: DaoSeenSecondsModel) {
                                        model.saveSeconds(second)
                                    }

                                    override fun updateSeen(state: Boolean, idVideo: Int) {
                                        model.setSeenVideo(state, idVideo)
                                    }

                                })
                            }
                        })
                    }
                })
            }
        })

    }

}