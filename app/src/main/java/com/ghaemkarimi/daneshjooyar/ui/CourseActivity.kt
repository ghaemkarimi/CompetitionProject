package com.ghaemkarimi.daneshjooyar.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnFinish
import com.ghaemkarimi.daneshjooyar.mvp.model.CourseActivityModel
import com.ghaemkarimi.daneshjooyar.mvp.presenter.CourseActivityPresenter
import com.ghaemkarimi.daneshjooyar.mvp.view.CourseActivityView

class CourseActivity : AppCompatActivity(), OnFinish {

    private lateinit var presenter: CourseActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = CourseActivityView(this, this)
        setContentView(view.binding.root)

        presenter = CourseActivityPresenter(view, CourseActivityModel(this))
        presenter.onCreate()
        presenter.hideStatusBar(window)

    }

    override fun finished() {
        finish()
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val (currentPosition, statePlay) = presenter.saveStateVideo()
        outState.putInt("position", currentPosition)
        outState.putBoolean("isPlay", statePlay)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val currentPosition = savedInstanceState.getInt("position")
        val isPlaying = savedInstanceState.getBoolean("isPlay")
        presenter.getStateVideo(currentPosition, isPlaying)

    }

}