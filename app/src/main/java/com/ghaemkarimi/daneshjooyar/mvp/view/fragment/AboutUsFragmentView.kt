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

    fun setIntents() {

        binding.btnInstagram.setOnClickListener {

            val address = "https://www.instagram.com/lrn.ir?igsh=dDFndWZpMzl1dmhr"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(address))
            intent.setPackage("com.instagram.android")

            try {

                context.startActivity(intent)

            } catch (e: ActivityNotFoundException) {

                val chooser = Intent.createChooser(intent, "بازکردن با")
                context.startActivity(chooser)

            }

        }

        binding.btnYoutube.setOnClickListener {

            val address = "https://www.youtube.com/@alireza-ahmadi"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(address))
            intent.setPackage("com.youtube.android")

            try {

                context.startActivity(intent)

            } catch (e: ActivityNotFoundException) {

                val chooser = Intent.createChooser(intent, "بازکردن با")
                context.startActivity(chooser)

            }

        }

    }

}