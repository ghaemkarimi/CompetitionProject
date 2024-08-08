package com.ghaemkarimi.daneshjooyar.mvp.presenter.fragment

import com.ghaemkarimi.daneshjooyar.mvp.ext.LifeCycle
import com.ghaemkarimi.daneshjooyar.mvp.model.fragment.AboutUsFragmentModel
import com.ghaemkarimi.daneshjooyar.mvp.view.fragment.AboutUsFragmentView

class AboutUsFragmentPresenter(
    private val view: AboutUsFragmentView,
    private val model: AboutUsFragmentModel
) : LifeCycle {

    override fun onCreate() {

        view.setRecycler(model.dataRecycler())
        view.setIntents()

    }

}