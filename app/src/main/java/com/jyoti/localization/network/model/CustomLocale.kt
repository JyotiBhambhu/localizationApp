package com.jyoti.localization.network.model

enum class CustomLocale(val locale: String) {
    ENGLISH("en"),
    HINDI("hi"),
    CHINESE("zh");

}

fun getSupportedLocaleList(): List<String> {
    return CustomLocale.values().map { it.locale }.toList()
}