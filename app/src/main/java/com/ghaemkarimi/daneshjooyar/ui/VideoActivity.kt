package com.ghaemkarimi.daneshjooyar.ui

import android.os.Bundle
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

        presenter = VideoActivityPresenter(view, VideoActivityModel(this), id)
        presenter.onCreate()

    }

    override fun finished() {
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

}