package com.ghaemkarimi.daneshjooyar.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ghaemkarimi.daneshjooyar.db.dao.DaoVideos
import com.ghaemkarimi.daneshjooyar.db.model.DaoVideosModel

@Database(entities = [DaoVideosModel::class], version = DBHelper.DBVersion)
abstract class DBHelper : RoomDatabase() {

    abstract fun videos(): DaoVideos

    companion object {

        private const val DBName = "Videos.db"
        const val DBVersion = 1

        const val TABLE_VIDEOS = "videos"

        private var database: DBHelper? = null

        fun getDatabase(context: Context): DBHelper {

            if (database == null)
                database = Room.databaseBuilder(
                    context,
                    DBHelper::class.java,
                    DBName
                ).fallbackToDestructiveMigration().build()

            return database!!
        }

    }

}