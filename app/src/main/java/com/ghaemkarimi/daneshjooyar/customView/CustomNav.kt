package com.ghaemkarimi.daneshjooyar.customView

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.ghaemkarimi.daneshjooyar.R
import com.ghaemkarimi.daneshjooyar.databinding.CustomNavBinding

class CustomNav(
    context: Context,
    attr: AttributeSet
): FrameLayout(context, attr) {

    private val binding = CustomNavBinding.inflate(LayoutInflater.from(context))

    init {
        addView(binding.root)
    }

    fun selectItem(item: Item) {

        binding.document.setOnClickListener {
            item.setFragment(Type.DOCUMENT)
            document()
        }

        binding.aboutUs.setOnClickListener {
            item.setFragment(Type.ABOUT)
            aboutUs()
        }

        binding.home.setOnClickListener {
            item.setFragment(Type.HOME)
            home()
        }

    }

    private fun document() {

        setIcon(binding.icDocument, R.drawable.ic_document_active)
        setTextColor(binding.txtDocument)

    }

    private fun aboutUs() {

        setIcon(binding.icAboutUs, R.drawable.ic_about_us_active)
        setTextColor(binding.txtAboutUs)

    }

    fun home() {

        setIcon(binding.icHome, R.drawable.ic_home_active)
        setTextColor(binding.txtHome)

    }

    private fun setIcon(img: ImageView, icon: Int) {

        binding.icDocument.setImageResource(R.drawable.ic_document)
        binding.icAboutUs.setImageResource(R.drawable.ic_about_as)
        binding.icHome.setImageResource(R.drawable.ic_home)
        img.setImageResource(icon)

    }

    private fun setTextColor(textView: TextView) {

        binding.txtDocument.setTextColor(context.getColor(R.color.gray))
        binding.txtAboutUs.setTextColor(context.getColor(R.color.gray))
        binding.txtHome.setTextColor(context.getColor(R.color.gray))
        textView.setTextColor(context.getColor(R.color.accent))

    }

}