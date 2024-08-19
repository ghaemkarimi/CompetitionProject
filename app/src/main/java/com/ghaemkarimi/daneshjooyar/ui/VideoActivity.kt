package com.ghaemkarimi.daneshjooyar.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnFinish
import com.ghaemkarimi.daneshjooyar.mvp.model.VideoActivityModel
import com.ghaemkarimi.daneshjooyar.mvp.presenter.VideoActivityPresenter
import com.ghaemkarimi.daneshjooyar.mvp.view.VideoActivityView

class VideoActivity : AppCompatActivity(), OnFinish {

    private lateinit var presenter: VideoActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = VideoActivityView(this, this)
        setContentView(view.binding.root)

        val id = intent.getIntExtra("id", 0)
        val videoCount = intent.getIntExtra("videoCount", 0)

        presenter = VideoActivityPresenter(view, VideoActivityModel(this), id, videoCount)
        presenter.onCreate()
        presenter.hideStatusBar(window)

    }

    override fun finished() {
        finish()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val (currentPosition, statePlay, idVideo) = presenter.saveStateVideo()
        outState.putInt("position", currentPosition)
        outState.putBoolean("isPlay", statePlay)
        outState.putInt("idVideo", idVideo)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val currentPosition = savedInstanceState.getInt("position")
        val isPlaying = savedInstanceState.getBoolean("isPlay")
        val idVideo = savedInstanceState.getInt("idVideo")
        presenter.getStateVideo(currentPosition, isPlaying, idVideo)

    }

}