package com.example.catmeymey.model

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes

data class Cat(
    @DrawableRes val imageResourceId: Int,
    val name: String,
    @RawRes val soundResourceId: Int,
    @DrawableRes val drawableResourceId: Int
)