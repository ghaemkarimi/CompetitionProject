package com.ghaemkarimi.daneshjooyar.mvp.view

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Handler
import android.provider.Settings
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
import com.ghaemkarimi.daneshjooyar.databinding.ActivityFirstBinding
import com.ghaemkarimi.daneshjooyar.databinding.DialogInternetCheckBinding
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnFinish
import com.ghaemkarimi.daneshjooyar.ui.LoginActivity
import com.ghaemkarimi.daneshjooyar.ui.MainActivity

class FirstActivityView(private val context: Context, private val onFinish: OnFinish) {

    val binding = ActivityFirstBinding.inflate(LayoutInflater.from(context))

    fun checkingLogin(stateLogin: Boolean) {

        when {

            !checkingInternet() -> dialog()

            stateLogin && checkingInternet() -> startAct(MainActivity())

            else -> startAct(LoginActivity())

        }

    }

    private fun startAct(activity: Context) {

        Handler(context.mainLooper).postDelayed(
            {
                context.startActivity(Intent(context, activity::class.java))
                onFinish.finished()
            },
            1200
        )

    }

    private fun checkingInternet(): Boolean {

        val result: Boolean

        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // چون این اپلیکیشن فقط برای اندروید بالای 6 هست
        // نیازی به کد های چک کردن اینترنت در اندروید پایین تر نیست
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

        result = when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }

        return result

    }

    private fun dialog() {

        val view = DialogInternetCheckBinding.inflate(LayoutInflater.from(context))

        val dialog = Dialog(context)
        dialog.setContentView(view.root)

        val params = WindowManager.LayoutParams()
        params.gravity = Gravity.CENTER
        params.width = WindowManager.LayoutParams.MATCH_PARENT
        params.height = WindowManager.LayoutParams.MATCH_PARENT

        params.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND

        params.dimAmount = 0.6f // میزان تاریک شدن پس‌زمینه

        dialog.window?.attributes = params

        dialog.setCancelable(false)
        dialog.show()

        view.wifiInternet.setOnClickListener {
            val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
            context.startActivity(intent)
            dialog.dismiss()
        }

        view.mobileInternet.setOnClickListener {
            val intent = Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS)
            context.startActivity(intent)
            dialog.dismiss()
        }

    }

}