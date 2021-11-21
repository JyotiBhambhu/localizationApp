package com.jyoti.localization.network.model

import com.google.gson.annotations.SerializedName

data class LocalisationDataClass(
    @SerializedName("hi")
    val hi: ArrayList<StringDataClass>,
    @SerializedName("zh")
    val zh: ArrayList<StringDataClass>,
){
    data class StringDataClass(
        @SerializedName("key")
        val key: String,
        @SerializedName("value")
        val value: String
    )
}
