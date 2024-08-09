package com.ghaemkarimi.daneshjooyar.mvp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ghaemkarimi.daneshjooyar.R
import com.ghaemkarimi.daneshjooyar.adapter.model.AboutModel
import com.ghaemkarimi.daneshjooyar.adapter.recyclers.AdapterRecyclerAboutUs
import com.ghaemkarimi.daneshjooyar.databinding.ActivityCourseBinding
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnFinish
import com.ghaemkarimi.daneshjooyar.mvp.ext.SetDialog

class CourseActivityView(private val context: Context, private val onFinish: OnFinish) {

    val binding = ActivityCourseBinding.inflate(LayoutInflater.from(context))
    private val setDialog = SetDialog(context)
    private val backBtn = R.drawable.inner_shadow

    fun setData() {

        binding.backInformation.setOnClickListener {
            binding.lineInformation.visibility = View.VISIBLE
            binding.lineVideos.visibility = View.INVISIBLE
            binding.scrollView.visibility = View.VISIBLE
            binding.backInformation.setBackgroundResource(backBtn)
            binding.backVideos.background = null
        }

        binding.backVideos.setOnClickListener {
            binding.lineInformation.visibility = View.INVISIBLE
            binding.lineVideos.visibility = View.VISIBLE
            binding.scrollView.visibility = View.INVISIBLE
            binding.backVideos.setBackgroundResource(backBtn)
            binding.backInformation.background = null
        }

        binding.arrowBack.setOnClickListener {
            onFinish.finished()
        }

        binding.support.setOnClickListener {
            setDialog.setDialogSupport()
        }

    }

    fun setRecycler(data: ArrayList<AboutModel>) {

        val adapter = AdapterRecyclerAboutUs(context, data)

        binding.recycler.layoutManager = GridLayoutManager(
            context, 2, RecyclerView.VERTICAL, false
        )

        binding.recycler.adapter = adapter

    }

}