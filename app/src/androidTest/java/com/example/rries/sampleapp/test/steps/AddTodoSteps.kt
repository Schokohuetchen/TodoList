package com.example.rries.sampleapp.test.steps

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.example.rries.sampleapp.TodoApplication
import com.example.rries.sampleapp.data.TodoRepository
import com.example.rries.sampleapp.test.robots.AddTodoRobot
import com.example.rries.sampleapp.ui.TodoListActivity
import com.example.rries.sampleapp.utils.dagger.DaggerTestComponent
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import junit.framework.TestCase.assertNotNull
import javax.inject.Inject

open class AddTodoSteps {

    private val robot = AddTodoRobot()

    private val activityTestRule = ActivityTestRule(TodoListActivity::class.java, false, false)

    @Inject
    lateinit var todoRepository: TodoRepository

    @Before
    fun setup() {
        val context = InstrumentationRegistry.getTargetContext().applicationContext as TodoApplication
        DaggerTestComponent.builder().applicationComponent(context.component).build().inject(this)

        todoRepository.deleteAll()
        robot.launchTodoListActivity(activityTestRule)
    }

    @After
    fun destroy() {
        activityTestRule.finishActivity()
        todoRepository.deleteAll()
    }

    @Given("I see the list")
    fun i_see_the_list() {
        assertNotNull(activityTestRule)
    }

    @When("I click on the add button")
    fun i_click_on_the_add_button() {
        robot.clickOnFabButton()
    }

    @And("I see an editor")
    fun i_see_an_editor() {
        robot.editorOpened()
    }

    @And("I enter {string} in the text field")
    fun i_enter_todo_in_the_text_field(todo: String) {
        robot.enterNewTodo(todo)
    }

    @And("I click the save button")
    fun i_click_the_save_button() {
        robot.clickOnSaveButton()
    }

    @Then("I should see the list with the new {string}")
    fun i_should_see_the_list_with_the_new_todo(string: String) {
        robot.openListWithNewTodo(string)
    }

}