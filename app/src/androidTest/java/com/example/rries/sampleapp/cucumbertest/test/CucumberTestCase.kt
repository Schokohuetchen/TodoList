package com.example.rries.sampleapp.cucumbertest.test

import cucumber.api.CucumberOptions

@CucumberOptions(
    features = ["features"],
    glue = ["com.example.rries.sampleapp.cucumbertest.cucumber.steps"],
    plugin = ["pretty"])
@Suppress("unused")
class CucumberTestCase