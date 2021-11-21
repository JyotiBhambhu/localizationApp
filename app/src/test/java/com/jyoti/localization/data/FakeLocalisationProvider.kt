package com.jyoti.localization.data

import com.jyoti.localization.network.model.LocalisationDataClass
import com.jyoti.localization.repo.LocalisationProvider

class FakeLocalisationProvider: LocalisationProvider {

    override suspend fun provideLocalisedFile(): LocalisationDataClass {
        val hindiList = arrayListOf(LocalisationDataClass.StringDataClass("Hello_World", "नमस्ते दुनिया"))
        val chineseList = arrayListOf(LocalisationDataClass.StringDataClass("Hello_World", "你好，世界"))
        return LocalisationDataClass(
            hi = hindiList,
            zh = chineseList
        )
    }

}