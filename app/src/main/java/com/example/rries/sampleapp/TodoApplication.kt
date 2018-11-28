package com.example.rries.sampleapp

import android.app.Application
import com.example.rries.sampleapp.dagger.ApplicationModule
import com.example.rries.sampleapp.dagger.RoomModule
import com.example.rries.sampleapp.dagger.components.ApplicationComponent
import com.example.rries.sampleapp.dagger.components.DaggerApplicationComponent
import javax.inject.Singleton

@Singleton
class TodoApplication: Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder().roomModule(RoomModule(this)).applicationModule(ApplicationModule(this)).build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}