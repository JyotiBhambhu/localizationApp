package com.jyoti.localization.utils

import android.content.Context
import android.os.Build

import android.os.LocaleList

import android.content.ContextWrapper
import android.content.res.Configuration
import android.content.res.Resources
import java.util.*

class ContextUtil(base: Context?) : ContextWrapper(base) {
    companion object {
        fun updateLocale(context: Context?, localeToSwitchTo: Locale): ContextWrapper {
            context?.let {
                var langContext: Context = it
                val resources: Resources = langContext.getResources()
                // TODO: ADD_TO_ARTICLE:Create a new configuration object using resource configuration on the give context
                //TODO: src : https://stackoverflow.com/questions/39705739/android-n-change-language-programmatically
                val configuration: Configuration = resources.getConfiguration()

                //TODO: look at deprecations section on Current for reasoning
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    //TODO: ADD_TO_ARTICLE: *mention usage of localeList in place of configuration.setLocale(localeToSwitchTo);*

                    //TODO: ADD_TO_ARTICLE:Set a locale list containing the locale we plan to switch to
                    val localeList = LocaleList(localeToSwitchTo)
                    //TODO: ADD_TO_ARTICLE: Sets the default locale for this instance of the JVM to the locale at the first index
                    // on this list. Since there's only one locale present on our example, this will inadvertently set the locale
                    // on localeToSwitchTo variable as the default locale.
                    LocaleList.setDefault(localeList)
                    configuration.setLocales(localeList)
                } else {
                    configuration.locale = localeToSwitchTo
                }

                //TODO: look at deprecations section on Current for reasoning
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                    //TODO: ADD_TO_ARTICLE: Set the current context variable to a new Context object whose
                    // resources are adjusted to match the given Configuration.
                    langContext = langContext.createConfigurationContext(configuration)
                } else {
                    resources.updateConfiguration(configuration, resources.getDisplayMetrics())
                }
                return ContextUtil(langContext)
            } ?: kotlin.run {
                return ContextUtil(context)
            }

        }
    }
}