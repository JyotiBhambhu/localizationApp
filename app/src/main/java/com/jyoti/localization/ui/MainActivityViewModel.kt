package com.jyoti.localization.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jyoti.localization.network.model.CustomLocale
import javax.inject.Inject

class MainActivityViewModel @Inject constructor() : ViewModel() {

    private val _selLocaleLiveData = MutableLiveData<CustomLocale>()
    val selLocaleLiveData: LiveData<CustomLocale> = _selLocaleLiveData


    fun setLocale(locale: CustomLocale){
        _selLocaleLiveData.value = locale
    }


}