package com.jyoti.localization.di.modules

import com.jyoti.localization.R
import com.jyoti.localization.network.ConfigProvider
import com.jyoti.localization.network.config_url
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideFDConfig(): ConfigProvider = ConfigProvider(R.raw.localize_strings, config_url)

}