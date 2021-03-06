package com.example.rries.sampleapp.test.robots

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.example.rries.sampleapp.R
import com.example.rries.sampleapp.ui.TodoListActivity

class AddTodoRobot {

    fun launchTodoListActivity(testRule: ActivityTestRule<TodoListActivity>) {
        testRule.launchActivity(null)
    }

    fun clickOnFabButton() {
        onView(withId(R.id.fab)).perform(click())
    }

    fun editorOpened() {
        onView(withId(R.id.editActivity))
            .check(ViewAssertions.matches(isDisplayed()))
    }

    fun enterNewTodo(todo: String) {
        onView(withId(R.id.editTodo)).perform(typeText(todo))
    }

    fun clickOnSaveButton() {
        onView(withId(R.id.saveTodoButton)).perform(click())
    }

    fun openListWithNewTodo(todo: String) {
        onView(withId(R.id.textView)).check(ViewAssertions.matches(withText(todo)))
    }
}