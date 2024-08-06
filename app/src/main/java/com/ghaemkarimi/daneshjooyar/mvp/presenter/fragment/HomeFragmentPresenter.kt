package com.ghaemkarimi.daneshjooyar.mvp.presenter.fragment

import com.ghaemkarimi.daneshjooyar.mvp.ext.LifeCycle
import com.ghaemkarimi.daneshjooyar.mvp.ext.SetSelection
import com.ghaemkarimi.daneshjooyar.mvp.model.fragment.HomeFragmentModel
import com.ghaemkarimi.daneshjooyar.mvp.view.fragment.HomeFragmentView

class HomeFragmentPresenter(
    private val view: HomeFragmentView,
    private val model: HomeFragmentModel
) : LifeCycle {

    override fun onCreate() {

        setData()

    }


    private fun setData() {

        view.setRecyclerHorizontal(
            model.dataRecyclerHorizontal(),
            object : SetSelection {
                override fun setItemCount(foreignKey: Int) {
                    view.setRecyclerVertical(foreignKey, model.dataRecyclerVertical())
                }
            }
        )

    }

}