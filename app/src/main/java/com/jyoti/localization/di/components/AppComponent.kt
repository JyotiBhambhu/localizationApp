package com.jyoti.localization.di.components

import com.jyoti.localization.MyApplication
import com.jyoti.localization.di.modules.ActivitiesModule
import com.jyoti.localization.di.modules.AppModule
import com.jyoti.localization.di.modules.StorageModule
import com.jyoti.localization.network.ConfigProvider
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivitiesModule::class,
        AppModule::class,
        StorageModule::class
    ]
)
interface AppComponent {

    fun inject(myApplication: MyApplication)
    fun inject (storageModule: StorageModule)
    fun configProvider(): ConfigProvider

}
