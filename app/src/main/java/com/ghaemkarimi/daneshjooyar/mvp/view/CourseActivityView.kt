package com.ghaemkarimi.daneshjooyar.mvp.view

import android.content.Context
import android.net.Uri
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.MediaController
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
import com.ghaemkarimi.daneshjooyar.mvp.ext.SetState

class CourseActivityView(private val context: Context, private val onFinish: OnFinish) {

    val binding = ActivityCourseBinding.inflate(LayoutInflater.from(context))
    private val setDialog = SetDialog(context)
    private val backBtn = R.drawable.inner_shadow
    private var endCourse = false
    private val video = binding.video
    private val controller = MediaController(context)
    private var isPlayingVideo = false
    private var currentPositionVideo = 0

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

    fun setRecyclerVideo(data: List<VideoModel>, setState: SetState) {

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

        if (endCourse) {
            if (binding.recyclerVideos.visibility == View.VISIBLE)
                binding.imgEndCourse.visibility = View.VISIBLE
            setState.getState(true)
        }

    }

    fun hideStatusBar(window: Window) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R)
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

    }

    fun setVideo(uri: String) {

        video.setVideoURI(Uri.parse(uri))
        binding.icPlay.setOnClickListener { startVideo() }
        if (isPlayingVideo) startVideo()

    }

    private fun startVideo() {

        binding.cardView.visibility = View.INVISIBLE
        video.visibility = View.VISIBLE
        binding.progressVideo.visibility = View.VISIBLE
        video.start()
        video.setOnPreparedListener {
            binding.progressVideo.visibility = View.INVISIBLE
            it.setOnVideoSizeChangedListener { _, _, _ ->
                video.setMediaController(controller)
                controller.setAnchorView(video)
                controller.hide()
            }
        }

    }

    fun onPause() {

        binding.cardView.visibility = View.VISIBLE
        video.visibility = View.INVISIBLE
        binding.progressVideo.visibility = View.INVISIBLE
        video.stopPlayback()

    }

    fun saveStateVideo() = Pair(video.currentPosition, video.isPlaying)

    fun getStateVideo(currentPosition: Int, isPlaying: Boolean, uri: String) {

        currentPositionVideo = currentPosition
        isPlayingVideo = isPlaying
        setVideo(uri)

    }

}