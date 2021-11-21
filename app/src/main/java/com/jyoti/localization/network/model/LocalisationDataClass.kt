package com.jyoti.localization.network.model

import com.google.gson.annotations.SerializedName

data class LocalisationDataClass(
    @SerializedName("hi")
    var hi: ArrayList<StringDataClass>,
    @SerializedName("zh")
    var zh: ArrayList<StringDataClass>,
){
    data class StringDataClass(
        @SerializedName("key")
        var key: String,
        @SerializedName("value")
        var value: String
    )
}
