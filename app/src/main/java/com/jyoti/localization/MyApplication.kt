package com.jyoti.localization

import android.app.Application
import android.content.Context
import com.jyoti.localization.di.components.DaggerAppComponent
import com.jyoti.localization.di.modules.NetworkModule
import com.jyoti.localization.storage.Storage
import com.jyoti.localization.utils.LocaleUtil
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>

//    @Inject
//    lateinit var storage: Storage
//    val storage : Storage by lazy {
//        Storage(this)
//    }

    val storage : Storage by lazy {
        Storage(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return activityInjector
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleUtil.getLocalizedContext(base, Storage(base).getPreferredLocale()))
    }

    override fun onCreate() {
        super.onCreate()

        // added dagger
        DaggerAppComponent.builder()
            .networkModule(NetworkModule(this))
//            .storageModule(StorageModule(this))
            .build()
            .inject(this)


    }

}
