package com.jyoti.localization.di.modules

import com.jyoti.localization.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

}