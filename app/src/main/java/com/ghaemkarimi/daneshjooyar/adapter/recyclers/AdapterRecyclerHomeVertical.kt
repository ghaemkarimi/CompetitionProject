package com.ghaemkarimi.daneshjooyar.adapter.recyclers

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ghaemkarimi.daneshjooyar.adapter.model.HomeModelVertical
import com.ghaemkarimi.daneshjooyar.databinding.ItemRecyclerHomeVerticalBinding

class AdapterRecyclerHomeVertical(
    private val context: Context,
    private val allData: ArrayList<HomeModelVertical>
) : RecyclerView.Adapter<AdapterRecyclerHomeVertical.ViewHolder>() {

    inner class ViewHolder(
        private val binding: ItemRecyclerHomeVerticalBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun setData(data: HomeModelVertical) {

            binding.img.setImageResource(data.image)
            binding.txt.text = data.text

            binding.root.setOnClickListener {
                //startAct
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemRecyclerHomeVerticalBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = allData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(allData[position])
    }

}

