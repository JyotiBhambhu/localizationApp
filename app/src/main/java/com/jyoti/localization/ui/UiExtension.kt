package com.jyoti.localization.ui

import android.content.Context
import android.widget.TextView
import com.jyoti.localization.network.model.CustomLocale
import com.jyoti.localization.network.model.LocalisationDataClass

fun Context.getString(
    localisationDataClass: LocalisationDataClass?,
    selLocale: String?,
    resId: Int
): String{

    val resourceName = resources.getResourceEntryName(resId)
    val defaultString = resources.getString(resId)

    val localString: String = when(selLocale){
        CustomLocale.HINDI.locale -> localisationDataClass?.hi?.firstOrNull() { it.key == resourceName }?.value ?: defaultString
        CustomLocale.CHINESE.locale -> localisationDataClass?.zh?.firstOrNull() { it.key == resourceName }?.value ?: defaultString
        else -> defaultString
    }

    return localString
}

fun TextView.setLocaleText(
    context: Context,
    localisationDataClass: LocalisationDataClass?,
    selLocale: String?,
    resId: Int
){
    text = context.getString(localisationDataClass, selLocale, resId)
}