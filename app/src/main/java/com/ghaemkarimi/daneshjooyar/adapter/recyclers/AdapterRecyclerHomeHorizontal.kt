package com.ghaemkarimi.daneshjooyar.adapter.recyclers

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ghaemkarimi.daneshjooyar.R
import com.ghaemkarimi.daneshjooyar.adapter.model.HomeModel
import com.ghaemkarimi.daneshjooyar.databinding.ItemRecyclerHomeHorizontalBinding

class AdapterRecyclerHomeHorizontal(
    private val context: Context,
    private val allData: ArrayList<HomeModel>
) : RecyclerView.Adapter<AdapterRecyclerHomeHorizontal.ViewHolder>() {

    private var selected = 0

    inner class ViewHolder(
        private val binding: ItemRecyclerHomeHorizontalBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        val bind = binding

        fun setData(data: HomeModel) {

            binding.img.setImageResource(data.image)
            binding.txt.text = data.text

            binding.root.setOnClickListener {
                notifyItemChanged(selected)
                selected = data.id - 1
                notifyItemChanged(selected)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemRecyclerHomeHorizontalBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = allData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(allData[position])

        if (selected == position) {
            holder.bind.root.setBackgroundResource(
                R.drawable.back_item_recycler_home_horizontal_selected
            )
            holder.bind.txt.setTextColor(context.getColor(R.color.white))
        } else {
            holder.bind.root.setBackgroundResource(
                R.drawable.back_item_recycler_home_horizontal
            )
            holder.bind.txt.setTextColor(context.getColor(R.color.black))
        }

    }

}