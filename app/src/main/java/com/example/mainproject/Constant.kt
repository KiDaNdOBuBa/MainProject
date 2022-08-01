package com.example.mainproject

import android.content.Context
import android.content.SharedPreferences

class Constant {

    companion object {
        private const val APP_SETTINGS = "SETTINGS"
        const val SETTING_IS_ENABLE = "SETTING_IS_ENABLE"
        const val BOOL_LIST_KEY = "BOOL_LIST_KEY"

        fun getSharedForSettings(context: Context): SharedPreferences =
            context.getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE)
    }

}