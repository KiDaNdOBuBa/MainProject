package com.example.mainproject.model

import androidx.annotation.DrawableRes

data class SettingModel(
    @DrawableRes
    var image: Int,
    var settingName: String,
    var switch: Boolean
)
