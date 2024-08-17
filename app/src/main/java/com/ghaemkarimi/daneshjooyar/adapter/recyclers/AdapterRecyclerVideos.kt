package com.ghaemkarimi.daneshjooyar.adapter.recyclers

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ghaemkarimi.daneshjooyar.R
import com.ghaemkarimi.daneshjooyar.adapter.model.VideoModel
import com.ghaemkarimi.daneshjooyar.databinding.ItemRecyclerVideosBinding
import com.ghaemkarimi.daneshjooyar.ui.VideoActivity

class AdapterRecyclerVideos(
    private val context: Context,
    private val videos: List<VideoModel>
) : RecyclerView.Adapter<AdapterRecyclerVideos.ViewHolder>() {

    inner class ViewHolder(
        private val binding: ItemRecyclerVideosBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun setData(data: VideoModel) {

            binding.title.text = data.title
            binding.img.setImageResource(data.img)

            if (data.seen) {
                binding.background.setCardBackgroundColor(context.getColor(R.color.lightGreen))
                binding.background.strokeColor = context.getColor(R.color.green)
            }

            binding.root.setOnClickListener {
                val intent = Intent(context, VideoActivity::class.java)
                intent.putExtra("id", data.id)
                intent.putExtra("videoCount", videos.size)
                context.startActivity(intent)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemRecyclerVideosBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = videos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(videos[position])
    }

}