package com.jyoti.localization.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import android.preference.PreferenceManager
import com.jyoti.localization.utils.LocaleUtil
import dagger.Module
import dagger.Provides

import javax.inject.Singleton



//@Module
//class StorageModule @Inject constructor(var context: Context) {
//
//    @Provides
//    fun context(): Context {
//        return context
//    }
//
//    @Provides
//    fun providePreferences(): SharedPreferences {
//        return context.getSharedPreferences("sp", Context.MODE_PRIVATE)
//    }
//
//}