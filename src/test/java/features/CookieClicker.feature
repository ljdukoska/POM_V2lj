Feature: Cookie Clicker Game
  As a user I should be able to click the cookie and get some points,
  also I should be able to buy upgrades.

  Scenario: Click cookie 10 times and buy the first upgrade
    As a user I should be able to click the cookie 10 times
    and the upgrade should be enabled for purchase.

    Given I am on Cookie Clicker page
    And I select English language
    When I click cookie 15 times
    Then I should see upgrade is available
    When I buy the upgrade
    Then I should see