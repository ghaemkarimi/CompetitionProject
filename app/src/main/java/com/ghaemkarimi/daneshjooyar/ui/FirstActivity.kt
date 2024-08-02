package com.ghaemkarimi.daneshjooyar.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.ghaemkarimi.daneshjooyar.R

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        Handler(mainLooper).postDelayed(
            {startActivity(Intent(this, LoginActivity::class.java))},
            2000
        )
    }
}