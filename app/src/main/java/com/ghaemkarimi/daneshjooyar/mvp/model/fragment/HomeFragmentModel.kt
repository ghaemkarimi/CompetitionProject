package com.ghaemkarimi.daneshjooyar.mvp.model.fragment

import com.ghaemkarimi.daneshjooyar.R
import com.ghaemkarimi.daneshjooyar.adapter.model.HomeModelHorizontal
import com.ghaemkarimi.daneshjooyar.adapter.model.HomeModelVertical

class HomeFragmentModel {

    fun dataRecyclerHorizontal() =
        arrayListOf(
            HomeModelHorizontal(1, "طراحی سایت", R.drawable.ic_item_1),
            HomeModelHorizontal(2, "برنامه نویسی موبایل", R.drawable.ic_item_2),
            HomeModelHorizontal(3, "هوش مصنوعی", R.drawable.ic_item_3),
            HomeModelHorizontal(4, "بازی سازی", R.drawable.ic_item_4),
            HomeModelHorizontal(5, "برنامه نویسی ویندوز", R.drawable.ic_item_5)
        )

    fun dataRecyclerVertical() =
        arrayListOf(
            HomeModelVertical(1, 1,
                "دوره جامع آموزش Adobe Xd 2023 به صورت پروژه محور", R.drawable.img_u1),
            HomeModelVertical(2, 1,
                "دوره آموزش المنتور رایگان به همراه 2 پروژه عملی", R.drawable.img_u2),
            HomeModelVertical(3, 1,
                "جامع ترین دوره آموزش ui ux\uD83D\uDD25+ نکات کسب درآمد دلاری", R.drawable.img_u3),
            HomeModelVertical(4, 1,
                "دوره آموزش فیگما (جامع و کاربردی✅) بهمراه ۳ پروژه عملی", R.drawable.img_u4),
            HomeModelVertical(5, 2,
                "جامع ترین دوره آموزش برنامه نویسی اندروید (150 ساعت با پشتیبانی 24 ساعته)", R.drawable.img_m1),
            HomeModelVertical(6, 2,
                "کامل ترین آموزش جت پک کامپوز برای طراحی UI در اندروید", R.drawable.img_m2),
            HomeModelVertical(7, 2,
                "دوره آموزش فلاتر 2024✅+ 3 پروژه عملی ساخت اپلیکیشن جذاب", R.drawable.img_m3),
            HomeModelVertical(8, 2,
                "آموزش swift برای IOS (بهمراه 6 پروژه عملی)", R.drawable.img_m4),
            HomeModelVertical(9, 2,
                "دوره آموزش react native جامع و کاربردی", R.drawable.img_m5),
            HomeModelVertical(10, 3,
                "دوره آموزش چت GPT ویژه برنامه نویسان هوش مصنوعی و پایتون", R.drawable.img_p1),
            HomeModelVertical(11, 3,
                "آموزش هوش مصنوعی [مفاهیم مناسب برای شروع Ai✅]", R.drawable.img_p2),
            HomeModelVertical(12, 3,
                "آموزش جامع پایتون (python) با تکیه بر هوش مصنوعی", R.drawable.img_p3),
            HomeModelVertical(13, 4,
                "آموزش ساخت بازی Angry Birds در یونیتی", R.drawable.img_g1),
            HomeModelVertical(14, 4,
                "آموزش ساخت رابط کاربری کرآی انجین (آموزش CryEngine)", R.drawable.img_g2),
            HomeModelVertical(15, 4,
                "یادگیری موتوربازی سازی یونیتی از صفر تا پیشرفته", R.drawable.img_g3),
            HomeModelVertical(16, 4,
                "دوره طلایی آموزش بازی \u200Cسازی با یونیتی ⚡\uFE0Fعملی و پروژه محور✅", R.drawable.img_g4),
            HomeModelVertical(17, 4,
                "آموزش ساخت بازی با موتور بازی سازی کرآی انجین ( آموزش CryEngine )", R.drawable.img_g5),
            HomeModelVertical(18, 5,
                "دوره جامع آموزش سی شارپ (C#) از مقدماتی تا پیشرفته", R.drawable.img_w1),
            HomeModelVertical(19, 5,
                "دوره مسترکدر پایتون\uD83E\uDDD1\u200D\uD83D\uDCBB ۴۵ ساعت آموزش پایتون جامع در کاربردی ترین دوره ی فارسی", R.drawable.img_w2),
            HomeModelVertical(20, 5,
                "آموزش پایتون رایگان (2024) یادگیری آسان مقدمات python", R.drawable.img_w3),
            HomeModelVertical(21, 5,
                "دوره آموزش جاوا بهمراه ۲۰ تمرین واقعی", R.drawable.img_w4),
            HomeModelVertical(22, 5,
                "آموزش برنامه نویسی جاوا – از مقدماتی تا پیشرفته", R.drawable.img_w5),
        )

}