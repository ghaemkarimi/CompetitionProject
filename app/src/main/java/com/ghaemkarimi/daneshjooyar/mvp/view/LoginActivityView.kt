package com.ghaemkarimi.daneshjooyar.mvp.view

import android.content.Context
import android.content.Intent
import android.text.Editable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextWatcher
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.ghaemkarimi.daneshjooyar.R
import com.ghaemkarimi.daneshjooyar.databinding.ActivityLoginBinding
import com.ghaemkarimi.daneshjooyar.mvp.ext.OnFinish
import com.ghaemkarimi.daneshjooyar.mvp.ext.SetState
import com.ghaemkarimi.daneshjooyar.ui.FirstActivity
import com.ghaemkarimi.daneshjooyar.ui.GhavaninActivity

class LoginActivityView(private val context: Context, private val onFinish: OnFinish) {

    val binding = ActivityLoginBinding.inflate(LayoutInflater.from(context))

    val pinViews = arrayOf(
        binding.editTexts.code1,
        binding.editTexts.code2,
        binding.editTexts.code3,
        binding.editTexts.code4,
        binding.editTexts.code5,
    )

    fun setData() {

        binding.numberEdt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                binding.falseButton.visibility =
                    if (s.toString().length == 11)
                        View.INVISIBLE
                    else
                        View.VISIBLE
                binding.clearEdt.visibility =
                    if (s.toString().isNotEmpty())
                        View.VISIBLE
                    else
                        View.INVISIBLE
            }
        })

        binding.clearEdt.setOnClickListener {
            binding.numberEdt.text?.clear()
        }

        setListeners()

        binding.numberEdt.textDirection = View.TEXT_DIRECTION_RTL

    }

    fun setTexts(state: Boolean = false, number: String = "", pref: SetState) {

        if (state) setTextToEnterCode(number, pref)
        else setTextToEnterNumber(pref)

    }

    private fun setTextToEnterNumber(pref: SetState) {

        setText(
            "ثبت نام یا ورود",
            "لطفا شماره موبایل خود را وارد کنید",
            "تایید و ادامه",
            "شرایط و قوانین دانشجویار را مطالعه کردم و میپذیرم.",
            View.GONE
        )

        binding.button.setOnClickListener {
            if (binding.falseButton.visibility == View.INVISIBLE)

                if (Regex("^09\\d{9}$").matches(binding.numberEdt.text.toString())) {

                    setTexts(true, binding.numberEdt.text.toString(), pref)
                    binding.numberEdtLayout.isErrorEnabled = false
                    binding.numberEdtLayout.error = null
                    binding.clearEdt.visibility = View.GONE

                } else {

                    binding.numberEdtLayout.isErrorEnabled = true
                    binding.numberEdtLayout.error = "شماره موبایل نامعتبر است."

                }

            binding.falseButton.visibility = View.VISIBLE

        }

    }

    private fun setTextToEnterCode(number: String, pref: SetState) {

        setText(
            "کد تایید ۵ رقمی را وارد کنید.",
            "کد تایید برای شماره تلفن $number ارسال شد",
            "ورود",
            "ارسال مجدد",
            View.VISIBLE
        )

        binding.button.setOnClickListener {
            if (binding.falseButton.visibility == View.INVISIBLE) {

                var text = ""

                for (item in pinViews)
                    text += item.text.toString()

                if (text == "12345") {
                    pref.getState(true)
                    val intent = Intent(context, FirstActivity::class.java)
                    context.startActivity(intent)
                    onFinish.finished()
                } else {
                    binding.editTexts.layout.setBackgroundResource(R.drawable.back_edt_code_error)
                    binding.errorText.visibility = View.VISIBLE
                    binding.falseButton.visibility = View.VISIBLE
                }

            }
        }

        binding.txtEdit.setOnClickListener {
            setTexts(false, pref = pref)
            binding.clearEdt.visibility = View.VISIBLE
            binding.falseButton.visibility = View.INVISIBLE
            binding.errorText.visibility = View.INVISIBLE
            binding.editTexts.layout.setBackgroundResource(R.drawable.back_edt_code)
        }

    }

    private fun setListeners() {

        for (item in pinViews.indices) {
            val pinView = pinViews[item]
            pinView.addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (s?.length == 1) {
                        val nextPinView = if (item < pinViews.size - 1) pinViews[item + 1] else null
                        nextPinView?.requestFocus()
                    }
                    if (s?.length == 0 && item > 0) {
                        val previousPinView =
                            if (item < pinViews.size + 1) pinViews[item - 1] else null
                        previousPinView?.requestFocus()
                    }

                }

                override fun afterTextChanged(s: Editable?) {
                    if (
                        binding.editTexts.code1.text?.length == 1 &&
                        binding.editTexts.code2.text?.length == 1 &&
                        binding.editTexts.code3.text?.length == 1 &&
                        binding.editTexts.code4.text?.length == 1 &&
                        binding.editTexts.code5.text?.length == 1
                    )
                        binding.falseButton.visibility = View.INVISIBLE
                    else
                        binding.falseButton.visibility = View.VISIBLE
                }

            })
        }
    }

    private fun setText(
        title: String,
        request: String,
        buttonText: String,
        bottomText: String,
        visibilityEdit: Int
    ) {

        binding.txtTitle.text = title
        binding.txtRequest.text = request
        binding.button.text = buttonText
        binding.edit.visibility = visibilityEdit

        if (visibilityEdit == View.VISIBLE) {

            binding.numberEdtLayout.visibility = View.GONE
            binding.editTexts.layout.visibility = View.VISIBLE

        } else {

            binding.numberEdtLayout.visibility = View.VISIBLE
            binding.editTexts.layout.visibility = View.GONE

        }

        binding.txtBottom.text = spannable(bottomText, visibilityEdit != View.VISIBLE)
        binding.txtBottom.movementMethod = LinkMovementMethod.getInstance()

    }

    private fun spannable(text: String, state: Boolean): SpannableString {

        val spannableString = SpannableString(text)
        val end = if (state) 14 else text.length
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                if (state) {
                    val intent = Intent(context, GhavaninActivity::class.java)
                    context.startActivity(intent)
                } else
                    Toast.makeText(context, "کد مجددا ارسال شد", Toast.LENGTH_SHORT).show()
            }
        }

        spannableString.setSpan(clickableSpan, 0, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        return spannableString

    }

}