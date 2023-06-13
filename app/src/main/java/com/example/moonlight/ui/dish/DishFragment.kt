package com.example.moonlight.ui.dish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.example.moonlight.R
import com.example.moonlight.databinding.FragmentDishBinding
import com.example.moonlight.ui.category.CategoryUiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DishFragment : DialogFragment() {
    private val viewModel: DishViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        viewModel.setDishIndex((requireArguments().getString("id", "1")))

        val binding = FragmentDishBinding.inflate(layoutInflater)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.categoryUiState.collect { value ->
                    val dishIndex = viewModel.getDishIndex()
                    when (value) {
                        is CategoryUiState.Loading -> {
                            binding.addToCart.isClickable = false
                            binding.name.text = getString(R.string.status_loading)
                        }

                        is CategoryUiState.Success -> {
                            binding.addToCart.isClickable = true
                            binding.name.text = value.dishes[dishIndex].name
                            binding.description.text = value.dishes[dishIndex].description
                            binding.cost.text = value.dishes[dishIndex].price
                            binding.weight.text = value.dishes[dishIndex].weight
                            Glide.with(binding.image)
                                .load(value.dishes[dishIndex].image_url)
                                .into(binding.image)
                            binding.close.setOnClickListener { dismiss() }
                            binding.addToCart.setOnClickListener {
                                viewModel.setInCart(value.dishes[dishIndex])
                                Toast.makeText(context, getString(R.string.add_to_cart_done), Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }

                        is CategoryUiState.Error -> {
                            binding.addToCart.isClickable = false
                            binding.name.text = getString(R.string.status_error)
                        }

                    }
                }
            }
        }
        return binding.root
    }


    companion object {
        const val TAG = "PurchaseConfirmationDialog"
    }

}