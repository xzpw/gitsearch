package com.dm.gitsearch

import android.app.Application
import com.dm.gitsearch.di.appModule
import com.dm.gitsearch.di.netWorkModule
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            this@App
            modules(listOf(netWorkModule, appModule) )
            applicationContext
        }
    }
}