package com.ghaemkarimi.daneshjooyar.mvp.presenter

import android.view.Window
import com.ghaemkarimi.daneshjooyar.mvp.ext.LifeCycle
import com.ghaemkarimi.daneshjooyar.mvp.model.GhavaninActivityModel
import com.ghaemkarimi.daneshjooyar.mvp.view.GhavaninActivityView

class GhavaninActivityPresenter(
    private val view: GhavaninActivityView,
    private val model: GhavaninActivityModel
) : LifeCycle {

    override fun onCreate() {

        view.setData(model.text())

    }

    override fun hideStatusBar(window: Window) {
        view.hideStatusBar(window)
    }

}