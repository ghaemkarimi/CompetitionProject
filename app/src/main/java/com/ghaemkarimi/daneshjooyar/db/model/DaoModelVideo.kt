package com.ghaemkarimi.daneshjooyar.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.ghaemkarimi.daneshjooyar.db.DBHelper
import java.time.Duration

@Entity(tableName = DBHelper.TABLE_VIDEOS)
data class DaoVideoModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo
    val title: String,
    val description: String,
    val img: Int,
    val uri: String,
    val seen: Boolean,
    val duration: Int

)

@Entity(
    tableName = DBHelper.TABLE_SEEN_SECONDS, foreignKeys = [
        ForeignKey(
            DaoVideoModel::class,
            ["id"],
            ["idVideo"],
            ForeignKey.CASCADE,
            ForeignKey.CASCADE
        )
    ]
)
data class DaoSeenSecondsModel(

    @PrimaryKey val idVideo: Int,
    @ColumnInfo val secondSeen: Int

)