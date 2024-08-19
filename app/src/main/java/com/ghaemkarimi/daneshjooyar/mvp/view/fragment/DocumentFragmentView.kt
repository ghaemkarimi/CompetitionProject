package com.ghaemkarimi.daneshjooyar.mvp.view.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.ghaemkarimi.daneshjooyar.customView.Item
import com.ghaemkarimi.daneshjooyar.customView.Type
import com.ghaemkarimi.daneshjooyar.databinding.FragmentDocumentBinding

class DocumentFragmentView(context: Context, private val item: Item) {

    val binding = FragmentDocumentBinding.inflate(LayoutInflater.from(context))

    fun setData(stateEndCourse: Boolean) {

        if (stateEndCourse) {
            binding.notEndCourse.visibility = View.GONE
            binding.endCourse.visibility = View.VISIBLE
        }

        binding.btnShowCourses.setOnClickListener {
            item.setFragment(Type.HOME)
        }

    }

}