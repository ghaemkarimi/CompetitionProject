package com.ghaemkarimi.daneshjooyar.mvp.model

import com.ghaemkarimi.daneshjooyar.R
import com.ghaemkarimi.daneshjooyar.adapter.model.AboutModel

class CourseActivityModel {

    fun dataRecyclerAbout() =
        arrayListOf(
            AboutModel(
                1,
                R.drawable.image_about3,
                "۸۲,۸۸۸ نفر",
                "تعداد دانشچو",
                R.drawable.image_about5,
                "۴.۶ از ۵",
                "امتیاز دانشجویان"
            ),
            AboutModel(
                2,
                R.drawable.image_about4,
                "۳۰ عدد",
                "تعداد دوره ها",
                R.drawable.image_about6,
                "۷۶۹ ساعت",
                "ساعت آموزش"
            )
        )

}