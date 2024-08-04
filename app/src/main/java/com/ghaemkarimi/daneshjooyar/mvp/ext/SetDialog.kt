package com.ghaemkarimi.daneshjooyar.mvp.ext

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.Toast
import com.ghaemkarimi.daneshjooyar.databinding.DialogSupportBinding

class SetDialog {

    fun setDialogSupport(context: Context) {

        val view = DialogSupportBinding.inflate(LayoutInflater.from(context))

        val dialog = Dialog(context)
        dialog.setContentView(view.root)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        dialog.show()

        view.cancel.setOnClickListener { dialog.dismiss() }

        view.btnSend.setOnClickListener {

            val title = view.edtTitle.text.toString()
            val message = view.edtMessage.text.toString()

            if (title.isNotEmpty() && message.isNotEmpty()) {

                val text = "عنوان: $title\n\nمتن پیام: َ$message"

                Toast.makeText(context, text, Toast.LENGTH_SHORT).show()

                //کارهای مربوط به ارسال پیام به تلگرام

                dialog.dismiss()

            } else Toast.makeText(
                context,
                "عنوان و متن را پر کنید.",
                Toast.LENGTH_SHORT
            ).show()


        }

    }

}