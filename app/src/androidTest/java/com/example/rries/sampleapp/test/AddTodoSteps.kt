package com.example.rries.sampleapp.test

import android.support.test.rule.ActivityTestRule
import com.example.rries.sampleapp.ui.TodoListActivity
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import junit.framework.TestCase.assertNotNull

open class AddTodoSteps {

    private val activityTestRule = ActivityTestRule(TodoListActivity::class.java, false, false)

    private val robot = AddTodoRobot()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        robot.launchTodoListActivity(activityTestRule)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        activityTestRule.finishActivity()
    }

    @Given("I see the list")
    fun i_see_the_list() {
        assertNotNull(activityTestRule.activity)
    }

    @When("I click on the add button")
    fun i_click_on_the_add_button() {
        robot.clickOnFabButton()
    }

    @Then("I see an editor")
    fun i_see_an_editor() {
        robot.editorOpened()
    }

    @And("I enter {string} in the text field")
    fun i_enter_testTodo_in_the_text_field(todo: String) {
        robot.enterNewTodo(todo)
    }

    @And("I click the save button")
    fun i_click_the_save_button() {
        robot.clickOnSaveButton()
    }

    @Then("I should see the list with the new {string}")
    fun i_should_see_the_list_with_the_new_todo(todo: String) {
        robot.openListWithNewTodo(todo)
    }

}