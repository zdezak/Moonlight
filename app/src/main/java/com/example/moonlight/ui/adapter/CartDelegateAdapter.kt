package com.example.moonlight.ui.adapter

import com.bumptech.glide.Glide
import com.example.moonlight.R
import com.example.moonlight.data.model.DishLocal
import com.example.moonlight.databinding.ItemCartBinding

class CartDelegateAdapter(
    private val minusClickListener: (id:String) -> Unit,
    private val plusClickListener: (id:String) -> Unit,
) :
    ViewBindingDelegateAdapter<DishLocal, ItemCartBinding>(ItemCartBinding::inflate) {
    override fun ItemCartBinding.onBind(item: DishLocal) {
        minus.setOnClickListener { minusClickListener(item.id) }
        plus.setOnClickListener { plusClickListener(item.id) }
        count.text = item.count.toString()
        nameDish.text = item.name
        weightDish.text = item.weight
        price.text = item.price
        Glide
            .with(imageDish)
            .load(item.image_url)
            .centerCrop()
            .placeholder(R.drawable.loading_spinner)
            .into(imageDish)
    }

    override fun isForViewType(item: Any): Boolean = item is DishLocal
    override fun DishLocal.getItemId(): Any = id


}