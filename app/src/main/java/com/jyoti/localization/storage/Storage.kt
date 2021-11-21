package com.jyoti.localization.storage

import android.content.SharedPreferences
import com.jyoti.localization.network.model.CustomLocale
import javax.inject.Inject

class Storage @Inject constructor(private val preferences: SharedPreferences) {

    fun getPreferredLocale(): String {
        return preferences.getString("preferred_locale", CustomLocale.ENGLISH.locale) ?: CustomLocale.ENGLISH.locale
    }

    fun setPreferredLocale(localeCode: String) {
        preferences.edit().putString("preferred_locale", localeCode).apply()
    }
}