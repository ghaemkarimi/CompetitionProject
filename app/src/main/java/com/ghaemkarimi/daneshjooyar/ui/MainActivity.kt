package com.ghaemkarimi.daneshjooyar.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ghaemkarimi.daneshjooyar.mvp.presenter.MainActivityPresenter
import com.ghaemkarimi.daneshjooyar.mvp.view.MainActivityView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = MainActivityView(this)
        setContentView(view.binding.root)

        val presenter = MainActivityPresenter(view)
        presenter.onCreate()

    }

}