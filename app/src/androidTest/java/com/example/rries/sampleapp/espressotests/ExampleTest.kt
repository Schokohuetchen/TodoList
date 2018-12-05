package com.example.rries.sampleapp.espressotests

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
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