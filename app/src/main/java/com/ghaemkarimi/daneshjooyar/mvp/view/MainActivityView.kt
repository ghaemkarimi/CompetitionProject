package com.ghaemkarimi.daneshjooyar.mvp.view

import android.content.Context
import android.view.LayoutInflater
import com.ghaemkarimi.daneshjooyar.customView.Item
import com.ghaemkarimi.daneshjooyar.customView.Type
import com.ghaemkarimi.daneshjooyar.databinding.ActivityMainBinding
import com.ghaemkarimi.daneshjooyar.mvp.ext.SetDialog
import com.ghaemkarimi.daneshjooyar.mvp.ext.SetFragment
import com.ghaemkarimi.daneshjooyar.ui.fragment.AboutUsFragment
import com.ghaemkarimi.daneshjooyar.ui.fragment.DocumentFragment
import com.ghaemkarimi.daneshjooyar.ui.fragment.HomeFragment

class MainActivityView(
    private val context: Context,
    private val setFragment: SetFragment
) {

    val binding = ActivityMainBinding.inflate(LayoutInflater.from(context))

    fun setData() {

        binding.support.setOnClickListener { SetDialog(context).setDialogSupport() }

    }

    fun fragmentManager() {

        setFragment.fragment(HomeFragment())

        binding.customNav.selectItem(object : Item {

            override fun setFragment(type: Type) {

                val fragment = when (type) {

                    Type.DOCUMENT -> DocumentFragment()
                    Type.ABOUT -> AboutUsFragment()
                    Type.HOME -> HomeFragment()

                }

                setFragment.fragment(fragment)

            }

        })

    }

}