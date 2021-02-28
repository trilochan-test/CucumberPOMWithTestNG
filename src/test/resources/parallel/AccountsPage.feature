@Accounts
Feature: Account Page Feature

  Background: 
    Given User has already logged in to application
      | username                    | password       |
      | trilochanreddy536@gmail.com | Selenium@12345 |

  @Smoke
  Scenario: Accounts page title
    Given User is on Accounts page
    When User gets the title of the Page
    Then Page title should be "My account - My Store"

  @Regression @Skip_Scenario
  Scenario: Accounts Section Count
    Given User is on Accounts page
    Then User gets Accounts section
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS              |
    And Accounts section count should be 5
