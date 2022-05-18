package com.assingment.android

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.assingment.android.view.share.SharedViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class SharedViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun testInitQuizViewModel() {
//        val shareViewModel = SharedViewModel()
//        assertEquals("", shareViewModel.name.value)
//        assertEquals(0, shareViewModel.score)
    }
}
