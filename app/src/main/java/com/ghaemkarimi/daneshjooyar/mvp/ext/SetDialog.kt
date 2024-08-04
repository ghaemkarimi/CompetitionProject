package com.ghaemkarimi.daneshjooyar.mvp.ext

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import com.ghaemkarimi.daneshjooyar.databinding.DialogSupportBinding
import com.ghaemkarimi.daneshjooyar.remote.RetrofitService
import com.ghaemkarimi.daneshjooyar.remote.ext.ErrorUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SetDialog(private val context: Context) {

    fun setDialogSupport() {

        val view = DialogSupportBinding.inflate(LayoutInflater.from(context))

        val dialog = Dialog(context)
        dialog.setContentView(view.root)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        dialog.show()

        view.cancel.setOnClickListener { dialog.dismiss() }

        view.btnSend.setOnClickListener {

            val title = view.edtTitle.text.toString().trim()
            val message = view.edtMessage.text.toString().trim()

            if (title.isNotEmpty() && message.isNotEmpty()) {

                val text = "عنوان: $title\n\nمتن پیام: َ$message"

                sendMessageToSupport(text)

                dialog.dismiss()

            } else Toast.makeText(
                context,
                "عنوان و متن را پر کنید.",
                Toast.LENGTH_SHORT
            ).show()


        }

    }

    private fun sendMessageToSupport(message: String) {

        val service = RetrofitService.SendMessage

        CoroutineScope(Dispatchers.IO).launch {

            try {

                val response = service.sendMassageToSupport(
                    "IcWyottmislOA92wujR5oD3DqyWxHziSAJKEgVhn",
                    message
                )

                if (response.isSuccessful) {
                    launch(Dispatchers.Main) {
                        Toast.makeText(
                            context,
                            "پیام به پشتیبانی ارسال شد",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    launch(Dispatchers.Main) {
                        Toast.makeText(
                            context,
                            ErrorUtils.getError(response),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            } catch (e: Exception) {
                Log.e("SEND_MESSAGE_TO_SUPPORT", e.message.toString())
            }

        }

    }

}