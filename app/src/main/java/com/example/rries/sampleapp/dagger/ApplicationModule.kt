package com.example.rries.sampleapp.dagger

import com.example.rries.sampleapp.TodoApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule constructor(private val context: TodoApplication){

    @Provides
    @Singleton
    fun providesContext() = context
}