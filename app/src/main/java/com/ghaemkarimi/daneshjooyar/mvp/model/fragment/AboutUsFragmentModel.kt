package com.ghaemkarimi.daneshjooyar.mvp.model.fragment

import com.ghaemkarimi.daneshjooyar.R
import com.ghaemkarimi.daneshjooyar.adapter.model.AboutModel

class AboutUsFragmentModel {

    fun dataRecycler() =
        arrayListOf(
            AboutModel(
                1,
                R.drawable.image_about1,
                "۴۰۰,۰۰۰+",
                "تعداد کاربران",
                R.drawable.image_about2,
                "۲۵,۰۰۰+",
                "بازدید روزانه"
            ),
            AboutModel(
                2,
                R.drawable.image_about3,
                "۵۰۰+",
                "تعداد مدرسین",
                R.drawable.image_about4,
                "۲۰۰۰+",
                "تعداد دوره ها"
            )
        )

}