package com.example.moonlight.ui.adapter

import android.view.View
import com.example.moonlight.data.model.Category
import com.example.moonlight.databinding.ItemCategoryBinding

class CategoriesDelegateAdopter(private val clickListener: (View) -> Unit) :
    ViewBindingDelegateAdapter<Category, ItemCategoryBinding>(ItemCategoryBinding::inflate) {
    override fun ItemCategoryBinding.onBind(item: Category) {
        nameCategory.text = item.name
        nameCategory.setOnClickListener(clickListener)
//        tvTitle.text = item.title
//        imgBg.setOnClickListener(clickListener)
//        imgBg.setImageResource(item.imageRes)
    }

    override fun isForViewType(item: Any): Boolean = item is Category

    override fun Category.getItemId(): Any = id

}