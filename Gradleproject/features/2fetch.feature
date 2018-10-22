@fetchaccount
Feature: Fetch FC Account


  Scenario: Fetch FC Account
    Given verify fetch account page is displayed
    When verify fetch button and notificationbell icon is visible
    Then verify all other elements are visible and click fetch button

  @fetch
  Scenario Outline: Title of your scenario outline
    Given Verify fetch popup is visible
    When fetch account "<account>" 
    Then verify "<status>" account is fetched successfully

    Examples: 
      | account    | status |
      | 1234567890 | fail   |
      | 8005000076 | pass   |
