package com.example.afinal.data.data_classes

import androidx.annotation.DrawableRes
import com.example.afinal.R
import com.example.afinal.data.util.Constants

data class Page(
    val text : String,
    @DrawableRes val image : Int
)

val pages = listOf(
    Page(
        Constants.PAGER_FIRST_TEXT,
        R.drawable.ic_pager_first
    ),
    Page(
        Constants.PAGER_SECOND_TEXT,
        R.drawable.ic_pager_second
    ),
    Page(
        Constants.PAGER_THIRD_TEXT,
        R.drawable.ic_pager_third
    )
)