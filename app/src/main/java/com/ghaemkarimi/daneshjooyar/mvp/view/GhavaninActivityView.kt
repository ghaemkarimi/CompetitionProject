package com.ghaemkarimi.daneshjooyar.mvp.view

import android.content.Context
import android.view.LayoutInflater
import com.ghaemkarimi.daneshjooyar.databinding.ActivityGhavaninBinding
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnFinish

class GhavaninActivityView(context: Context, private val onFinish: OnFinish) {

    val binding = ActivityGhavaninBinding.inflate(LayoutInflater.from(context))

    fun setData(text: String) {

        binding.back.setOnClickListener { onFinish.finished() }

        binding.text.text = text

    }

}