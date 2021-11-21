package com.jyoti.localization.di.modules

import com.jyoti.localization.R
import com.jyoti.localization.network.ConfigProvider
import com.jyoti.localization.network.config_url
import com.jyoti.localization.repo.LocalisationProvider
import com.jyoti.localization.repo.LocalisationProviderImpl
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideConfig(): ConfigProvider = ConfigProvider(R.raw.localize_strings, config_url)

    @Provides
    fun provideLocalisationProvider(): LocalisationProvider = LocalisationProviderImpl(provideConfig())

}