package com.ghaemkarimi.daneshjooyar.mvp.model

import com.ghaemkarimi.daneshjooyar.R
import com.ghaemkarimi.daneshjooyar.adapter.model.AboutModel

class CourseActivityModel {

    fun dataRecycler() =
        arrayListOf(
            AboutModel(1, R.drawable.image_about3, "۸۲,۸۸۸ نفر", "تعداد دانشچو"),
            AboutModel(2, R.drawable.image_about5, "۴.۶ از ۵", "امتیاز دانشجویان"),
            AboutModel(3, R.drawable.image_about4, "۳۰ عدد", "تعداد دوره ها"),
            AboutModel(4, R.drawable.image_about6, "۷۶۹ ساعت", "ساعت آموزش")
        )

}