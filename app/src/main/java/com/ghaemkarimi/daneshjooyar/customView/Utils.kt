package com.ghaemkarimi.daneshjooyar.customView

enum class Type {
    HOME, ABOUT, DOCUMENT
}

interface Item {
    fun setFragment(type: Type)
}