package com.ghaemkarimi.daneshjooyar.mvp.view

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ghaemkarimi.daneshjooyar.R
import com.ghaemkarimi.daneshjooyar.customView.CustomNav
import com.ghaemkarimi.daneshjooyar.customView.Item
import com.ghaemkarimi.daneshjooyar.customView.Type
import com.ghaemkarimi.daneshjooyar.databinding.ActivityMainBinding
import com.ghaemkarimi.daneshjooyar.ui.fragment.AboutUsFragment
import com.ghaemkarimi.daneshjooyar.ui.fragment.DocumentFragment
import com.ghaemkarimi.daneshjooyar.ui.fragment.HomeFragment

class MainActivityView(private val activity: AppCompatActivity) {

    val binding = ActivityMainBinding.inflate(LayoutInflater.from(activity))

    fun fragmentManager() {

        setFragment(HomeFragment())

        binding.customNav.selectItem(object : Item {

            override fun setFragment(type: Type) {

                val fragment = when(type) {
                    Type.HOME -> HomeFragment()
                    Type.DOCUMENT -> DocumentFragment()
                    Type.ABOUT_US -> AboutUsFragment()
                }

                setFragment(fragment)

            }

        })

    }

    private fun setFragment(fragment: Fragment) {

        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment, fragment)
            .commit()

    }

}