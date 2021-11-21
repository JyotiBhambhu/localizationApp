package com.jyoti.localization.di.modules

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Inject


@Module
class StorageModule @Inject constructor(var context: Context) {

    @Provides
    fun context(): Context {
        return context
    }

    @Provides
    fun providePreferences(): SharedPreferences {
        return context.getSharedPreferences("sp", Context.MODE_PRIVATE)
    }

}