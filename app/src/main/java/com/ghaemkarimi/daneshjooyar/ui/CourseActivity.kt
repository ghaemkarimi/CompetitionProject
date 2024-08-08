package com.ghaemkarimi.daneshjooyar.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnFinish
import com.ghaemkarimi.daneshjooyar.mvp.model.CourseActivityModel
import com.ghaemkarimi.daneshjooyar.mvp.presenter.CourseActivityPresenter
import com.ghaemkarimi.daneshjooyar.mvp.view.CourseActivityView

class CourseActivity : AppCompatActivity(), OnFinish {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = CourseActivityView(this, this)
        setContentView(view.binding.root)

        val presenter = CourseActivityPresenter(view, CourseActivityModel())
        presenter.onCreate()

    }

    override fun finished() {
        finish()
    }

}