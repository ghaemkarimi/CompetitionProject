package com.ghaemkarimi.daneshjooyar.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ghaemkarimi.daneshjooyar.R
import com.ghaemkarimi.daneshjooyar.mvp.ext.SetFragment
import com.ghaemkarimi.daneshjooyar.mvp.presenter.MainActivityPresenter
import com.ghaemkarimi.daneshjooyar.mvp.view.MainActivityView

class MainActivity : AppCompatActivity(), SetFragment {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = MainActivityView(this, this)
        setContentView(view.binding.root)

        val presenter = MainActivityPresenter(view)
        presenter.onCreate()
        presenter.hideStatusBar(window)

    }

    override fun fragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment, fragment)
            .commit()
    }

}