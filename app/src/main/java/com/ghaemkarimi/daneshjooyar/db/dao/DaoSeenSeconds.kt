package com.ghaemkarimi.daneshjooyar.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ghaemkarimi.daneshjooyar.db.DBHelper
import com.ghaemkarimi.daneshjooyar.db.model.DaoSeenSecondsModel

@Dao
interface DaoSeenSeconds {

    @Insert
    fun saveSeconds(vararg seconds: DaoSeenSecondsModel)

    @Query("SELECT secondSeen FROM ${DBHelper.TABLE_SEEN_SECONDS} WHERE idVideo = :idVideo")
    fun getSecondsSeen(idVideo: Int): List<Int>

}