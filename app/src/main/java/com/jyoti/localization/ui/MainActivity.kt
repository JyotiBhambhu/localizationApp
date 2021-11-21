package com.jyoti.localization.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jyoti.localization.R
import com.jyoti.localization.databinding.ActivityMainBinding
import com.jyoti.localization.network.model.CustomLocale
import com.jyoti.localization.storage.Storage
import dagger.android.AndroidInjection
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainActivityViewModel

    @Inject
    lateinit var storage: Storage

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.networkDataProgressBar.visibility = View.VISIBLE
        viewModel.setLocale(storage.getPreferredLocale())
        viewModel.fetchLocalizedFile()

        initListeners()
        initObservers()

    }

    private fun initListeners(){
        binding.btnChinese.setOnClickListener {
            viewModel.setLocale(CustomLocale.CHINESE.locale)
        }

        binding.btnHindi.setOnClickListener {
            viewModel.setLocale(CustomLocale.HINDI.locale)
        }

        binding.btnEnglish.setOnClickListener {
            viewModel.setLocale(CustomLocale.ENGLISH.locale)
        }
    }

    private fun initObservers() {

        viewModel.selLocaleLiveData.observe(this, {
            refreshViews()
        })

        viewModel.localLiveData.observe(this, {
            binding.networkDataProgressBar.visibility = View.GONE
            refreshViews()
        })

    }

    private fun refreshViews(){
        viewModel.apply {
            binding.txvHello.setLocaleText(
                this@MainActivity,
                localLiveData.value,
                selLocaleLiveData.value,
                R.string.hello_world
            )
        }
    }


}