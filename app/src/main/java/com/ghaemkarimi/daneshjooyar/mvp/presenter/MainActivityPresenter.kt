package com.ghaemkarimi.daneshjooyar.mvp.presenter

import com.ghaemkarimi.daneshjooyar.mvp.ext.LifeCycle
import com.ghaemkarimi.daneshjooyar.mvp.model.MainActivityModel
import com.ghaemkarimi.daneshjooyar.mvp.view.MainActivityView

class MainActivityPresenter(
    private val view: MainActivityView,
    private val model: MainActivityModel
) : LifeCycle {

    override fun onCreate() {

        setData()

    }

    private fun setData() {

        view.fragmentManager()

    }

}