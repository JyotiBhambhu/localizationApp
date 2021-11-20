package com.jyoti.localization.storage

import android.content.Context
import android.content.SharedPreferences
import com.jyoti.localization.utils.LocaleUtil

class Storage constructor(private val context: Context) {
    private var preferences: SharedPreferences = context.getSharedPreferences("sp", Context.MODE_PRIVATE)

    fun getPreferredLocale(): String {
        return preferences.getString("preferred_locale", LocaleUtil.OPTION_PHONE_LANGUAGE)!!
    }

    fun setPreferredLocale(localeCode: String) {
        preferences.edit().putString("preferred_locale", localeCode).apply()
    }
}