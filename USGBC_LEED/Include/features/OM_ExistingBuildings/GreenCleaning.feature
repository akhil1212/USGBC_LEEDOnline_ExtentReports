#---------------------------------------------------------------------------------------------------------------------------------
# Authors : Saravana Sabareesh V                                       Reviewed By: Dinesh Kumar
# Date : 25/07/2019 Reviewed On: 13/08/2019
# Last Updated By:
# Last Updated On:
# Feature Name: Green Cleaning Form - LEED v4.1 O+M: EB
# Feature Description: Filling all the fields of the form, checking the autosave functionality and negative cases for the form
#---------------------------------------------------------------------------------------------------------------------------------
@cucumberTags
Feature: Green Cleaning Form - LEED v4.1 O+M: EB

  #Scenario-1
  @SmokeTest
  Scenario Outline: Filling Green Cleaning form for Custodial effectiveness assessment
    Given User clicks on project <formname> and <ratingSystem>
    And User navigates to the credits page of the project
    And User should be on form <formname>
    And User verifies form version,credit name matches in scorecard and form page
    And User will select the Radio Button
    And User verifies form draft is saved automatically after 10 sec complete by selecting radio button
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    And User uploads files to Add file button and verifies form is not saved as draft
    And User verifies Auto save after entering text box with number
    And User verifies form draft is saved automatically after 10 sec by entering the date field
    When User clicks on Save button
    And User can able to see the form got saved
    When User verifies the revision icon present after saving the form
    And User dowloads the generated pdf form
    And User verifies the uploaded files from pdf and form page
    And User verifies the narrative from pdf and form page
    And User verifies text with pdf and form page
    And User downloads the uploaded files and verifies
    And User clicks on cancel while deleting the uploaded file and verifies the files are retained
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    Then User logout and login to the form <formname> and rating <ratingSystem>
    And User verifies warning message of form saved as draft is present and draft not changed
    And User clicks on clear draft and verifies the draft is not present
    And User deletes the uploaded files and verifies the files are deleted
    And User enters data with decimal value to text box with number and verifies the value present is not same
    And User verifies Number formatting in text box with number
    And User enters data to text box with number and verifies the value present is not same
    And User clicks on save without entering the contents and verifies the error message
     ###And User uploads a file which is greater than 100MB <fileName> and verifies the error message
    And User uploads a file <fileName1>,clicks save button while uploading and verifies the error message
    And User logout the form

    Examples: 
      | formname                                        | ratingSystem | fileName1     | fileName      |
      | Green Cleaning-CustodialEffectivenessAssessment | O+M:EB       | 24MBfile1.doc | 102MBfile.pdf |

  #Scenario-2
  @SmokeTest
  Scenario Outline: Filling Green Cleaning form for EntrywaySystems
    Given User clicks on project <formname> and <ratingSystem>
    And User navigates to the credits page of the project
    And User should be on form <formname>
    And User verifies form version,credit name matches in scorecard and form page
    And User will select the Radio Button
    And User verifies form draft is saved automatically after 10 sec complete by selecting radio button
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
    And User clicks on save without entering the contents and verifies the error message
     ###And User uploads a file which is greater than 100MB <fileName> and verifies the error message
    And User uploads a file <fileName1>,clicks save button while uploading and verifies the error message
    And User logout the form

    Examples: 
      | formname                       | ratingSystem | fileName1     | fileName      |
      | Green Cleaning-EntrywaySystems | O+M:EB       | 24MBfile1.doc | 102MBfile.pdf |

  #Scenario-3
  @SmokeTest
  Scenario Outline: Filling Green Cleaning form for PoweredCleaningEquipment
    Given User clicks on project <formname> and <ratingSystem>
    And User navigates to the credits page of the project
    And User should be on form <formname>
    And User verifies form version,credit name matches in scorecard and form page
    And User will select the Radio Button
    And User verifies form draft is saved automatically after 10 sec complete by selecting radio button
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    And User uploads files to Add file button and verifies form is not saved as draft
    And User verifies Auto save after entering text box with number
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
     ###And User uploads a file which is greater than 100MB <fileName> and verifies the error message
    And User uploads a file <fileName1>,clicks save button while uploading and verifies the error message
    And User logout the form

    Examples: 
      | formname                                | ratingSystem | fileName1     | fileName      |
      | Green Cleaning-PoweredCleaningEquipment | O+M:EB       | 24MBfile1.doc | 102MBfile.pdf |

  #Scenario-4
  @SmokeTest
  Scenario Outline: Filling Green Cleaning form for CleaningProductsAndMaterials
    Given User clicks on project <formname> and <ratingSystem>
    And User navigates to the credits page of the project
    And User should be on form <formname>
    And User verifies form version,credit name matches in scorecard and form page
    And User will select the Radio Button
    And User verifies form draft is saved automatically after 10 sec complete by selecting radio button
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    And User uploads files to Add file button and verifies form is not saved as draft
    And User verifies Auto save after entering text box with number
    And User verifies form draft is saved automatically after 10 sec complete after changing dropdown option <optionValue>
    When User clicks on Save button
    And User can able to see the form got saved
    And User verifies the revision icon present after saving the form
    And User dowloads the generated pdf form
    And User verifies the uploaded files from pdf and form page
    And User verifies the narrative from pdf and form page
    And User downloads the uploaded files and verifies
    And User verifies text with pdf and form page
    And User verifies the dropdown value with pdf and form page
    And User clicks on cancel while deleting the uploaded file and verifies the files are retained
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    Then User logout and login to the form <formname> and rating <ratingSystem>
    And User verifies warning message of form saved as draft is present and draft not changed
    And User clicks on clear draft and verifies the draft is not present
    And User deletes the uploaded files and verifies the files are deleted
    And User enters data with decimal value to text box with number and verifies the value present is not same
    And User verifies Number formatting in text box with number
    And User enters data to text box with number and verifies the value present is not same
    And User clicks on save without entering the contents and verifies the error message
     ###And User uploads a file which is greater than 100MB <fileName> and verifies the error message
    And User uploads a file <fileName1>,clicks save button while uploading and verifies the error message
    And User logout the form

    Examples: 
      | formname                                    | ratingSystem | optionValue | fileName1     | fileName      |
      | Green Cleaning-CleaningProductsAndMaterials | O+M:EB       | Inventory   | 24MBfile1.doc | 102MBfile.pdf |
