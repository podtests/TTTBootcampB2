Feature: Login
  This feature helps user to get access to the application

  Background: Pre Steps
    Given Application URL is open

  @smoke @regression @jira100 @valid @login
  Scenario Outline: User with valid credentials should get loggedIn.
    When user provides credentials as "<username>" and "<password>"
    Then user "<result>" get loggedIn successfully

    Examples:
    | username | password | result |
    | Akhiljda@gmail.com | Password | should |
    | Akhiljda1@gmail.com | Password | should not |







 # @invalid @jira100 @login
 # Example: User with invalid credentials shouldn't get loggedIn.
  #  When user provides credentials as "Akhiljda1@gmail.com" and "password"
  #  Then user "should not" get loggedIn successfully