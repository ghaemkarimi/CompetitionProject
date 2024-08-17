package com.ghaemkarimi.daneshjooyar.mvp.model

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.ghaemkarimi.daneshjooyar.R
import com.ghaemkarimi.daneshjooyar.adapter.model.AboutModel
import com.ghaemkarimi.daneshjooyar.db.DBHelper
import com.ghaemkarimi.daneshjooyar.db.model.DaoVideoModel
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnBindData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CourseActivityModel(context: Context) {

    private val db = DBHelper.getDatabase(context)
    private val pref = context.getSharedPreferences("save", MODE_PRIVATE)

    fun dataRecyclerAbout() =
        arrayListOf(
            AboutModel(
                1,
                R.drawable.image_about3,
                "۸۲,۸۸۸ نفر",
                "تعداد دانشچو",
                R.drawable.image_about5,
                "۴.۶ از ۵",
                "امتیاز دانشجویان"
            ),
            AboutModel(
                2,
                R.drawable.image_about4,
                "۳۰ عدد",
                "تعداد دوره ها",
                R.drawable.image_about6,
                "۷۶۹ ساعت",
                "ساعت آموزش"
            )
        )

    fun getDataForRecyclerVideo(onBindData: OnBindData) {

        CoroutineScope(Dispatchers.IO).launch {

            val videos = db.videos().getVideosForRecycler()

            launch(Dispatchers.Main) {

                videos.collect {
                    onBindData.getVideos(it)
                }

            }

        }

    }

    fun saveVideo() {

        val stateSave = pref.getBoolean("save", false)

        if (!stateSave) {

            CoroutineScope(Dispatchers.IO).launch {

                dataRecyclerVideos().forEach { db.videos().saveVideo(it) }

            }

            val editor = pref.edit()
            editor.putBoolean("save", true)
            editor.apply()

        }

    }

    fun saveStateSeen(state: Boolean) {

        val stateSeen = pref.getBoolean("stateSeen", false)

        if (!stateSeen) {
            val editor = pref.edit()
            editor.putBoolean("stateSeen", state)
            editor.apply()
        }

    }

    private fun dataRecyclerVideos() =
        arrayListOf(
            DaoVideoModel(
                title = "1. برسی حالت ثابت و مطلق در تنظیمات پیشرفته ویجت ها",
                description = """لورم ایسپوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است چابگرها و متون بلکه روزنامه و محله در ستون و سطرآنچنان که لازم است و برای شرایط فعلی تکنولوژی مورد نیاز و کاربرد های متنوع و با هدف بهبود ابزار های کاربردی می باشد.""",
                img = R.drawable.img_u2,
                uri = "https://drive.usercontent.google.com/download?id=1UL5mN-Az0Fvmn0F8Ldci9nPS4vYZT7lX&export=download&authuser=0&confirm=t&uuid=cea926d1-e622-4757-a5aa-b097ee4d5ea6&at=APZUnTVdeg40sW4FkzEubsCnHI_4:1723875720876",
                seen = false
            ),
            DaoVideoModel(
                title = "2. آموزش گزینه حاشیه در تنظیمات پیشرفته ویجت ها",
                description = """لورم ایسپوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است چابگرها و متون بلکه روزنامه و محله در ستون و سطرآنچنان که لازم است و برای شرایط فعلی تکنولوژی مورد نیاز و کاربرد های متنوع و با هدف بهبود ابزار های کاربردی می باشد.""",
                img = R.drawable.img_u2,
                uri = "https://drive.usercontent.google.com/download?id=1Wl5nmwZ2jbK9kBUXTbOun4kJZrz86F_4&export=download&authuser=0&confirm=t&uuid=9602cfe0-77f9-4fea-9282-c4ba18c421d7&at=APZUnTXP6kytYOXYxbsmOJk7RhmU:1723875869647",
                seen = false
            ),
            DaoVideoModel(
                title = "3. آموزش کار با نقشه گوگل و آیکن ها در المنتور",
                description = """لورم ایسپوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است چابگرها و متون بلکه روزنامه و محله در ستون و سطرآنچنان که لازم است و برای شرایط فعلی تکنولوژی مورد نیاز و کاربرد های متنوع و با هدف بهبود ابزار های کاربردی می باشد.""",
                img = R.drawable.img_u2,
                uri = "https://drive.usercontent.google.com/download?id=1GuN8hg99GMAETZVA30PXcC6HtZmahNXz&export=download&authuser=0&confirm=t&uuid=fa464b19-5e44-4375-86f4-e733261f84a4&at=APZUnTWSr49v9oq4ISzqt5eQMZBC:1723875910375",
                seen = false
            ),
            DaoVideoModel(
                title = "4. برگزاری آزمون جهت سنجش عملکرد کاربران",
                description = """لورم ایسپوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است چابگرها و متون بلکه روزنامه و محله در ستون و سطرآنچنان که لازم است و برای شرایط فعلی تکنولوژی مورد نیاز و کاربرد های متنوع و با هدف بهبود ابزار های کاربردی می باشد.""",
                img = R.drawable.img_u2,
                uri = "https://drive.usercontent.google.com/download?id=1zU3sbuEHG4VR9NYFW7wKRyvjoLBSttmi&export=download&authuser=0&confirm=t&uuid=07d9159f-141b-475b-aae7-fd77e7799607&at=APZUnTW8p4r9CNnt20BbYciIWp8h:1723875975303",
                seen = false
            ),
        )

    fun onDestroy() {
        db.close()
    }

}