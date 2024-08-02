package com.ghaemkarimi.daneshjooyar.mvp.presenter

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

}