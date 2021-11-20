package com.jyoti.localization.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BaseUsers(
    @SerializedName("userList")
    @Expose
    var userlist: MutableList<User>? = null
)
