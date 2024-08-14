package com.ghaemkarimi.daneshjooyar.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ghaemkarimi.daneshjooyar.adapter.model.VideoModel
import com.ghaemkarimi.daneshjooyar.db.DBHelper
import com.ghaemkarimi.daneshjooyar.db.model.DaoVideosModel
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoVideos {

    @Insert
    fun saveVideo(vararg videos: DaoVideosModel)

    @Query("SELECT id, title, img, seen FROM ${DBHelper.TABLE_VIDEOS}")
    fun getVideosForRecycler(): Flow<List<VideoModel>>

}