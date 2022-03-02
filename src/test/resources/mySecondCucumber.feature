Feature: Login

  Scenario Outline: Login Facebook

    Given I have access to facebook
    When I type email: <email>
    And I type the password: <pass>
    And I click on login button
    Then I should be logger

    Examples:
      | email                   | pass |
      | camilolagarva@gmailcom1 | 123  |
      | camilolagarva@gmailcom2 | 456  |
      | camilolagarva@gmailcom3 | 789  |
      | camilolagarva@gmailcom4 | 1011 |
