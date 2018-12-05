package com.example.rries.sampleapp.cucumbertests

import android.support.test.rule.ActivityTestRule
import com.example.rries.sampleapp.ui.TodoListActivity
import com.mauriciotogneri.greencoffee.GreenCoffeeConfig
import com.mauriciotogneri.greencoffee.GreenCoffeeTest
import com.mauriciotogneri.greencoffee.Scenario
import com.mauriciotogneri.greencoffee.ScenarioConfig
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.io.IOException

@RunWith(Parameterized::class)
open class AddTodoFeaturesTest(scenarioConfig: ScenarioConfig): GreenCoffeeTest(scenarioConfig) {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(TodoListActivity::class.java, false, false)

    @Before
    fun setup() {
        activityTestRule.launchActivity(null)
    }

    @After
    fun destroy() {
        activityTestRule.finishActivity()
    }

    @Test
    fun test() {
        start(AddTodoSteps(activityTestRule))
    }

    companion object {
        @Parameterized.Parameters(name = "{0}")
        @Throws(IOException::class)
        @JvmStatic
        fun scenarios(): Iterable<ScenarioConfig> {
            return GreenCoffeeConfig()
                    .withFeatureFromAssets("assets/features/addTodo.feature")
                    .scenarios()
        }
    }
}