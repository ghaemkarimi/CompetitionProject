package com.ghaemkarimi.daneshjooyar.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ghaemkarimi.daneshjooyar.db.DBHelper

@Entity(tableName = DBHelper.TABLE_VIDEOS)
data class DaoVideosModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo
    val title: String,
    val description: String,
    val img: Int,
    val uri: String,
    val seen: Boolean,
    val amountSeen: ArrayList<Int>

)