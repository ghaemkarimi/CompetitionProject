package com.ghaemkarimi.daneshjooyar.mvp.view.fragment

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ghaemkarimi.daneshjooyar.adapter.model.HomeModel
import com.ghaemkarimi.daneshjooyar.adapter.recyclers.AdapterRecyclerHomeHorizontal
import com.ghaemkarimi.daneshjooyar.databinding.FragmentHomeBinding
import com.ghaemkarimi.daneshjooyar.mvp.ext.SetSelection

class HomeFragmentView(private val context: Context) {

    val binding = FragmentHomeBinding.inflate(LayoutInflater.from(context))
    private lateinit var adapter : AdapterRecyclerHomeHorizontal

    fun setRecyclerHorizontal(data: ArrayList<HomeModel>) {

        adapter = AdapterRecyclerHomeHorizontal(context, data)

        binding.recyclerHorizontal.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

        binding.recyclerHorizontal.adapter = adapter

    }

}