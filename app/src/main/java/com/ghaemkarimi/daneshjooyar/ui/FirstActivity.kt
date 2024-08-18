package com.ghaemkarimi.daneshjooyar.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnFinish
import com.ghaemkarimi.daneshjooyar.mvp.model.FirstActivityModel
import com.ghaemkarimi.daneshjooyar.mvp.presenter.FirstActivityPresenter
import com.ghaemkarimi.daneshjooyar.mvp.view.FirstActivityView

class FirstActivity : AppCompatActivity(), OnFinish {

    private lateinit var presenter: FirstActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = FirstActivityView(this, this)
        setContentView(view.binding.root)
        presenter = FirstActivityPresenter(view, FirstActivityModel(this))
    }

    override fun onStart() {
        super.onStart()
        presenter.onCreate()
        presenter.hideStatusBar(window)
    }

    override fun finished() {
        finish()
    }

}