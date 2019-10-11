#---------------------------------------------------------------------------------------------------------------------------------
# Authors : Saravana Sabareesh V     																																Reviewed By: Dinesh Kumar
# Date   :   25/07/2019                                                                             Reviewed On: 13/08/2019
# Last Updated By:
# Last Updated On:
# Feature Name: Fundamental Refrigerant Management Form - LEED v4.1 O+M: EB
# Feature Description: Filling all the fields of the form, checking the autosave functionality and negative cases for the form
#---------------------------------------------------------------------------------------------------------------------------------
@cucumberTags
Feature: Fundamental Refrigerant Management Form - LEED v4.1 O+M: EB

  #Scenario-1
  @SmokeTest
  Scenario Outline: Filling Fundamental Refrigerant Management form for noCfcRefrigerants
  Given User clicks on project <formname> and <ratingSystem>
  And User navigates to the credits page of the project
  And User should be on form <formname>
  And User verifies form version,credit name matches in scorecard and form page
  And User checks the checkbox option and verifies form draft is saved automatically after 10 sec complete
  And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
  And User uploads files to Add file button and verifies form is not saved as draft
  When User clicks on Save button
  And User can able to see the form got saved
  And User verifies the revision icon present after saving the form
  And User dowloads the generated pdf form
  And User verifies the narrative from pdf and form page
  And User verifies the uploaded files from pdf and form page
  And User clicks the Complete icon to set status to Ready for Review
  And User downloads the uploaded files and verifies
  And User clicks on cancel while deleting the uploaded file and verifies the files are retained
  And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
  Then User logout and login to the form <formname> and rating <ratingSystem>
  And User verifies warning message of form saved as draft is present and draft not changed
  And User clicks on clear draft and verifies the draft is not present
  And User deletes the uploaded files and verifies the files are deleted
  ##And User uploads a file which is greater than 100MB <fileName> and verifies the error message
  And User uploads a file <fileName1>,clicks save button while uploading and verifies the error message
  And User logout the form
  
  Examples:
  | formname                                               | ratingSystem | fileName1     | fileName      |
  | Fundamental Refrigerant Management-noCfcRefrigerants!C | O+M:EB       | 24MBfile1.doc | 102MBfile.pdf |
  
  #Scenario-2
  @SmokeTest
  Scenario Outline: Filling Fundamental Refrigerant Management form for Comprehensive Phase-Out Plan
  Given User clicks on project <formname> and <ratingSystem>
  And User navigates to the credits page of the project
  And User should be on form <formname>
  And User verifies form version,credit name matches in scorecard and form page
  And User will select the Radio Button
  And User verifies form draft is saved automatically after 10 sec complete by selecting radio button
  And User checks the checkbox option and verifies form draft is saved automatically after 10 sec complete
  And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
  And User uploads files to Add file button and verifies form is not saved as draft
  And User fills the table <tableName> with data <testData> isAddRow <isAddRow> and verifies
  And User verifies draft saved automatically after filling the table
  When User clicks on Save button
  And User can able to see the form got saved
  And User verifies the revision icon present after saving the form
  And User dowloads the generated pdf form
  And User verifies the narrative from pdf and form page
  And User verifies the uploaded files from pdf and form page
  And User clicks the Complete icon to set status to Ready for Review
  And User downloads the uploaded files and verifies
  And User clicks on cancel while deleting the uploaded file and verifies the files are retained
  And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
  Then User logout and login to the form <formname> and rating <ratingSystem>
  And User verifies warning message of form saved as draft is present and draft not changed
  And User clicks on clear draft and verifies the draft is not present
  And User deletes the uploaded files and verifies the files are deleted
  And User clicks on save without entering the contents and verifies the error message
  ##And User uploads a file which is greater than 100MB <fileName> and verifies the error message
  And User uploads a file <fileName1>,clicks save button while uploading and verifies the error message
  And User logout the form
  
  Examples:
  | formname                                                   | ratingSystem | tableName                                             | testData                      | isAddRow | fileName1     | fileName      |
  | Fundamental Refrigerant Management-comprehensivePhaseOut!R | O+M:EB       | Table: Mechanical Cooling and Refrigeration Equipment | TD_FundamentalRefrigerantMgmt | Yes      | 24MBfile1.doc | 102MBfile.pdf |
 
  #Scenario-3
  @SmokeTest
  Scenario Outline: Filling Fundamental Refrigerant Management form for Economic Analysis
    Given User clicks on project <formname> and <ratingSystem>
    And User navigates to the credits page of the project
    And User should be on form <formname>
    And User verifies form version,credit name matches in scorecard and form page
    And User will select the Radio Button
    And User verifies form draft is saved automatically after 10 sec complete by selecting radio button
    And User checks the checkbox option and verifies form draft is saved automatically after 10 sec complete
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    And User uploads files to Add file button and verifies form is not saved as draft
    And User fills the table <tableName> with data <testData> isAddRow <isAddRow> and verifies
    And User fills the table <tableName1> with data <testData1> isAddRow <isAddRow1> and verifies
    And User verifies draft saved automatically after filling the table
    And User verifies Auto save after entering text box
    When User clicks on Save button
    And User can able to see the form got saved
    And User verifies the revision icon present after saving the form
    And User dowloads the generated pdf form
    And User verifies the narrative from pdf and form page
    And User verifies the uploaded files from pdf and form page
    And User clicks the Complete icon to set status to Ready for Review
    And User downloads the uploaded files and verifies
    And User clicks on cancel while deleting the uploaded file and verifies the files are retained
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    Then User logout and login to the form <formname> and rating <ratingSystem>
    And User verifies warning message of form saved as draft is present and draft not changed
    And User clicks on clear draft and verifies the draft is not present
    And User deletes the uploaded files and verifies the files are deleted
    ###And User uploads a file which is greater than 100MB <fileName> and verifies the error message
    And User uploads a file <fileName1>,clicks save button while uploading and verifies the error message
    And User logout the form

    Examples: 
      | formname                                              | ratingSystem | tableName                                             | testData                      | isAddRow | tableName1            | testData1        | isAddRow1 | fileName1     | fileName      |
      | Fundamental Refrigerant Management-economicAnalysis!R | O+M:EB       | Table: Mechanical Cooling and Refrigeration Equipment | TD_FundamentalRefrigerantMgmt | Yes      | Table: Simple Payback | TD_SimplePayback | No        | 24MBfile1.doc | 102MBfile.pdf |
