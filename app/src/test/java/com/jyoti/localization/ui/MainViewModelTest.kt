package com.jyoti.localization.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jyoti.localization.TestCoroutineRule
import com.jyoti.localization.data.FakeLocalisationProvider
import com.jyoti.localization.network.ConfigProvider
import com.jyoti.localization.repo.LocalisationProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner
import java.util.*


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get: Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get: Rule
    val testCoroutineRule = TestCoroutineRule()

    private var localisationProvider: LocalisationProvider = FakeLocalisationProvider()

    private lateinit var viewModel: MainActivityViewModel


    @Before
    fun setUp() {
        viewModel = MainActivityViewModel(localisationProvider)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testFetchLocalizedFile() = runBlockingTest{
        //when
        viewModel.fetchLocalizedFile()

        //then
        assert(viewModel.localLiveData.value?.hi?.firstOrNull { it.key == "Hello_World"}?.value == "नमस्ते दुनिया")
//        assert(viewModel.localLiveData.value?.zh?.firstOrNull { it.key == "Hello_World"}?.value == "你好，世界ा")
    }

    @After
    fun tearDown() {
        // do something if required
    }
}