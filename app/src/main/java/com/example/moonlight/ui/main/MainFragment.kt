package com.example.moonlight.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moonlight.databinding.FragmentMainBinding

class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding: FragmentMainBinding = FragmentMainBinding.inflate(layoutInflater)

        val mainViewModel = MainViewModel()

        val adapter = null
        return binding.root
    }
}