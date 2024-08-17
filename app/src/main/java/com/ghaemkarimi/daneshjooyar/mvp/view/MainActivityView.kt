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
    context: Context,
    private val setFragment: SetFragment
): Item {

    val binding = ActivityMainBinding.inflate(LayoutInflater.from(context))
    private val setDialog = SetDialog(context)
    private val document = DocumentFragment(this)
    private val aboutUs = AboutUsFragment()
    private val home = HomeFragment()

    fun setData() {

        binding.support.setOnClickListener { setDialog.setDialogSupport() }

    }

    fun fragmentManager() {

        setFragment.fragment(HomeFragment())

        binding.customNav.selectItem(object : Item {

            override fun setFragment(type: Type) {

                val fragment = when (type) {

                    Type.DOCUMENT -> document
                    Type.ABOUT -> aboutUs
                    Type.HOME -> home

                }

                setFragment.fragment(fragment)

            }

        })

    }

    override fun setFragment(type: Type) {
        setFragment.fragment(home)
        binding.customNav.home()
    }

}