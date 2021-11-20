package com.jyoti.localization.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("FirstName")
    @Expose
    var firstName: String? = null,
    @SerializedName("LastName")
    @Expose
    var lastName: String? = null
)
