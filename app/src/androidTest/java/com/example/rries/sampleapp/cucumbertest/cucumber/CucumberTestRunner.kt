package com.example.rries.sampleapp.cucumbertest.cucumber

import android.os.Bundle
import android.support.test.runner.AndroidJUnitRunner
import cucumber.api.android.CucumberInstrumentationCore

@Suppress("unused")
class CucumberTestRunner: AndroidJUnitRunner() {

    private val instrumentationCore = CucumberInstrumentationCore(this)

    override fun onCreate(arguments: Bundle?) {
        instrumentationCore.create(arguments)
        super.onCreate(arguments)
    }

    override fun onStart() {
        super.onStart()

        waitForIdleSync()
        instrumentationCore.start()
    }
}