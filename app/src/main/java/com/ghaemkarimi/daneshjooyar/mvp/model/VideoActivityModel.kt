package com.ghaemkarimi.daneshjooyar.mvp.model

import android.content.Context
import com.ghaemkarimi.daneshjooyar.db.DBHelper
import com.ghaemkarimi.daneshjooyar.db.model.DaoSeenSecondsModel
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnBindData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VideoActivityModel(context: Context) {

    private val db = DBHelper.getDatabase(context)
    private val pref = context.getSharedPreferences("save", Context.MODE_PRIVATE)

    fun isSet(): Boolean {

        val isSet = pref.getBoolean("isSet", false)

        if (!isSet) {

            val editor = pref.edit()
            editor.putBoolean("isSet", true)
            editor.apply()

        }

        return isSet

    }

    fun getVideo(idVideo: Int, onBindData: OnBindData) {

        CoroutineScope(Dispatchers.IO).launch {

            val video = db.videos().getVideo(idVideo)

            launch(Dispatchers.Main) {

                onBindData.getVideo(video)

            }

        }

    }

    fun getSeconds(idVideo: Int, onBindData: OnBindData) {

        CoroutineScope(Dispatchers.IO).launch {

            val seconds = db.seenSeconds().getSecondsSeen(idVideo)

            launch(Dispatchers.Main) {

                onBindData.getSeconds(seconds)

            }

        }

    }

    fun updateDuration(duration: Int, idVideo: Int) {

        CoroutineScope(Dispatchers.IO).launch {

            db.videos().updateDuration(duration, idVideo)

        }

    }

    fun saveSeconds(second: DaoSeenSecondsModel) {

        CoroutineScope(Dispatchers.IO).launch {

            db.seenSeconds().saveSeconds(second)

        }

    }

    fun setSeenVideo(state: Boolean, idVideo: Int) {

        CoroutineScope(Dispatchers.IO).launch {

            db.videos().updateSeen(state, idVideo)

        }

    }

}