package com.example.moonlight.ui.adapter

import android.view.View
import com.bumptech.glide.Glide
import com.example.moonlight.data.model.Dish
import com.example.moonlight.databinding.ItemDishBinding

class DishesDelegateAdapter(private val clickListener: (View) -> Unit) :
    ViewBindingDelegateAdapter<Dish, ItemDishBinding>(ItemDishBinding::inflate) {
    override fun ItemDishBinding.onBind(item: Dish) {
        container.setOnClickListener(clickListener)
        dishName.text = item.name
        Glide.with(container).load(item.image_url).into(dishImage)
    }

    override fun isForViewType(item: Any): Boolean = item is Dish

    override fun Dish.getItemId(): Any = id
}