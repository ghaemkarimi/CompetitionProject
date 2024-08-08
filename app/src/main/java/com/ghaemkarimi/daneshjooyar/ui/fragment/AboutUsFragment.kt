package com.ghaemkarimi.daneshjooyar.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ghaemkarimi.daneshjooyar.mvp.model.fragment.AboutUsFragmentModel
import com.ghaemkarimi.daneshjooyar.mvp.presenter.fragment.AboutUsFragmentPresenter
import com.ghaemkarimi.daneshjooyar.mvp.view.fragment.AboutUsFragmentView

class AboutUsFragment : Fragment() {

    private lateinit var aboutUsView: AboutUsFragmentView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        aboutUsView = AboutUsFragmentView(inflater.context)
        return aboutUsView.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val presenter = AboutUsFragmentPresenter(aboutUsView, AboutUsFragmentModel())
        presenter.onCreate()
    }

}