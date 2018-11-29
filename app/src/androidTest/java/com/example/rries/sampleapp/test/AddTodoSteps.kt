package com.example.rries.sampleapp.test

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import com.example.rries.sampleapp.R
import com.example.rries.sampleapp.ui.TodoListActivity
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.junit.After
import org.junit.Rule

open class AddTodoSteps {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(TodoListActivity::class.java, false, false)

    @After
    fun tearDown() {
        activityTestRule.finishActivity()
    }

    @Given("^I see the list")
    fun I_see_the_list() {
        activityTestRule.launchActivity(null)
    }

    @When("^I click on the add button")
    fun I_click_on_the_add_button() {
        onView(withId(R.id.fab)).perform(click())
    }

    @When("^I see an editor")
    fun I_see_an_editor() {
        onView(withId(R.id.editActivity)).check(matches(isDisplayed()))
    }

    @When("^I enter a todo in the text field \\\"(.*?)\\\"\$")
    fun I_enter_a_todo_in_the_text_field(todo: String) {
        onView(withId(R.id.editTodo)).perform(typeText(todo))
    }

    @When("^I lick the save button")
    fun I_click_the_save_button() {
        onView(withId(R.id.saveTodoButton)).perform(click())
    }

    @Then("^I should see the list with the new todo \\\"(.*?)\\\"\$")
    fun I_should_see_the_list_with_the_new_todo(todo: String) {
        onView(withId(R.id.textView)).check(matches(withText(todo)))
    }

}