package com.jyoti.localization.network

import android.util.Log
import androidx.annotation.RawRes
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jyoti.localization.MyApplication
import com.jyoti.localization.storage.StorageUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class ConfigProvider(@RawRes val localSource: Int,
                     val remoteSource: String) {

    suspend inline fun <reified T> fetch(isLocal: Boolean = false): T = withContext<T>(Dispatchers.IO) {
        val configData: String = try {
            if (!isLocal && remoteSource.isNotEmpty()) {
                OkHttpUtils.get(remoteSource)
            } else {
                StorageUtil.getRawData(MyApplication.context, localSource)
            }
        } catch (exception: Exception) {
            Log.e("Config Provider", exception.localizedMessage ?: "")
            StorageUtil.getRawData(MyApplication.context, localSource)
        }
        Gson().fromJson(configData, object : TypeToken<T>() {}.type)
    }
}
