package com.ghaemkarimi.daneshjooyar.mvp.view.fragment

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ghaemkarimi.daneshjooyar.adapter.model.AboutModel
import com.ghaemkarimi.daneshjooyar.adapter.recyclers.AdapterRecyclerAboutUs
import com.ghaemkarimi.daneshjooyar.databinding.FragmentAboutUsBinding

class AboutUsFragmentView(private val context: Context) {

    val binding = FragmentAboutUsBinding.inflate(LayoutInflater.from(context))

    fun setRecycler(data: ArrayList<AboutModel>) {

        val adapter = AdapterRecyclerAboutUs(context, data)

        binding.recycler.layoutManager = GridLayoutManager(
            context, 2, RecyclerView.VERTICAL, false
        )

        binding.recycler.adapter = adapter

    }

    private lateinit var instagramIntent: Intent
    private lateinit var youtubeIntent: Intent

    fun setIntents() {

        instagramIntent = setIntent(
            "https://www.instagram.com/lrn.ir?igsh=dDFndWZpMzl1dmhr",
            "com.instagram.android"
        )

        youtubeIntent = setIntent(
            "https://www.youtube.com/@alireza-ahmadi",
            "com.youtube.android"
        )

        binding.btnInstagram.setOnClickListener {
            startApp(instagramIntent)
        }

        binding.btnYoutube.setOnClickListener {
            startApp(youtubeIntent)
        }

    }

    private fun startApp(intent: Intent) {

        try {
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            val chooser = Intent.createChooser(intent, "بازکردن با")
            context.startActivity(chooser)
        }

    }

    private fun setIntent(address: String, packageName: String): Intent {

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(address))
        intent.setPackage(packageName)

        return intent

    }

}