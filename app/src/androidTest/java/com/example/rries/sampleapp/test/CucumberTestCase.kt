package com.example.rries.sampleapp.test

import cucumber.api.CucumberOptions

@CucumberOptions(
    features = ["features"],
    glue = ["com.example.rries.sampleapp.steps"])
@Suppress("unused")
class CucumberTestCase