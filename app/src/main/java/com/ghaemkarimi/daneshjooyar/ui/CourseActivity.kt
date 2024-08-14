package com.ghaemkarimi.daneshjooyar.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnFinish
import com.ghaemkarimi.daneshjooyar.mvp.model.CourseActivityModel
import com.ghaemkarimi.daneshjooyar.mvp.presenter.CourseActivityPresenter
import com.ghaemkarimi.daneshjooyar.mvp.view.CourseActivityView

class CourseActivity : AppCompatActivity(), OnFinish {

    private lateinit var presenter: CourseActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = CourseActivityView(this, this)
        setContentView(view.binding.root)

        presenter = CourseActivityPresenter(view, CourseActivityModel(this))
        presenter.onCreate()

    }

    override fun finished() {
        finish()
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

}