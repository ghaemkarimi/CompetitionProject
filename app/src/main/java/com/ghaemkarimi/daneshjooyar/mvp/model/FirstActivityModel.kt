package com.ghaemkarimi.daneshjooyar.mvp.model

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class FirstActivityModel(context: Context) {

    private val pref = context.getSharedPreferences("stateLogin", AppCompatActivity.MODE_PRIVATE)

    fun getStateLogin() = pref.getBoolean("state", false)

}