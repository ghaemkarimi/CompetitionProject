package com.ghaemkarimi.daneshjooyar.adapter.recyclers

import android.content.Context
import android.graphics.LinearGradient
import android.graphics.Shader
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ghaemkarimi.daneshjooyar.R
import com.ghaemkarimi.daneshjooyar.adapter.model.AboutModel
import com.ghaemkarimi.daneshjooyar.databinding.ItemRecyclerAboutUsBinding

class AdapterRecyclerAboutUs(
    private val context: Context,
    private val allData: ArrayList<AboutModel>
) : RecyclerView.Adapter<AdapterRecyclerAboutUs.ViewHolder>() {

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

    inner class ViewHolder(
        private val binding: ItemRecyclerAboutUsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun setData(data: AboutModel) {

            val txt1 = binding.txt1
            val txt2 = binding.txt2

            binding.img1.setImageResource(data.img1)
            binding.img2.setImageResource(data.img2)
            binding.title1.text = data.title1
            binding.title2.text = data.title2

            txt1.text = data.text1
            txt2.text = data.text2
            setGradient(txt1)
            setGradient(txt2)

        }

        //ایجاد گرادینت برای متن textView
        private fun setGradient(textView: TextView) {

            val paint = textView.paint
            val width = paint.measureText(textView.text.toString())
            paint.shader = LinearGradient(
                0f, 0f, width, textView.textSize, intArrayOf(
                    context.getColor(R.color.primary),
                    context.getColor(R.color.lightBlue)
                ), null, Shader.TileMode.REPEAT
            )

        }

    }

}