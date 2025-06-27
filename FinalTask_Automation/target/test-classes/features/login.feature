Feature: Login form on SauceDemo

  Scenario: UC-1 Empty credentials
    Given I open the login page
    And I enter username "dummy" and password "dummy"
    And I clear the inputs
    When I click the login button
    Then I should see the error message "Username is required"

  Scenario: UC-2 Missing password
    Given I open the login page
    And I enter username "dummy" and password "somepass"
    And I clear the password input
    When I click the login button
    Then I should see the error message "Password is required"

  Scenario Outline: UC-3 Valid credentials
    Given I open the login page
    And I enter username "<user>" and password "secret_sauce"
    When I click the login button
    Then I should land on the dashboard with title "Swag Labs"

    Examples:
      | user         |
      | standard_user |
      | problem_user  |
