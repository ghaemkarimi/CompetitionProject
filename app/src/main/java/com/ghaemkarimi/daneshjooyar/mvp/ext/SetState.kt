package com.ghaemkarimi.daneshjooyar.mvp.ext

interface SetState {

    fun getState(state: Boolean) {}

    fun onPause(isSet: Boolean) {}

}