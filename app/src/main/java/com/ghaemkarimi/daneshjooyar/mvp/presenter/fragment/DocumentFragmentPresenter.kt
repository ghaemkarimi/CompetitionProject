package com.ghaemkarimi.daneshjooyar.mvp.presenter.fragment

import com.ghaemkarimi.daneshjooyar.mvp.ext.LifeCycle
import com.ghaemkarimi.daneshjooyar.mvp.model.fragment.DocumentFragmentModel
import com.ghaemkarimi.daneshjooyar.mvp.view.fragment.DocumentFragmentView

class DocumentFragmentPresenter(
    private val view: DocumentFragmentView,
    private val model: DocumentFragmentModel
) : LifeCycle {

    override fun onCreate() {

        setData()

    }

    private fun setData() {

        view.setData(model.getStateEndCourse())

    }

}