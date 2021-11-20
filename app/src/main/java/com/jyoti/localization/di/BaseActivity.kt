package com.jyoti.localization.di

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.jyoti.localization.network.model.CustomLocale
import com.jyoti.localization.storage.Storage
import com.jyoti.localization.utils.LocaleUtil

open class BaseActivity : AppCompatActivity() {

    private lateinit var oldPrefLocaleCode: String

    fun setPreferredLocale(locale: CustomLocale){
        Storage(this).setPreferredLocale(locale.locale)
        recreate()
    }

    override fun attachBaseContext(newBase: Context) {
        oldPrefLocaleCode = Storage(newBase).getPreferredLocale()
        applyOverrideConfiguration(LocaleUtil.getLocalizedConfiguration(oldPrefLocaleCode))
        super.attachBaseContext(newBase)
    }

    override fun onResume() {
        val currentLocaleCode = Storage(this).getPreferredLocale()
        if (oldPrefLocaleCode != currentLocaleCode) {
            recreate() //locale is changed, restart the activty to update
            oldPrefLocaleCode = currentLocaleCode
        }
        super.onResume()
    }
}