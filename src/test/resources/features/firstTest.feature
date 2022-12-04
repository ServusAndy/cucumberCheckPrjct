Feature: Web Login

  @User.Login.Successfully
  Scenario: User should be able to Login with valid credentials
    Given setUp Driver
    And the user is on Login page
    And the user enters valid user name "andy" and password "Test1234!"
    And hits Submit
    Then the user should be logged successfully