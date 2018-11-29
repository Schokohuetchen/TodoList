Feature: Add Todo

        Scenario Outline: Add todo to list
                Given I see the list
                When I click on the add button
                And I see an editor
                And I enter a todo in the text field "<todo>"
                And I click the save button
                Then I should see the list with the new todo "<todo>"

                Examples:
                        | todo |
                        | testTodo |




