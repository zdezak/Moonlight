package com.example.moonlight.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moonlight.R
import com.example.moonlight.databinding.FragmentCartBinding
import com.example.moonlight.ui.adapter.CartDelegateAdapter
import com.example.moonlight.ui.adapter.CompositeDelegateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentCartBinding.inflate(layoutInflater)
        val viewModel: CartViewModel by viewModels()

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.cartUiState.collect { value ->
                    when (value) {
                        is CartUiState.Loading -> {

                        }

                        is CartUiState.Success -> {
                            val adapter = CompositeDelegateAdapter(
                                CartDelegateAdapter(
                                    { id -> viewModel.minusDishes(id) },
                                    { id -> viewModel.plusDishes(id) }
                                )
                            )
                            adapter.swapData(value.dishes)
                            binding.recyclerView.layoutManager =
                                LinearLayoutManager(binding.root.context)
                            binding.recyclerView.adapter = adapter

                            binding.buttonBuy.setOnClickListener {
                                if (viewModel.sum != 0) {
                                    Toast.makeText(
                                        context,
                                        getString(R.string.buy_is_done),
                                        Toast.LENGTH_SHORT
                                    )
                                        .show()
                                    viewModel.sum = 0
                                } else {
                                    Toast.makeText(
                                        context,
                                        getString(R.string.add_in_cart_new_dash),
                                        Toast.LENGTH_SHORT
                                    )
                                        .show()
                                }
                            }
                        }

                        is CartUiState.Error -> {

                        }
                    }

                }


            }
        }
        return binding.root
    }
}
