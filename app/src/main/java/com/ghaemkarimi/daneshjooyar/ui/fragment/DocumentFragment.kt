package com.ghaemkarimi.daneshjooyar.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ghaemkarimi.daneshjooyar.databinding.FragmentDocumentBinding

class DocumentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDocumentBinding.inflate(LayoutInflater.from(context))
        return binding.root
    }

}