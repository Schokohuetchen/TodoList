package com.example.rries.sampleapp.test

import cucumber.api.CucumberOptions
import junit.framework.TestCase

@CucumberOptions(
    features = ["features"],
    glue = ["com.example.rries.sampleapp.cucumber.steps"])
@Suppress("unused")
class CucumberTestCase: TestCase()