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
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moonlight.R
import com.example.moonlight.databinding.FragmentMainBinding
import com.example.moonlight.ui.adapter.CategoriesDelegateAdapter
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
                viewModel.mainUiState.collect { value ->
                    when (value) {
                        is MainUiState.Loading -> {
                            binding.loadingStatus.visibility = View.VISIBLE
                            binding.loadingStatus.text = getString(R.string.status_loading)
                        }
                        is MainUiState.Success -> {
                            binding.loadingStatus.visibility = View.INVISIBLE
                            val adapter = CompositeDelegateAdapter(
                                CategoriesDelegateAdapter {
                                    it.findNavController().navigate(
                                        R.id.action_navigation_main_to_category_fragment
                                    )
                                }
                            )
                            adapter.swapData(value.Categories)
                            binding.recyclerView.layoutManager =
                                LinearLayoutManager(binding.root.context)
                            binding.recyclerView.adapter = adapter
                        }

                        is MainUiState.Error -> {
                            binding.loadingStatus.visibility = View.VISIBLE
                            binding.loadingStatus.text = getString(R.string.status_error)
                        }

                    }
                }
            }
        }
        return binding.root
    }
}