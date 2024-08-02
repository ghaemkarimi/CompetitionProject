package com.ghaemkarimi.daneshjooyar.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnFinish
import com.ghaemkarimi.daneshjooyar.mvp.model.GhavaninActivityModel
import com.ghaemkarimi.daneshjooyar.mvp.presenter.GhavaninActivityPresenter
import com.ghaemkarimi.daneshjooyar.mvp.view.GhavaninActivityView

class GhavaninActivity : AppCompatActivity(), OnFinish {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = GhavaninActivityView(this, this)
        setContentView(view.binding.root)
        val presenter = GhavaninActivityPresenter(view, GhavaninActivityModel())
        presenter.onCreate()
    }

    override fun finished() {
        finish()
    }

}