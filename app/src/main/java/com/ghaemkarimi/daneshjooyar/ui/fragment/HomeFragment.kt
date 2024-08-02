package com.ghaemkarimi.daneshjooyar.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ghaemkarimi.daneshjooyar.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val binding = FragmentHomeBinding.inflate(LayoutInflater.from(context))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}