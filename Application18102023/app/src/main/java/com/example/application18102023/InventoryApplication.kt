package com.example.application18102023

import android.app.Application
import com.example.application18102023.data.AppContainer
import com.example.application18102023.data.AppDataContainer

class InventoryApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}