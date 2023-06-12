package com.example.moonlight.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moonlight.R
import com.example.moonlight.databinding.FragmentCategoryBinding
import com.example.moonlight.ui.adapter.CompositeDelegateAdapter
import com.example.moonlight.ui.adapter.DishesDelegateAdapter
import com.example.moonlight.ui.dish.DishFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentCategoryBinding.inflate(layoutInflater)
        val viewModel: CategoryViewModel by viewModels()
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.categoryUiState.collect { value ->
                    when (value) {
                        is CategoryUiState.Loading -> {
                            binding.loadingStatus.visibility = View.VISIBLE
                            binding.loadingStatus.text = getString(R.string.status_loading)
                        }

                        is CategoryUiState.Success -> {
                            binding.loadingStatus.visibility = View.INVISIBLE
                            val adapter = CompositeDelegateAdapter(
                                DishesDelegateAdapter {
                                    DishFragment().show(
                                        childFragmentManager, DishFragment.TAG
                                    )
                                }
                            )
                            adapter.swapData(value.dishes)
                            binding.recyclerView.layoutManager =
                                GridLayoutManager(binding.root.context, 3)
                            binding.recyclerView.adapter = adapter
                        }

                        is CategoryUiState.Error -> {
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