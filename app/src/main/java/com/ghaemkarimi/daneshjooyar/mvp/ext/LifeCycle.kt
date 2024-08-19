package com.ghaemkarimi.daneshjooyar.mvp.ext

import android.view.Window

interface LifeCycle {

    fun onCreate() {}

    fun onStart() {}

    fun onDestroy() {}

    fun hideStatusBar(window: Window) {}

}