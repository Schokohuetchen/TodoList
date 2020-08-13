package com.example.rries.sampleapp.espressotests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.rries.sampleapp.R
import com.example.rries.sampleapp.ui.TodoListActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleTest {

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
    fun example() {
        onView(withId(R.id.todoListActivity)).check(matches(isDisplayed()))
    }
}