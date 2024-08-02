package com.ghaemkarimi.daneshjooyar.customView

enum class Type {
    HOME, ABOUT_US, DOCUMENT
}

interface Item {
    fun setFragment(type: Type)
}