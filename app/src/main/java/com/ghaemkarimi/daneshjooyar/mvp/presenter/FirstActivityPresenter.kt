package com.ghaemkarimi.daneshjooyar.mvp.presenter

import android.view.Window
import com.ghaemkarimi.daneshjooyar.mvp.ext.LifeCycle
import com.ghaemkarimi.daneshjooyar.mvp.model.FirstActivityModel
import com.ghaemkarimi.daneshjooyar.mvp.view.FirstActivityView

class FirstActivityPresenter(
    private val view: FirstActivityView,
    private val model: FirstActivityModel
) : LifeCycle {

    override fun onCreate() {

        view.checkingLogin(model.getStateLogin())

    }

    override fun hideStatusBar(window: Window) {
        view.hideStatusBar(window)
    }

}