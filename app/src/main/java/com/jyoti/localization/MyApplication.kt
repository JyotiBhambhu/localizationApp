package com.jyoti.localization

import android.app.Application
import com.jyoti.localization.di.components.DaggerAppComponent
import com.jyoti.localization.di.modules.StorageModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return activityInjector
    }

    override fun onCreate() {
        super.onCreate()

        context = this

        // added dagger
        DaggerAppComponent.builder()
            .storageModule(StorageModule(this))
            .build()
            .inject(this)
    }

    companion object{
        lateinit var context: Application
    }

}
