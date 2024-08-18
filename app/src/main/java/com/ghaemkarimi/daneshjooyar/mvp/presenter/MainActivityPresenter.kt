package com.ghaemkarimi.daneshjooyar.mvp.presenter

import android.view.Window
import com.ghaemkarimi.daneshjooyar.mvp.ext.LifeCycle
import com.ghaemkarimi.daneshjooyar.mvp.view.MainActivityView

class MainActivityPresenter(
    private val view: MainActivityView
) : LifeCycle {

    override fun onCreate() {

        setData()

    }

    override fun hideStatusBar(window: Window) {
        view.hideStatusBar(window)
    }

    private fun setData() {

        view.setData()
        view.fragmentManager()

    }

}