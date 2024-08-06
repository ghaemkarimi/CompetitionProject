package com.ghaemkarimi.daneshjooyar.mvp.view.fragment

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ghaemkarimi.daneshjooyar.adapter.model.HomeModelHorizontal
import com.ghaemkarimi.daneshjooyar.adapter.model.HomeModelVertical
import com.ghaemkarimi.daneshjooyar.adapter.recyclers.AdapterRecyclerHomeHorizontal
import com.ghaemkarimi.daneshjooyar.adapter.recyclers.AdapterRecyclerHomeVertical
import com.ghaemkarimi.daneshjooyar.databinding.FragmentHomeBinding
import com.ghaemkarimi.daneshjooyar.mvp.ext.SetSelection

class HomeFragmentView(private val context: Context) {

    val binding = FragmentHomeBinding.inflate(LayoutInflater.from(context))

    fun setRecyclerHorizontal(data: ArrayList<HomeModelHorizontal>, setSelection: SetSelection) {

        val adapter = AdapterRecyclerHomeHorizontal(context, data, setSelection)

        binding.recyclerHorizontal.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

        binding.recyclerHorizontal.adapter = adapter

    }

    fun setRecyclerVertical(foreignKey: Int, allData: ArrayList<HomeModelVertical>) {

        val data = ArrayList<HomeModelVertical>()

        allData.forEach {
            if (it.foreignKey == foreignKey)
                data.add(it)
        }

        val adapter = AdapterRecyclerHomeVertical(context, data)

        binding.recyclerVertical.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        binding.recyclerVertical.adapter = adapter

    }

}