package com.assingment.android

import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.assingment.android.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinExperimentalAPI
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

@KoinExperimentalAPI
class QuizApplication : MultiDexApplication(), KoinComponent {

    override fun onCreate() {
        super.onCreate()

        MultiDex.install(this)

        startKoin {
            androidContext(this@QuizApplication)
            modules(appComponent)
        }
    }

}