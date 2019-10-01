#---------------------------------------------------------------------------------------------------------------------------------
# Authors : Gelli Akhil						  																																Reviewed By: Dinesh Kumar                                                      
# Date   :   29/07/2019                                                                             Reviewed On: 13/08/2019                                                        
# Last Updated By:
# Last Updated On:
# Feature Name: Site Management Form - LEED v4.1 O+M: EB
# Feature Description: Filling all the fields of the form, checking the autosave functionality and negative cases for the form
#---------------------------------------------------------------------------------------------------------------------------------
@cucumberTags
Feature: Site Management Form - LEED v4.1 O+M: EB

  #Scenario-1
  @SmokeTest
  Scenario Outline: Filling Project Information form
    Given User clicks on project <ratingSystem> positiveFlow
    And User navigates to the credits page of the project
    And User should be on form <formname>
    When User uploads files to Add file button
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
    Examples: 
      | formname        | ratingSystem |
      | Site Management | O+M:EB       |

  #Scenario-2
  @SmokeTest
  Scenario Outline: Checking Auto Save functionality in Site Management form
    Given User clicks on project <ratingSystem> AutoSave
    And User navigates to the credits page of the project
    And User should be on form <formname>
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    And User will not make any changes in the form and verifies form is not saved as draft
    And User uploads files to Add file button and verifies form is not saved as draft
    And User logout and login to the form <formname> and rating <ratingSystem>
    And User verifies warning message of form saved as draft is present and draft not changed
    Then User clicks on Save button and deletes the uploaded files
    And User verifies clear draft,warning message is not present
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    And User clicks on clear draft and verifies the draft is not present
   
    Examples: 
      | formname        | ratingSystem |
      | Site Management | O+M:EB       |

  #Scenario-3
  @NegativeTest
  Scenario Outline: Negative scenario for Site Management form
    Given User clicks on project <ratingSystem> Negative
    And User navigates to the credits page of the project
    And User should be on form <formname>
    When User clicks on save without entering the contents and verifies the error message
    ###And User uploads a file which is greater than 100MB <fileName> and verifies the error message
    And User uploads a file <fileName1>,clicks save button while uploading and verifies the error message

    Examples: 
      | formname        | ratingSystem | fileName1     | fileName      |
      | Site Management | O+M:EB       | 24MBfile1.doc | 102MBfile.pdf |
