package com.jyoti.localization.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jyoti.localization.network.ConfigProvider
import com.jyoti.localization.network.model.LocalisationDataClass
import com.jyoti.localization.repo.LocalisationProvider
import com.jyoti.localization.storage.Storage
import kotlinx.coroutines.*
import javax.inject.Inject

//ToDo: Enhancements:
//We can further separate repo layer from this layer
class MainActivityViewModel @Inject constructor(private val localisationProvider: LocalisationProvider) : ViewModel() {

    @Inject
    lateinit var storage: Storage

    private var viewModelScope =  CoroutineScope(Dispatchers.Main + SupervisorJob()+ CoroutineExceptionHandler{ _, t ->
        t.printStackTrace()
    })

    private val _selLocaleLiveData = MutableLiveData<String>()
    val selLocaleLiveData: LiveData<String> = _selLocaleLiveData

    private val _localLiveData = MutableLiveData<LocalisationDataClass>()
    val localLiveData: LiveData<LocalisationDataClass> = _localLiveData


    fun setLocale(locale: String = storage.getPreferredLocale()) {
        _selLocaleLiveData.value = locale
        storage.setPreferredLocale(locale)
    }

     fun fetchLocalizedFile() {
         viewModelScope.launch {
             _localLiveData.value = localisationProvider.provideLocalisedFile()
         }
    }


}