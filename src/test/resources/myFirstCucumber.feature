Feature: Login

  Background:
    Given I have access to facebook

  Scenario: Login Facebook

    When I type email: camilolagrava@gmail.com
    And I type the password: 123456
    And I click on login button
    Then I should be logger

  Scenario: Login Facebook2

    And I click on login button
    Then I should be logger

  Scenario: Login Facebook3

    When I type email: camilolagrava@gmail.com
    And I click on login button
    Then I should be logger
