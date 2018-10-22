@Contentsearch
Feature: Content search

  @searchforcontent
  Scenario: Change scripting field content
    Given Check whether the search is visible
    When search for content
    And Change the content
    Then save the form

  @Addscenario
  Scenario: Add new scenario
    Given Goto to Scenario tab
    When Add new scenario and scenario steps
    Then Verify new scenario is added

  @Addnewcontact
  Scenario: Add new contact
    Given Goto contacts tab and verify contact tab is opened
    When Add new contact
    Then add new delivery method

  @Addholidays
  Scenario: Add new holiday and business hours
    Given Goto Detalis Tab
    When Add custom business hour
    Then add new holiday
    
  @searchforcontent
  Scenario: Search for content
    Given when search bar is visible
    When search for business hours and holiday and account details
    Then search for contact and delivery method
    And search for add field and field settings and form settings and form
    And search for form tab and scenario tab and contact tab and details tab

  @verifyinswitchboard
  Scenario: verify content changed in switch board
    Given veiwin switch board
    And when switch board opened
    When verify content changed
    Then close switch board
    And back to form creator
