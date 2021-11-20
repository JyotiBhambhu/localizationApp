package com.jyoti.localization.di.components

import com.jyoti.localization.MyApplication
import com.jyoti.localization.di.modules.ActivitiesModule
import com.jyoti.localization.di.modules.NetworkModule
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivitiesModule::class,
        NetworkModule::class,
//        StorageModule::class
    ]
)
interface AppComponent {

    fun inject(myApplication: MyApplication)
    fun inject (networkModule: NetworkModule)
//    fun inject (storageModule: StorageModule)

}
