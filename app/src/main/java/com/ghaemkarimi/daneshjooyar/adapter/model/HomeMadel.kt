package com.ghaemkarimi.daneshjooyar.adapter.model

import androidx.room.ForeignKey

data class HomeModelHorizontal(
    val id: Int,
    val text: String,
    val image: Int
)

data class HomeModelVertical(
    val id: Int,
    val foreignKey: Int,
    val text: String,
    val image: Int
)

