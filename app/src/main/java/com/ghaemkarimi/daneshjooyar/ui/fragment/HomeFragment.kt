package com.ghaemkarimi.daneshjooyar.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ghaemkarimi.daneshjooyar.mvp.model.fragment.HomeFragmentModel
import com.ghaemkarimi.daneshjooyar.mvp.presenter.fragment.HomeFragmentPresenter
import com.ghaemkarimi.daneshjooyar.mvp.view.fragment.HomeFragmentView

class HomeFragment : Fragment() {

    private lateinit var homeView: HomeFragmentView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeView = HomeFragmentView(inflater.context)
        return homeView.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val presenter = HomeFragmentPresenter(homeView, HomeFragmentModel())
        presenter.onCreate()
    }

}