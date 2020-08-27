package com.example.testapp

import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.spyk
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@Config(sdk = [28])
class MainActivityTest {
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    private val mockData = MutableLiveData<String>()

    private val mockViewModel = spyk(MainViewModel()) {
        every { data } returns mockData
        every { fetchData() } just Runs
    }

    @Test
    fun `robo livedata errors`() {
        activityRule.launchActivity(null)
        activityRule.activity.mainViewModel = mockViewModel
        mockData.value = "test"
    }
}

