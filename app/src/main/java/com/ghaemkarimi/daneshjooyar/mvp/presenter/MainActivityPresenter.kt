package com.ghaemkarimi.daneshjooyar.mvp.presenter

import com.ghaemkarimi.daneshjooyar.mvp.ext.LifeCycle
import com.ghaemkarimi.daneshjooyar.mvp.view.MainActivityView

class MainActivityPresenter(
    private val view: MainActivityView
) : LifeCycle {

    override fun onCreate() {

        setData()

    }

    private fun setData() {

        view.setData()
        view.fragmentManager()

    }

}