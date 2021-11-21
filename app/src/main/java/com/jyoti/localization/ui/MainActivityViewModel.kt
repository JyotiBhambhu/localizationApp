package com.jyoti.localization.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jyoti.localization.network.ConfigProvider
import com.jyoti.localization.network.model.LocalisationDataClass
import com.jyoti.localization.storage.Storage
import kotlinx.coroutines.*
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val configProvider: ConfigProvider) : ViewModel() {

    @Inject
    lateinit var storage: Storage

    private var viewModelScope =  CoroutineScope(Dispatchers.Main + SupervisorJob()+ CoroutineExceptionHandler{ _, t ->
        t.printStackTrace()
    })

    private val _selLocaleLiveData = MutableLiveData<String>()
    val selLocaleLiveData: LiveData<String> = _selLocaleLiveData

    private val _localLiveData = MutableLiveData<LocalisationDataClass>()
    val localLiveData: LiveData<LocalisationDataClass> = _localLiveData


    fun setLocale(locale: String) {
        _selLocaleLiveData.value = locale
        storage.setPreferredLocale(locale)
    }

     fun fetchLocalizedFile() {
         viewModelScope.launch {
             val data = configProvider.fetch<LocalisationDataClass>(false)
             _localLiveData.value = data
         }
    }


}