package com.ghaemkarimi.daneshjooyar.mvp.model.fragment

import android.content.Context

class DocumentFragmentModel(context: Context) {

    private val pref = context.getSharedPreferences("save", Context.MODE_PRIVATE)

    fun getStateEndCourse(): Boolean =
        pref.getBoolean("stateSeen", false)

}