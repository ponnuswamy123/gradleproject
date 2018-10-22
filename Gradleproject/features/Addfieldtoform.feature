Feature: Add fields to form in FC

  @addform
  Scenario: Add new form and change form name
    Given when add form button is visible
    When Click on add form button
    And Goto form settings
    And change form name
    Then verifiy form name is changed

  @addnamefield
  Scenario: Goto add field and add name field for group one and change settings
    Given Click on add field for name field
    When drag and drop the name field
    Then goto to name field settings
    And Change name field text length and restrict special character
    And Change field script for name field

  @addphonefield
  Scenario: Goto add field and add phone field and change settings
    Given Click on add field for phone field
    When drag and drop the phone field
    Then goto to phone field settings
    And Change phone field text length
    And Disable phone field agent verification
    And Disable phone field System verification
    And Change field script for phone field

  @addemailfield
  Scenario: Goto add field and add Email field and change settings
    Given Click on add field for Email field
    When drag and drop the Email field
    Then goto to Email field settings
    And Change Email field text length
    And Change Email field restrict special character
    And Change field script for Email field

  @addmessagefield
  Scenario: Goto add field and add message field and change settings
    Given Click on add field for message field
    When drag and drop the message field
    Then goto to message field settings
    And Change message field restrict special character

  @addscriptingfield
  Scenario: Goto add field and add Scripting and change settings
    Given Click on add field for scripting field
    When drag and drop the Scripting field
    Then goto to scripting field settings
    And Change scripting field label name
    And Enable Scripting field verbatim

  @addinstructionfield
  Scenario: Goto add field and add instruction field and change settings
    Given Click on add field for instruction field
    When drag and drop the Instruction field
    Then goto to instruction field settings
    And Change instruction field label name

  @addcompanyfield
  Scenario: Goto add field and add Company field and Change settings
    Given Click on add field for company field
    When drag and drop the Company field
    Then goto to company field settings
    And Change company field text length
    And Change company field Restrict special character
    And Disable company field Agent verification

  @addurlfield
  Scenario: Goto add field and add URL field and change settings
    Given Click on add field for URL field
    When drag and drop the URL field
    Then goto to Url field settings
    And Change URL label name
    And Enter URL

  @addfinishcall
  Scenario: Goto add field and finish call field and change settings
    Given Click on add field for finish call field
    When drag and drop the finish call field
    Then goto to finish call field settings
    And enable send option for finish call field

  @addsinglelinetextfield
  Scenario: Goto add field and add Single line text and change settings
    Given Click on add field for Single line text
    When drag and drop the Single line text field
    Then goto to Single line text settings
    And Change Single line text length
    And change single line text restrict special character
    And Enable single line text agent verification
    And enable single line text numbers only

  @addfirstnamefield
  Scenario: Goto add field and add First name and change settings
    Given Click on add field for first name field
    When drag and drop the first name field
    Then goto first name field settings
    And Enable agent verification for first name field
    And Change first name text length
    And Change first name restrict special character

  @addlastnamefield
  Scenario: Goto add field and add Last name and change settings
    Given Click on add field for last name field
    When drag and drop the last name field
    Then goto last name field settings
    And Enable agent verification for last name field
    And Change last name field text length
    And Change last name field restrict special character

  @adddatefield
  Scenario: Goto add field and add Date field and Change settings
    Given click on add field for date field
    When drag and drop the Date field
    Then goto date field settings
    And Enable required for date field
    And Change date field format

  @addcityfield
  Scenario: Goto add field and add city field and change settings
    Given Click on add field for city field
    When drag and drop the City field
    Then goto City field settings
    And Enable Agent verification for city
    And Change city field text length
    And Change city field restrict special character

  @addstatefield
  Scenario: Goto add field and add state field and change settings
    Given Click on add field for state field
    When drag and drop the State field
    Then goto state field settings
    And Enable state field is required

  @addzipcodefield
  Scenario: Goto add field and add Zip code and change settings
    Given Click on add field for zip code
    When drag and drop the Zipcode field
    Then goto to Zipcode field settings
    And Change zipcode text length
    And Change zipcode restrict special character

  @addaddress1field
  Scenario: Goto add field and add Address one and change settings
    Given Click on add field for Address one field
    When drag and drop the Address one field
    Then goto to Address one field settings
    And Change Address one field text length
    And Change Address one field Restrict special character

  @addiframefield
  Scenario: Goto add field and add iframe field and change settings
    Given Click on add field for iframe field
    When drag and drop the iframe field
    Then goto to iframe field settings
    And Enter iframe URL
    And Change width of iframe window
    And Change heigth of iframe window

  @adddropdownfield
  Scenario: Goto add field and add dropdown field and change settings
    Given Click on add field for dropdown field
    When drag and drop the dropdown field
    Then goto to dropdown field settings
    And change dropdown field label name
    And change option name for dropdown field
    And Enable else option
    And Change else option name

  @adddecisiontreefield
  Scenario: Goto add field and add decision tree and change settings
    Given Click on add field for decision tree
    When Drag and drop the decision tree field
    Then enter number of branchs and click ok
    Then Goto decision tree field settings
    And rename all branches in decision tree
    And add another branch

  @addtimefield
  Scenario: Goto add field and add time field and change settings
    Given Click on add field for time field
    When Drag and drop the time field
    Then Goto time field settings
    And Change time field label name
    And Change time field format

  @addsetrepeatfield
  Scenario: Goto add field and add set repeat and change settings
    Given Cilck on add field for set repeat field
    When Drag and drop the set repeat field to decision tree
    Then goto set repeat field settings
    And Change set field repeat with duration

  @addcalltransferfield
  Scenario: Goto add field and add call transfer field and change settings
    Given Click on add field for call transfer field
    When Drag and drop the call transfer field to decision tree
    Then goto call transfer field settings
    And Select contact for call transfer

  @addoncallschedulefield
  Scenario: Goto add field and add on call schedule
    Given Click on add field for on call schedule
    When Drap and drop the on call schedule field to decision tree
    Then Change settings to Select new calender

  @addappointmentfield
  Scenario: Goto add field and add Appointment field and change settings
    Given Cilck on add field for Appointment
    When Drag and drop the appointment to decision tree
    Then goto Appointment field settings
    And Change Appointment provider to setmore

  @addcountryfield
  Scenario: Goto add field and add country field from group two and change settings
    Given click on group two and Click on add field for country field
    When Drag and drop the country field
    Then Goto country field settings
    And Change Country field text length and restrict Special character
    And Enable Agent verification and required

  @addcustomerfield
  Scenario: Goto add field and add Customer Status and change settings
    Given Cilck on add field for Customer status
    When Drag and drop the customer status field
    Then goto custumer field settings
    And Change client status
    And Set Customer Status Expiration

  @multiselectfield
  Scenario: Goto add field and add multiselect field and change settings
    Given Click on add field for multiselect field
    When Drag and drop the multiselect field
    Then goto multiselect field settings
    And Add options and change options name
    And Change label name and enable else option and rename

  @addhiddenfield
  Scenario: Goto add field and add Hidden field and change settings
    Given Click on add field for Hidden field
    When Drag and drop the hidden field
    Then goto Hidden field setting
    And Change field label and field value for hidden field

  @addcustomphonefield
  Scenario: Goto add field and add custom phone field and change settings
    Given Click on add field for custom phone field
    When drag and drop the custom phone field
    Then goto custom phone field settings
    And Change custom phone field text length
    And Disable custom phone field agent verification and required verification

  @addaddress2field
  Scenario: Goto add field and add Address two field and change settings
    Given Click on add field for Address two field
    When drag and drop the Address two field
    Then goto Address two field settings
    And Change Address two field text length and Restrict special character
    Then save form and publish and verify
    And Veiw in switch board

  @verify_all_fields_in_switch_board
  Scenario: Verify all field are added in switch board
    Given when switch board is opened
    When verify name phone email and script field added to switch board 
    And verify all field are visible in switch board
    Then close switch board back to form creator
