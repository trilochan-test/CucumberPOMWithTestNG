@Login
Feature: Login Page Feature

  @Smoke
  Scenario: Login Page Title
    Given User is on Login Page
    When User gets the title of the Page
    Then Page title should be "Login - My Store"

  @Smoke
  Scenario: Forgot Password Link
    Given User is on Login Page
    Then Forgot your password link should be displayed

  @Prod @Skip_Scenario
  Scenario: Login with Correct Credentials
    Given User is on Login Page
    When User enters username "trilochanreddy536@gmail.com"
    And User enters password "Selenium@12345"
    And User Clicks on Login button
    Then User gets the title of the Page
    And Page title should be "My account - My Store"
