package com.example.clickbait.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Ad(
    @DrawableRes val imageResourceId: Int,
    @StringRes val creator: Int,
    @StringRes val title: Int,
    @StringRes val time: Int
)