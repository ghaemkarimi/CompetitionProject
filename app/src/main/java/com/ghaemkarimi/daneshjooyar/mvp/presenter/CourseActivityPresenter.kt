package com.ghaemkarimi.daneshjooyar.mvp.presenter

import com.ghaemkarimi.daneshjooyar.mvp.ext.LifeCycle
import com.ghaemkarimi.daneshjooyar.mvp.model.CourseActivityModel
import com.ghaemkarimi.daneshjooyar.mvp.view.CourseActivityView

class CourseActivityPresenter(
    private val view: CourseActivityView,
    private val model: CourseActivityModel
) : LifeCycle {

    override fun onCreate() {

        view.setData()

    }

}