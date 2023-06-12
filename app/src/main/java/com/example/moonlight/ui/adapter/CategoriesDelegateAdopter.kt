package com.example.moonlight.ui.adapter

import android.graphics.drawable.Drawable
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.moonlight.R
import com.example.moonlight.data.model.Category
import com.example.moonlight.databinding.ItemCategoryBinding

class CategoriesDelegateAdopter(private val clickListener: (View) -> Unit) :
    ViewBindingDelegateAdapter<Category, ItemCategoryBinding>(ItemCategoryBinding::inflate) {
    override fun ItemCategoryBinding.onBind(item: Category) {
        nameCategory.text = item.name
        container.setOnClickListener(clickListener)
        Glide
            .with(container)
            .load(item.imageUrl)
            .centerCrop()
            .placeholder(R.drawable.loading_spinner)
            .into(
                object : CustomTarget<Drawable>() {
                    override fun onLoadCleared(placeholder: Drawable?) {
                        container.background = placeholder
                    }

                    override fun onResourceReady(
                        resource: Drawable,
                        transition: Transition<in Drawable>?,
                    ) {
                        container.background = resource
                    }
                }
            )
    }

    override fun isForViewType(item: Any): Boolean = item is Category

    override fun Category.getItemId(): Any = id

}