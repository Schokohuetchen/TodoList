package com.example.rries.sampleapp.test.robots

import android.support.test.espresso.Espresso.*
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import com.example.rries.sampleapp.R
import com.example.rries.sampleapp.ui.TodoListActivity
import java.lang.Thread.sleep

class AddTodoRobot {

    fun launchTodoListActivity(testRule: ActivityTestRule<TodoListActivity>) {
        testRule.launchActivity(null)
    }

    fun clickOnFabButton() {
        onView(ViewMatchers.withId(R.id.fab)).perform(ViewActions.click())
    }

    fun editorOpened() {
        onView(ViewMatchers.withId(R.id.editActivity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun enterNewTodo(todo: String) {
        onView(ViewMatchers.withId(R.id.editTodo)).perform(ViewActions.typeText(todo))
    }

    fun clickOnSaveButton() {
        onView(ViewMatchers.withId(R.id.saveTodoButton)).perform(ViewActions.click())
    }

    fun openListWithNewTodo(todo: String) {
        onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText(todo)))
    }
}