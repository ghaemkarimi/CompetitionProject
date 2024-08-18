package com.ghaemkarimi.daneshjooyar.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnFinish
import com.ghaemkarimi.daneshjooyar.mvp.model.LoginActivityModel
import com.ghaemkarimi.daneshjooyar.mvp.presenter.LoginActivityPresenter
import com.ghaemkarimi.daneshjooyar.mvp.view.LoginActivityView

class LoginActivity : AppCompatActivity(), OnFinish {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = LoginActivityView(this, this)
        setContentView(view.binding.root)

        val presenter = LoginActivityPresenter(view, LoginActivityModel(this))
        presenter.onCreate()
        presenter.hideStatusBar(window)

    }

    override fun finished() {
        finish()
    }

}