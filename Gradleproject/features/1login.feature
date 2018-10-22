@login
Feature: Login to Form Creature

  @fetchFC
  Scenario: fetch form creator web page
    Given Verify the browser is opened 
    When Fetch FC URL
    Then verify FC text is visible
    And verify email password text box and signin button is enabled
    And verify show and hide option in password text box and or text is visible
    And verify signin text email and facebook button is enabled 

  @tag2
  Scenario Outline: login with valid and in valid data
    Given when email and passwrod text box is enabled
    When Enter email id "<username>" and password "<password>"
    Then Verify login is sucessfully done with "<status>"

    Examples: 
      | username  | password | status |
      | ponnuswamy@anywhere.co |  ponnuswamy | fail |
      | abcdefghijklmnopqrstuvwxyz | edaa1234567890 | fail |
      | pavithran.sunder@anywhere.co |  pavithran | pass |

      
