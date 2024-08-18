package com.ghaemkarimi.daneshjooyar.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ghaemkarimi.daneshjooyar.adapter.model.VideoModel
import com.ghaemkarimi.daneshjooyar.db.DBHelper
import com.ghaemkarimi.daneshjooyar.db.model.DaoVideoModel
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoVideos {

    @Insert
    fun saveVideo(vararg videos: DaoVideoModel)

    @Query("SELECT id, title, img, seen FROM ${DBHelper.TABLE_VIDEOS}")
    fun getVideosForRecycler(): Flow<List<VideoModel>>

    @Query("SELECT * FROM ${DBHelper.TABLE_VIDEOS} WHERE id = :id")
    fun getVideo(id: Int): DaoVideoModel

    @Query("UPDATE ${DBHelper.TABLE_VIDEOS} SET seen = :state WHERE id = :idVideo")
    fun updateSeen(state: Boolean ,idVideo: Int)

    @Query("UPDATE ${DBHelper.TABLE_VIDEOS} SET duration = :duration WHERE id = :idVideo")
    fun updateDuration(duration: Int ,idVideo: Int)

}