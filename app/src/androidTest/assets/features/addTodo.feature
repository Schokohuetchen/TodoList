Feature: Add Todo

        Scenario: Add todo to list
                Given I see the list
                When I click on the add button
                And  I see an editor
                And I enter "testTodo" in the text field
                And I click the save button
                Then I should see the list with the new "testTodo"






