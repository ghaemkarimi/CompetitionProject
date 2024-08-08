package com.ghaemkarimi.daneshjooyar.mvp.view

import android.content.Context
import android.view.LayoutInflater
import com.ghaemkarimi.daneshjooyar.databinding.ActivityCourseBinding
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnFinish

class CourseActivityView(private val context: Context, private val onFinish: OnFinish) {

    val binding = ActivityCourseBinding.inflate(LayoutInflater.from(context))

    

}