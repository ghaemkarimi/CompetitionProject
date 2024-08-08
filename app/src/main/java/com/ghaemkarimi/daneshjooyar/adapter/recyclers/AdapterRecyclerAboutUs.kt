package com.ghaemkarimi.daneshjooyar.adapter.recyclers

import android.content.Context
import android.graphics.LinearGradient
import android.graphics.Shader
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ghaemkarimi.daneshjooyar.R
import com.ghaemkarimi.daneshjooyar.adapter.model.AboutModel
import com.ghaemkarimi.daneshjooyar.databinding.ItemRecyclerAboutUsBinding

class AdapterRecyclerAboutUs(
    private val context: Context,
    private val allData: ArrayList<AboutModel>
) : RecyclerView.Adapter<AdapterRecyclerAboutUs.ViewHolder>() {

    inner class ViewHolder(
        private val binding: ItemRecyclerAboutUsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun setData(data: AboutModel) {

            val txt = binding.txt

            binding.img.setImageResource(data.img)
            txt.text = data.text
            binding.title.text = data.title

            //ایجاد گرادینت برای متن textView
            val paint = txt.paint
            val width = paint.measureText(txt.text.toString())
            paint.shader = LinearGradient(
                0f, 0f, width, txt.textSize, intArrayOf(
                    context.getColor(R.color.primary),
                    context.getColor(R.color.lightBlue)
                ), null, Shader.TileMode.REPEAT
            )

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemRecyclerAboutUsBinding.inflate(
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