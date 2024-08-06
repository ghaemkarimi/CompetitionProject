package com.ghaemkarimi.daneshjooyar.mvp.model.fragment

import com.ghaemkarimi.daneshjooyar.R
import com.ghaemkarimi.daneshjooyar.adapter.model.HomeModel

class HomeFragmentModel {

    fun dataRecyclerHorizontal() =
        arrayListOf(
            HomeModel(1, "طراحی سایت", R.drawable.ic_item_1),
            HomeModel(2, "برنامه نویسی موبایل", R.drawable.ic_item_2),
            HomeModel(3, "هوش مصنوعی", R.drawable.ic_item_3),
            HomeModel(4, "بازی سازی", R.drawable.ic_item_4),
            HomeModel(5, "برنامه نویسی ویندوز", R.drawable.ic_item_5)
        )

}