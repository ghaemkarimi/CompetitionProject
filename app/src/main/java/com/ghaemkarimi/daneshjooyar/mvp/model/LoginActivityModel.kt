package com.ghaemkarimi.daneshjooyar.mvp.model

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class LoginActivityModel(context: Context) {

    private val pref = context.getSharedPreferences("", AppCompatActivity.MODE_PRIVATE)

    fun save(state: Boolean) {

        val save = pref.edit()
        save.putBoolean("state", state)
        save.apply()

    }

}