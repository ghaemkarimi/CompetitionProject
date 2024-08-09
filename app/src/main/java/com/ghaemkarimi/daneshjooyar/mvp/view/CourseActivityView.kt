package com.ghaemkarimi.daneshjooyar.mvp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.ghaemkarimi.daneshjooyar.databinding.ActivityCourseBinding
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnFinish

class CourseActivityView(private val context: Context, private val onFinish: OnFinish) {

    val binding = ActivityCourseBinding.inflate(LayoutInflater.from(context))

    fun setData() {

        binding.backInformation.setOnClickListener {
            binding.btnInformation.visibility = View.VISIBLE
            binding.information.visibility = View.VISIBLE
            binding.btnVideos.visibility = View.INVISIBLE
        }

        binding.backVideos.setOnClickListener {
            binding.btnVideos.visibility = View.VISIBLE
            binding.information.visibility = View.INVISIBLE
            binding.btnInformation.visibility = View.INVISIBLE
        }

        binding.more.setOnClickListener {
            onFinish.finished()
        }

    }

}