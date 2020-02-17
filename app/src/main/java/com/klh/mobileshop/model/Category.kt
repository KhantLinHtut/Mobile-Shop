package com.klh.mobileshop.model

data class Category(
    val brand: Brand,
    val id: Int,
    val name: String,
    val type: Type
)