package com.ghaemkarimi.daneshjooyar.mvp.model

import com.ghaemkarimi.daneshjooyar.R
import com.ghaemkarimi.daneshjooyar.adapter.model.AboutModel

class CourseActivityModel {

    fun dataRecycler() =
        arrayListOf(
            AboutModel(1, R.drawable.image_about1, "۴۰۰,۰۰۰+", "تعداد کاربران"),
            AboutModel(2, R.drawable.image_about2, "۲۵,۰۰۰+", "بازدید روزانه"),
            AboutModel(3, R.drawable.image_about3, "۵۰۰+", "تعداد مدرسین"),
            AboutModel(4, R.drawable.image_about4, "۲۰۰۰+", "تعداد دوره ها")
        )

}