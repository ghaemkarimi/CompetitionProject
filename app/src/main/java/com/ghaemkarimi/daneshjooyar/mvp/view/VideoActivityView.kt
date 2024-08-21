package com.ghaemkarimi.daneshjooyar.mvp.view

import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.os.Looper
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
    private var idVideo = 0

    fun setData(id: Int, onBindData: OnBindData) {

        onBindData.setVideo(id)
        var idVideo = id

        binding.btnNext?.setOnClickListener {
            releaseVideo()
            idVideo += 1
            onBindData.setVideo(idVideo)
        }
        binding.btnPreview?.setOnClickListener {
            releaseVideo()
            idVideo -= 1
            onBindData.setVideo(idVideo)
        }

        binding.btnHelper?.setOnClickListener {
            Toast.makeText(context, "راهنما", Toast.LENGTH_SHORT).show()
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

        idVideo = data.id

        percentageSeen.clear()
        percentageSeen.addAll(seconds)

        binding.progressPercentage.progress = 0
        binding.txtPercentage?.text = "0"

        if (data.duration != 0) {
            setPercentage(percentageSeen.size, data.duration)
        }

        val uri = Uri.parse(data.uri)
        video.setVideoURI(uri)
        video.setMediaController(controller)
        controller.hide()

        video.setOnPreparedListener {
            binding.progressVideo.visibility = View.INVISIBLE
            video.seekTo(currentPositionVideo)
            if (data.duration == 0) {
                val duration = video.duration / 1000
                setPercentage(percentageSeen.size, duration)
                onBindData.updateDuration(duration, data.id)
            }
            it.setOnVideoSizeChangedListener { _, _, _ ->
                controller.setAnchorView(video)
            }
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

        binding.icPlay.setOnClickListener { initVideo(data.id, data.seen, onBindData) }
        if (isPlayingVideo) initVideo(data.id, data.seen, onBindData)

    }

    private fun setPercentage(secondsNumber: Int, duration: Int) {

        val percentage = ((secondsNumber * 100) / duration)
        binding.txtPercentage?.text = percentage.toString()
        binding.progressPercentage.max = duration
        binding.progressPercentage.progress = percentageSeen.size

    }

    private fun initVideo(idVideo: Int, seen: Boolean, onBindData: OnBindData) {

        videoVisible()
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

                } catch (e: Exception) { video.seekTo(0) }

            }

        }, 0)

    }

    fun saveStateVideo() = Triple(video.currentPosition, video.isPlaying, idVideo)

    fun getStateVideo(currentPosition: Int, isPlaying: Boolean) {

        currentPositionVideo = currentPosition
        isPlayingVideo = isPlaying
        if (currentPosition != 0) videoVisible()

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

    private fun videoVisible() {

        binding.progressVideo.visibility = View.VISIBLE
        binding.cardView?.visibility = View.GONE
        binding.imgVideo.visibility = View.GONE
        binding.icPlay.visibility = View.GONE
        video.visibility = View.VISIBLE

    }

    private fun releaseVideo() {

        currentPositionVideo = 0
        isPlayingVideo = false
        video.stopPlayback()
        video.visibility = View.INVISIBLE
        binding.progressVideo.visibility = View.INVISIBLE
        binding.cardView?.visibility = View.VISIBLE
        binding.imgVideo.visibility = View.VISIBLE
        binding.icPlay.visibility = View.VISIBLE

    }

}