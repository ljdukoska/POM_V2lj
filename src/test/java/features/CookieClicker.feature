Feature: Cookie Clicker Game
  As a user I should be able to click the cookie and get some points,
  also I should be able to buy upgrades.

  Background: I start the game
    * I am on Cookie Clicker page
    * I select English language

  @Scenario1
  Scenario: Click cookie 10 times and buy the first upgrade
  As a user I should be able to click the cookie 10 times
  and the upgrade should be enabled for purchase.

    * I click cookie "15" times
    * I should see "product0" product is available
    * I buy the product "product0"
    * I should see "upgrade0" and "upgrade1"
    * I should see "note-1" "note-2" "note-3" "note-4"

  @Scenario2
  Scenario: Click cookie 100 times and buy the second upgrade
  As a user I should be able to click the cookie 100 times
  and the upgrade should be enabled for purchase.

    * I click cookie "100" times
    * I should see "product1" product is available
    * I buy the product "product1"
    * I should see "upgrade0"
    * I should see "note-1" "note-2"

  @Scenario3
  Scenario Outline: Click cookie
    * I click cookie "<clickTimes>" times
    * I should see "<product>" product is available

    Examples:
      | clickTimes | product  |
      | 15         | product0 |
      | 100        | product1 |

  @Scenario4
  Scenario Outline: I read excel

    * I read test data "<fileName>" "<sheetName>" "<row>"
    * I print out data

    Examples:
      | fileName | sheetName | row |
      | TestData | Sheet1    | 1   |
      | TestData | Sheet1    | 2   |

