package com.ghaemkarimi.daneshjooyar.mvp.presenter

import com.ghaemkarimi.daneshjooyar.mvp.ext.LifeCycle
import com.ghaemkarimi.daneshjooyar.mvp.model.FirstActivityModel
import com.ghaemkarimi.daneshjooyar.mvp.view.FirstActivityView

class FirstActivityPresenter(
    private val view: FirstActivityView,
    private val model: FirstActivityModel
) : LifeCycle {

    override fun onStart() {

        view.checkingLogin(model.getStateLogin())

    }

}