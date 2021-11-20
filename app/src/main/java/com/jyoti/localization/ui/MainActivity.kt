package com.jyoti.localization.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jyoti.localization.R
import dagger.android.AndroidInjection
import javax.inject.Inject
import com.google.android.material.internal.ContextUtils

import android.content.ContextWrapper
import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.jyoti.localization.MyApplication
import com.jyoti.localization.di.BaseActivity
import com.jyoti.localization.network.model.CustomLocale
import com.jyoti.localization.storage.Storage
import com.jyoti.localization.utils.ContextUtil
import com.jyoti.localization.utils.ContextUtil.Companion.updateLocale
import com.jyoti.localization.utils.LocaleUtil
import java.util.*


class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.selLocaleLiveData.observe(this, {
           setPreferredLocale(it)
        })
    }

    fun setChinese(view : View){
        viewModel.setLocale(CustomLocale.CHINESE)
    }

    fun setHindi(view : View){
        viewModel.setLocale(CustomLocale.HINDI)
    }

    fun setDefault(view : View) {
        viewModel.setLocale(CustomLocale.ENGLISH)
    }


}