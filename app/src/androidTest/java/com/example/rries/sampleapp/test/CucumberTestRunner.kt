package com.example.rries.sampleapp.test

import android.os.Bundle
import android.support.test.runner.MonitoringInstrumentation
import cucumber.api.CucumberOptions
import cucumber.api.android.CucumberInstrumentationCore

@CucumberOptions(
    features = ["features"],
    glue = ["com.example.rries.sampleapp.test"])
@Suppress("unused")
class CucumberTestRunner: MonitoringInstrumentation() {

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