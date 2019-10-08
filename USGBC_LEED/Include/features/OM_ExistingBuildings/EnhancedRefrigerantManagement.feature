
#---------------------------------------------------------------------------------------------------------------------------------
# Authors : Gelli Akhil					     																																Reviewed By: Dinesh Kumar   
# Date   :   24/07/2019                                                                             Reviewed On: 13/08/2019                      
# Last Updated By:
# Last Updated On:
# Feature Name: Enhanced Refrigerant Management Form - LEED v4.1 O+M: EB
# Feature Description: Filling all the fields of the form, checking the autosave functionality and negative cases for the form
#---------------------------------------------------------------------------------------------------------------------------------
@cucumberTags
Feature: Enhanced Refrigerant Management Form - LEED v4.1 O+M: EB

  #Scenario-1
  @SmokeTest
  Scenario Outline: Filling Enhanced Refrigerant Management form for No Refrigerants or Low-Impact Refrigerants
    Given User clicks on project <ratingSystem> positiveFlow
    And User navigates to the credits page of the project
    And User should be on form <formname>
    And User verifies form version,credit name matches in scorecard and form page
    When User will select the Radio Button
    And User uploads files to Add file button
    And User verifies the uploaded files
    And User Enters data to Narrative field and verifies
    And User clicks on Save button
    Then User can able to see the form got saved
    And User verifies the revision icon present after saving the form
    And User dowloads the generated pdf form
    And User verifies the narrative from pdf and form page
    And User verifies the uploaded files from pdf and form page
    And User clicks the Complete icon to set status to Ready for Review
    And User downloads the uploaded files and verifies
    And User clicks on cancel while deleting the uploaded file and verifies the files are retained
    And User deletes the uploaded files and verifies the files are deleted
And User logout the form

    Examples: 
      | formname                                            | ratingSystem |
      | Enhanced Refrigerant Management-noRefrigOrLowImpact | O+M:EB       |

  #Scenario-2
  @SmokeTest
  Scenario Outline: Filling Enhanced Refrigerant Management form for Calculation of Refrigerant Impact
    Given User clicks on project <ratingSystem> positiveFlow
    And User navigates to the credits page of the project
    And User should be on form <formname>
    And User verifies form version,credit name matches in scorecard and form page
    When User will select the Radio Button
    And User uploads files to Add file button
    And User verifies the uploaded files
    And User Enters data to Narrative field and verifies
    And User fills the table <tableName> with data <testData> isAddRow <isAddRow> and verifies
    And User clicks on Save button
    Then User can able to see the form got saved
    And User verifies the revision icon present after saving the form
    And User dowloads the generated pdf form
    And User verifies the narrative from pdf and form page
    And User verifies the uploaded files from pdf and form page
    And User verifies the tables with pdf and form page
    And User checks the units of table
    And User changes the unit type <formname> rating <ratingSystem>
    And User checks the units are not same in table
    And User revert the unit type <formname> rating <ratingSystem>
    And User deletes the table rows table <tableName> with data <testData>
    And User clicks the Complete icon to set status to Ready for Review
    And User downloads the uploaded files and verifies
    And User clicks on cancel while deleting the uploaded file and verifies the files are retained
    And User deletes the uploaded files and verifies the files are deleted
And User logout the form

    Examples: 
      | formname                                              | ratingSystem | tableName                                             | testData                                      | isAddRow |
      | Enhanced Refrigerant Management-calcRefrigerantImpact | O+M:EB       | Table: Mechanical Cooling and Refrigeration Equipment | TD_MechanicalCoolingandRefrigerationEquipment | Yes      |

  #Scenario-3
  @SmokeTest
  Scenario Outline: Checking Auto Save functionality in Enhanced Refrigerant Management form for No Refrigerants or Low-Impact Refrigerants
    Given User clicks on project <ratingSystem> AutoSave
    And User navigates to the credits page of the project
    And User should be on form <formname>
    When User will select the Radio Button
    And User verifies form draft is saved automatically after 10 sec complete by selecting radio button
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    And User will not make any changes in the form and verifies form is not saved as draft
    And User uploads files to Add file button and verifies form is not saved as draft
    And User logout and login to the form <formname> and rating <ratingSystem>
    And User verifies warning message of form saved as draft is present and draft not changed
    Then User clicks on Save button and deletes the uploaded files
    And User verifies clear draft,warning message is not present
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    And User clicks on clear draft and verifies the draft is not present
And User logout the form

    Examples: 
      | formname                                            | project          | ratingSystem |
      | Enhanced Refrigerant Management-noRefrigOrLowImpact | BDD6 TestProject | O+M:EB       |

  #Scenario-4
  @SmokeTest
  Scenario Outline: Checking Auto Save functionality in Enhanced Refrigerant Management form for Calculation of Refrigerant Impact
    Given User clicks on project <ratingSystem> AutoSave
    And User navigates to the credits page of the project
    And User should be on form <formname>
    When User will select the Radio Button
    And User verifies form draft is saved automatically after 10 sec complete by selecting radio button
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    And User will not make any changes in the form and verifies form is not saved as draft
    And User uploads files to Add file button and verifies form is not saved as draft
    And User fills the table <tableName> with data <testData> isAddRow <isAddRow> and verifies
    And User verifies draft saved automatically after filling the table
    And User logout and login to the form <formname> and rating <ratingSystem>
    And User verifies warning message of form saved as draft is present and draft not changed
    Then User clicks on Save button and deletes the uploaded files
    And User verifies clear draft,warning message is not present
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    And User clicks on clear draft and verifies the draft is not present
And User logout the form

    Examples: 
      | formname                                              | ratingSystem | tableName                                             | testData                                      | isAddRow |
      | Enhanced Refrigerant Management-calcRefrigerantImpact | O+M:EB       | Table: Mechanical Cooling and Refrigeration Equipment | TD_MechanicalCoolingandRefrigerationEquipment | Yes      |

  #Scenario-5
  @NegativeTest
  Scenario Outline: Negative scenario for Enhanced Refrigerant Management-noRefrigOrLowImpact
    Given User clicks on project <ratingSystem> Negative
    And User navigates to the credits page of the project
    And User should be on form <formname>
    When User will select the Radio Button
    When User clicks on save without entering the contents and verifies the error message
    ###And User uploads a file which is greater than 100MB <fileName> and verifies the error message
    And User uploads a file <fileName1>,clicks save button while uploading and verifies the error message
And User logout the form

    Examples: 
      | formname                                            | ratingSystem | fileName1     | fileName      |
      | Enhanced Refrigerant Management-noRefrigOrLowImpact | O+M:EB       | 24MBfile1.doc | 102MBfile.pdf |

  #Scenario-6
  @NegativeTest
  Scenario Outline: Negative scenario for Enhanced Refrigerant Management-calcRefrigerantImpact
    Given User clicks on project <ratingSystem> Negative
    And User navigates to the credits page of the project
    And User should be on form <formname>
    And User will select the Radio Button
    When User clicks on save without entering the contents and verifies the error message
    ###And User uploads a file which is greater than 100MB <fileName> and verifies the error message
    And User uploads a file <fileName1>,clicks save button while uploading and verifies the error message
And User logout the form

    Examples: 
      | formname                                              | ratingSystem | fileName1     | fileName      |
      | Enhanced Refrigerant Management-calcRefrigerantImpact | O+M:EB       | 24MBfile1.doc | 102MBfile.pdf |
