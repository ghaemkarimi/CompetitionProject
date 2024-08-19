package com.ghaemkarimi.daneshjooyar.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ghaemkarimi.daneshjooyar.customView.Item
import com.ghaemkarimi.daneshjooyar.mvp.model.fragment.DocumentFragmentModel
import com.ghaemkarimi.daneshjooyar.mvp.presenter.fragment.DocumentFragmentPresenter
import com.ghaemkarimi.daneshjooyar.mvp.view.fragment.DocumentFragmentView

class DocumentFragment(private val item: Item) : Fragment() {

    private lateinit var documentView: DocumentFragmentView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        documentView = DocumentFragmentView(inflater.context, item)
        return documentView.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val presenter = DocumentFragmentPresenter(
            documentView,
            DocumentFragmentModel(view.context)
        )
        presenter.onCreate()
    }

}