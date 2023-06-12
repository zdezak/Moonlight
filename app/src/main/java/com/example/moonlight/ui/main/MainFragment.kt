package com.example.moonlight.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moonlight.databinding.FragmentMainBinding
import com.example.moonlight.ui.UiState
import com.example.moonlight.ui.adapter.CategoriesDelegateAdopter
import com.example.moonlight.ui.adapter.CompositeDelegateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding: FragmentMainBinding = FragmentMainBinding.inflate(layoutInflater)
        val viewModel: MainViewModel by viewModels()
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.uiState.collect { value ->
                    when (value) {
                        is UiState.Loading -> binding.name.text = "Loading"
                        is UiState.Success -> {
                            val adapter = CompositeDelegateAdapter(
                                CategoriesDelegateAdopter(View.OnClickListener { })
                            )
                            adapter.swapData(value.Categories)
                            binding.recyclerView.layoutManager =
                                LinearLayoutManager(binding.root.context)
                            binding.recyclerView.adapter = adapter
                        }

                        is UiState.Error -> binding.name.text = "Error"

                    }
                }
            }
        }



        return binding.root
    }
}