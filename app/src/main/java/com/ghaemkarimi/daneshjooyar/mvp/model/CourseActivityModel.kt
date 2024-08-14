package com.ghaemkarimi.daneshjooyar.mvp.model

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.ghaemkarimi.daneshjooyar.R
import com.ghaemkarimi.daneshjooyar.adapter.model.AboutModel
import com.ghaemkarimi.daneshjooyar.db.DBHelper
import com.ghaemkarimi.daneshjooyar.db.model.DaoVideosModel
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

                videos.collect{
                    onBindData.getVideos(it)
                }

            }

        }

    }

    fun saveVideo() {

        val stateSave = pref.getBoolean("save", false)

        if (stateSave) {

            dataRecyclerVideos().forEach { db.videos().saveVideo(it) }

            val editor = pref.edit()
            editor.putBoolean("save", true)
            editor.apply()

        }

    }

    private fun dataRecyclerVideos() =
        arrayListOf(
            DaoVideosModel(
                title = "برسی حالت ثابت و مطلق در تنظیمات پیشرفته ویجت ها",
                description = """لورم ایسپوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است چابگرها و متون بلکه روزنامه و محله در ستون و سطرآنچنان که لازم است و برای شرایط فعلی تکنولوژی مورد نیاز و کاربرد های متنوع و با هدف بهبود ابزار های کاربردی می باشد.""",
                img = R.drawable.img_u2,
                uri = "https://dl.daneshjooyar.com/mvie/Ahmadi-Alireza/Business/S05-Elementor-free-and-pro/S05-Part14-static-and-dinamic.mp4",
                seen = false,
                amountSeen = arrayListOf()
            ),
            DaoVideosModel(
                title = "",
                description = "",
                img = R.drawable.img_u2,
                uri = "",
                seen = false,
                amountSeen = arrayListOf()
            ),
            DaoVideosModel(
                title = "",
                description = "",
                img = R.drawable.img_u2,
                uri = "",
                seen = false,
                amountSeen = arrayListOf()
            ),
            DaoVideosModel(
                title = "",
                description = "",
                img = R.drawable.img_u2,
                uri = "",
                seen = false,
                amountSeen = arrayListOf()
            ),
        )

    fun onDestroy() { db.close() }

}