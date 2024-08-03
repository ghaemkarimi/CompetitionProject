package com.ghaemkarimi.daneshjooyar.mvp.presenter

import com.ghaemkarimi.daneshjooyar.mvp.ext.LifeCycle
import com.ghaemkarimi.daneshjooyar.mvp.ext.SetState
import com.ghaemkarimi.daneshjooyar.mvp.model.LoginActivityModel
import com.ghaemkarimi.daneshjooyar.mvp.view.LoginActivityView

class LoginActivityPresenter(
    private val view: LoginActivityView,
    private val model: LoginActivityModel
) : LifeCycle {

    override fun onCreate() {
        setData()
    }

    private fun setData() {

        view.setData()
        view.setTexts(pref = object : SetState {
            override fun getState(state: Boolean) {
                model.save(state)
            }
        })

    }

}