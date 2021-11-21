package com.jyoti.localization.repo

import com.jyoti.localization.network.ConfigProvider
import com.jyoti.localization.network.model.LocalisationDataClass
import javax.inject.Inject

interface LocalisationProvider {
    suspend fun provideLocalisedFile() : LocalisationDataClass
}

open class LocalisationProviderImpl @Inject constructor(private val configProvider: ConfigProvider): LocalisationProvider{
    override suspend fun provideLocalisedFile(): LocalisationDataClass {
        return configProvider.fetch(false)
    }
}