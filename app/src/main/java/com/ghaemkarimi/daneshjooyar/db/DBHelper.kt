package com.ghaemkarimi.daneshjooyar.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ghaemkarimi.daneshjooyar.db.dao.DaoSeenSeconds
import com.ghaemkarimi.daneshjooyar.db.dao.DaoVideos
import com.ghaemkarimi.daneshjooyar.db.model.DaoSeenSecondsModel
import com.ghaemkarimi.daneshjooyar.db.model.DaoVideoModel

@Database(
    entities = [DaoVideoModel::class, DaoSeenSecondsModel::class],
    version = DBHelper.DBVersion
)
abstract class DBHelper : RoomDatabase() {

    abstract fun videos(): DaoVideos
    abstract fun seenSeconds(): DaoSeenSeconds

    companion object {

        private const val DBName = "Videos.db"
        const val DBVersion = 1

        const val TABLE_VIDEOS = "videos"
        const val TABLE_SEEN_SECONDS = "seenSeconds"

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