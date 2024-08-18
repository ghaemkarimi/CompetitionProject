package com.ghaemkarimi.daneshjooyar.mvp.view

import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.MediaController
import android.widget.Toast
import com.ghaemkarimi.daneshjooyar.databinding.ActivityVideoBinding
import com.ghaemkarimi.daneshjooyar.db.model.DaoSeenSecondsModel
import com.ghaemkarimi.daneshjooyar.db.model.DaoVideoModel
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnBindData
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnFinish
import com.ghaemkarimi.daneshjooyar.mvp.ext.SetDialog

class VideoActivityView(private val context: Context, private val onFinish: OnFinish) {

    val binding = ActivityVideoBinding.inflate(LayoutInflater.from(context))
    private val dialog = SetDialog(context)
    private val controller = MediaController(context)
    private val video = binding.video
    private var percentageSeen = ArrayList<Int>()
    private var currentPositionVideo = 0
    private var isPlayingVideo = false

    fun setData(id: Int, onBindData: OnBindData) {

        onBindData.setVideo(id)
        var idVideo = id

        binding.btnNext?.setOnClickListener {
            idVideo += 1
            onBindData.setVideo(idVideo)
            video.stopPlayback()
            binding.progressVideo.visibility = View.INVISIBLE
        }

        binding.btnPreview?.setOnClickListener {
            idVideo -= 1
            onBindData.setVideo(idVideo)
            video.stopPlayback()
            binding.progressVideo.visibility = View.INVISIBLE
        }

        binding.arrowBack?.setOnClickListener { onFinish.finished() }
        binding.support?.setOnClickListener { dialog.setDialogSupport() }

    }

    fun setVideoData(
        data: DaoVideoModel,
        videoCount: Int,
        seconds: List<Int>,
        onBindData: OnBindData
    ) {

        if (!isPlayingVideo && currentPositionVideo == 0) {
            video.visibility = View.INVISIBLE
            binding.cardView?.visibility = View.VISIBLE
            binding.imgVideo.visibility = View.VISIBLE
            binding.icPlay.visibility = View.VISIBLE
        }

        binding.icPlay.setOnClickListener { initVideo(data.id, data.seen, onBindData) }

        percentageSeen.clear()
        percentageSeen.addAll(seconds)

        binding.progressPercentage.progress = 0
        binding.txtPercentage?.text = "0"

        if (data.duration != 0) {
            setPercentage(percentageSeen.size, data.duration)
        }

        val uri = Uri.parse(data.uri)
        video.setVideoURI(uri)

        video.setOnPreparedListener {
            binding.progressVideo.visibility = View.INVISIBLE
            if (data.duration == 0) {
                val duration = video.duration / 1000
                setPercentage(percentageSeen.size, duration)
                onBindData.updateDuration(duration, data.id)
            }
            it.setOnVideoSizeChangedListener { _, _, _ ->
                video.setMediaController(controller)
                controller.setAnchorView(video)
                controller.hide()
            }
            video.seekTo(currentPositionVideo)
        }

        binding.txtTitle?.text = data.title
        binding.txtDescription?.text = data.description
        binding.imgVideo.setImageResource(data.img)

        binding.preview?.visibility = View.VISIBLE
        binding.next?.visibility = View.VISIBLE

        when (data.id) {
            1 -> binding.preview?.visibility = View.INVISIBLE
            videoCount -> binding.next?.visibility = View.INVISIBLE
        }

        if (isPlayingVideo) {
            initVideo(data.id, data.seen, onBindData)
        }

        binding.btnHelper?.setOnClickListener {
            Toast.makeText(context, "راهنما", Toast.LENGTH_SHORT).show()
        }

    }

    private fun setPercentage(secondsNumber: Int, duration: Int) {

        val percentage = ((secondsNumber * 100) / duration)
        binding.txtPercentage?.text = percentage.toString()
        binding.progressPercentage.max = duration
        binding.progressPercentage.progress = percentageSeen.size

    }

    private fun initVideo(idVideo: Int, seen: Boolean, onBindData: OnBindData) {

        binding.progressVideo.visibility = View.VISIBLE
        binding.cardView?.visibility = View.GONE
        binding.imgVideo.visibility = View.GONE
        binding.icPlay.visibility = View.GONE
        video.visibility = View.VISIBLE
        video.start()

        val handler = Handler(Looper.getMainLooper())

        handler.postDelayed(object : Runnable {

            override fun run() {

                try {
                    if (video.isPlaying) {
                        if (video.currentPosition / 1000 !in percentageSeen) {
                            onBindData.saveSeconds(
                                DaoSeenSecondsModel(
                                    idVideo = idVideo,
                                    secondSeen = (video.currentPosition / 1000)
                                )
                            )
                            percentageSeen.add(video.currentPosition / 1000)
                        }
                        val percentage = percentageSeen.size * 100 / (video.duration / 1000)
                        binding.txtPercentage?.text = percentage.toString()
                        binding.progressPercentage.progress = percentageSeen.size
                        binding.progressVideo.visibility = View.GONE
                        if (percentage >= 80 && !seen)
                            onBindData.updateSeen(true, idVideo)
                    }
                    handler.postDelayed(this, 1000)
                } catch (e: Exception) {
                    Log.e("ERROR", e.message.toString())
                }

            }

        }, 0)

    }

    fun saveStateVideo() = Pair(video.currentPosition, video.isPlaying)

    fun getStateVideo(currentPosition: Int, isPlaying: Boolean) {

        currentPositionVideo = currentPosition
        isPlayingVideo = isPlaying
        if (isPlayingVideo) {
            video.visibility = View.VISIBLE
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

}