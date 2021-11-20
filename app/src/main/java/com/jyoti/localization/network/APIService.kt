package com.jyoti.localization.network

import com.jyoti.localization.network.model.BaseUsers
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    /**
     * Get the list of the pots from the API
     */
//https://datanapps.com/DNARestAPIs/getUserLists
    @GET("DNARestAPIs/getUserLists")
    fun getNetworkDataList(): Call<BaseUsers>
}