package com.ghaemkarimi.daneshjooyar.mvp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ghaemkarimi.daneshjooyar.R
import com.ghaemkarimi.daneshjooyar.adapter.model.AboutModel
import com.ghaemkarimi.daneshjooyar.adapter.model.VideoModel
import com.ghaemkarimi.daneshjooyar.adapter.recyclers.AdapterRecyclerAboutUs
import com.ghaemkarimi.daneshjooyar.adapter.recyclers.AdapterRecyclerVideos
import com.ghaemkarimi.daneshjooyar.databinding.ActivityCourseBinding
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnFinish
import com.ghaemkarimi.daneshjooyar.mvp.ext.SetDialog

class CourseActivityView(private val context: Context, private val onFinish: OnFinish) {

    val binding = ActivityCourseBinding.inflate(LayoutInflater.from(context))
    private val setDialog = SetDialog(context)
    private val backBtn = R.drawable.inner_shadow
    private var endCourse = false

    fun setData() {

        binding.backInformation.setOnClickListener {
            binding.lineInformation.visibility = View.VISIBLE
            binding.scrollView.visibility = View.VISIBLE
            binding.lineVideos.visibility = View.INVISIBLE
            binding.recyclerVideos.visibility = View.INVISIBLE
            binding.backInformation.setBackgroundResource(backBtn)
            binding.backVideos.background = null
            binding.imgEndCourse.visibility = View.GONE
        }

        binding.backVideos.setOnClickListener {
            binding.lineInformation.visibility = View.INVISIBLE
            binding.scrollView.visibility = View.INVISIBLE
            binding.lineVideos.visibility = View.VISIBLE
            binding.recyclerVideos.visibility = View.VISIBLE
            binding.backVideos.setBackgroundResource(backBtn)
            binding.backInformation.background = null
            if (endCourse)
                binding.imgEndCourse.visibility = View.VISIBLE
        }

        binding.arrowBack.setOnClickListener {
            onFinish.finished()
        }

        binding.support.setOnClickListener {
            setDialog.setDialogSupport()
        }

    }

    fun setRecyclerAbout(data: ArrayList<AboutModel>) {

        val adapter = AdapterRecyclerAboutUs(context, data)

        binding.recyclerAboutUs.layoutManager = LinearLayoutManager(
            context, RecyclerView.VERTICAL, false
        )

        binding.recyclerAboutUs.adapter = adapter

    }

    fun setRecyclerVideo(data: List<VideoModel>) {

        endCourse = false
        val adapter = AdapterRecyclerVideos(context, data)

        binding.recyclerVideos.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        binding.recyclerVideos.adapter = adapter

        data.forEach {
            if (!it.seen) {
                endCourse = false
                return
            } else
                endCourse = true
        }

        if (endCourse)
            binding.imgEndCourse.visibility = View.VISIBLE

    }

}