package com.ghaemkarimi.daneshjooyar.mvp.view

import android.content.Context
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.MediaController
import com.ghaemkarimi.daneshjooyar.databinding.ActivityVideoBinding
import com.ghaemkarimi.daneshjooyar.db.model.DaoVideoModel
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnBindData
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnFinish
import com.ghaemkarimi.daneshjooyar.mvp.ext.SetDialog

class VideoActivityView(context: Context, private val onFinish: OnFinish) {

    val binding = ActivityVideoBinding.inflate(LayoutInflater.from(context))
    private val dialog = SetDialog(context)
    private val controller = MediaController(context)
    private val video = binding.video
    private val percentageSeen = ArrayList<Int>()

    fun setData(id: Int, onBindData: OnBindData) {

        onBindData.setVideo(id)
        var idVideo = id

        binding.btnNext.setOnClickListener {
            idVideo += 1
            onBindData.setVideo(idVideo)
            video.stopPlayback()
        }

        binding.btnPreview.setOnClickListener {
            idVideo -= 1
            onBindData.setVideo(idVideo)
            video.stopPlayback()
        }

        binding.arrowBack.setOnClickListener { onFinish.finished() }
        binding.support.setOnClickListener { dialog.setDialogSupport() }

    }

    fun setVideoData(
        data: DaoVideoModel,
        seconds: List<Int>,
        videoCount: Int
    ) {

        binding.progressVideo.visibility = View.VISIBLE

        percentageSeen.clear()
        percentageSeen.addAll(seconds)

        val uri = Uri.parse(data.uri)
        video.setVideoURI(uri)

        video.setOnPreparedListener {
            binding.progressVideo.visibility = View.INVISIBLE
            val percentage = (seconds.size / (video.duration / 1000)) * 100
            binding.txtPercentage.text = percentage.toString()
            binding.progressPercentage.max = video.duration / 1000
            binding.progressPercentage.progress = percentageSeen.size
            video.setMediaController(controller)
            controller.hide()
            binding.icPlay.setOnClickListener {
                initVideo()
            }
        }

        binding.txtTitle.text = data.title
        binding.txtDescription.text = data.description
        binding.imgVideo.setImageResource(data.img)

        binding.preview.visibility = View.VISIBLE
        binding.next.visibility = View.VISIBLE
        binding.cardView.visibility = View.VISIBLE

        when (data.id) {
            1 -> binding.preview.visibility = View.INVISIBLE
            videoCount -> binding.next.visibility = View.INVISIBLE
        }
        
    }

    private fun initVideo() {

        binding.cardView.visibility = View.GONE
        video.visibility = View.VISIBLE
        video.start()

        val handler = Handler(Looper.getMainLooper())

        handler.postDelayed(object : Runnable {

            override fun run() {

                try {
                    if (video.isPlaying) {
                        if (video.currentPosition / 1000 !in percentageSeen) {
                            /*onBindData.saveSeconds(
                                DaoSeenSecondsModel(
                                    idVideo,
                                    video.currentPosition / 1000
                                )
                            )*/
                            percentageSeen.add(video.currentPosition / 1000)
                        }
                        binding.progressPercentage.progress = percentageSeen.size
                    }
                    handler.postDelayed(this, 1000)
                } catch (e: Exception) {
                    Log.e("ERROR", e.message.toString())
                }

            }

        }, 0)

    }

}