package com.ghaemkarimi.daneshjooyar.mvp.view

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.Window
import android.view.WindowInsets
import android.view.WindowManager
import com.ghaemkarimi.daneshjooyar.databinding.ActivityGhavaninBinding
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnFinish

class GhavaninActivityView(context: Context, private val onFinish: OnFinish) {

    val binding = ActivityGhavaninBinding.inflate(LayoutInflater.from(context))

    fun setData(text: String) {

        binding.back.setOnClickListener { onFinish.finished() }

        binding.text.text = text

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