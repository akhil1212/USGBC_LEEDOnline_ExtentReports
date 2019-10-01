
#---------------------------------------------------------------------------------------------------------------------------------
# Authors : Saravana Sabareesh V     																																Reviewed By: Dinesh Kumar                                                      
# Date   :   29/07/2019                                                                             Reviewed On: 13/08/2019                                                        
# Last Updated By:
# Last Updated On:
# Feature Name: Purchasing Form - LEED v4.1 O+M: EB
# Feature Description: Filling all the fields of the form, checking the autosave functionality and negative cases for the form
#---------------------------------------------------------------------------------------------------------------------------------
@cucumberTags
Feature: Purchasing Form - LEED v4.1 O+M: EB

  #Scenario-1
  @SmokeTest
  Scenario Outline: Filling Purchasing form for Ongoing consumables
    Given User clicks on project <ratingSystem> positiveFlow
    And User navigates to the credits page of the project
    And User should be on form <formname>
    When User will select the Radio Button
    And User verifies form version,credit name matches in scorecard and form page
    And User uploads files to Add file button
    And User verifies the uploaded files
    And User enters data to text box with number and verifies
    And User Enters data to Narrative field and verifies
    And User clicks on Save button
    Then User can able to see the form got saved
    And User verifies the revision icon present after saving the form
    And User dowloads the generated pdf form
    And User verifies the uploaded files from pdf and form page
    And User verifies the narrative from pdf and form page
    And User clicks the Complete icon to set status to Ready for Review
    And User downloads the uploaded files and verifies
    And User clicks on cancel while deleting the uploaded file and verifies the files are retained
    And User deletes the uploaded files and verifies the files are deleted

    Examples: 
      | formname                      | ratingSystem |
      | Purchasing-ongoingConsumables | O+M:EB       |

  #Scenario-2
  @SmokeTest
  Scenario Outline: Filling Purchasing form for Building Products Materials
    Given User clicks on project <ratingSystem> positiveFlow
    And User navigates to the credits page of the project
    And User should be on form <formname>
    When User will select the Radio Button
    And User verifies form version,credit name matches in scorecard and form page
    And User uploads files to Add file button
    And User verifies the uploaded files
    And User enters data to text box with number and verifies
    And User Enters data to Narrative field and verifies
    And User clicks on Save button
    Then User can able to see the form got saved
    And User verifies the revision icon present after saving the form
    And User dowloads the generated pdf form
    And User verifies the uploaded files from pdf and form page
    And User verifies the narrative from pdf and form page
    And User clicks the Complete icon to set status to Ready for Review
    And User downloads the uploaded files and verifies
    And User clicks on cancel while deleting the uploaded file and verifies the files are retained
    And User deletes the uploaded files and verifies the files are deleted

    Examples: 
      | formname                             | ratingSystem |
      | Purchasing-buildingProductsMaterials | O+M:EB       |

  #Scenario-3
  @SmokeTest
  Scenario Outline: Filling Purchasing form for Electric Equipments
    Given User clicks on project <ratingSystem> positiveFlow
    And User navigates to the credits page of the project
    And User should be on form <formname>
    When User will select the Radio Button
    And User verifies form version,credit name matches in scorecard and form page
    And User checks the checkbox option
    And User uploads files to Add file button
    And User verifies the uploaded files
    And User enters data to text box with number and verifies
    And User Enters data to Narrative field and verifies
    And User clicks on Save button
    Then User can able to see the form got saved
    And User verifies the revision icon present after saving the form
    And User dowloads the generated pdf form
    And User verifies the uploaded files from pdf and form page
    And User verifies the narrative from pdf and form page
    And User clicks the Complete icon to set status to Ready for Review
    And User downloads the uploaded files and verifies
    And User clicks on cancel while deleting the uploaded file and verifies the files are retained
    And User deletes the uploaded files and verifies the files are deleted

    Examples: 
      | formname                      | ratingSystem |
      | Purchasing-electricEquipments | O+M:EB       |

  #Scenario-4
  @SmokeTest
  Scenario Outline: Filling Purchasing form for Food and Beverage
    Given User clicks on project <ratingSystem> positiveFlow
    And User navigates to the credits page of the project
    And User should be on form <formname>
    When User will select the Radio Button
    And User verifies form version,credit name matches in scorecard and form page
    And User uploads files to Add file button
    And User verifies the uploaded files
    And User enters data to text box with number and verifies
    And User Enters data to Narrative field and verifies
    And User clicks on Save button
    Then User can able to see the form got saved
    And User verifies the revision icon present after saving the form
    And User dowloads the generated pdf form
    And User verifies the uploaded files from pdf and form page
    And User verifies the narrative from pdf and form page
    And User clicks the Complete icon to set status to Ready for Review
    And User downloads the uploaded files and verifies
    And User clicks on cancel while deleting the uploaded file and verifies the files are retained
    And User deletes the uploaded files and verifies the files are deleted

    Examples: 
      | formname                   | ratingSystem |
      | Purchasing-foodAndBeverage | O+M:EB       |

  #Scenario-5
  @SmokeTest
  Scenario Outline: Checking Auto Save functionality in Purchasing form for Ongoing consumables
    Given User clicks on project <ratingSystem> AutoSave
    And User navigates to the credits page of the project
    And User should be on form <formname>
    And User will select the Radio Button
    And User verifies form draft is saved automatically after 10 sec complete by selecting radio button
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    And User will not make any changes in the form and verifies form is not saved as draft
    And User uploads files to Add file button and verifies form is not saved as draft
    And User verifies Auto save after entering text box with number
    And User logout and login to the form <formname> and rating <ratingSystem>
    And User verifies warning message of form saved as draft is present and draft not changed
    Then User clicks on Save button and deletes the uploaded files
    And User verifies clear draft,warning message is not present
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    And User clicks on clear draft and verifies the draft is not present

    Examples: 
      | formname                      | ratingSystem |
      | Purchasing-ongoingConsumables | O+M:EB       |

  #Scenario-6
  @SmokeTest
  Scenario Outline: Checking Auto Save functionality in Purchasing form for Building Products Materials
    Given User clicks on project <ratingSystem> AutoSave
    And User navigates to the credits page of the project
    And User should be on form <formname>
    And User will select the Radio Button
    And User verifies form draft is saved automatically after 10 sec complete by selecting radio button
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    And User will not make any changes in the form and verifies form is not saved as draft
    And User uploads files to Add file button and verifies form is not saved as draft
    And User verifies Auto save after entering text box with number
    And User logout and login to the form <formname> and rating <ratingSystem>
    And User verifies warning message of form saved as draft is present and draft not changed
    Then User clicks on Save button and deletes the uploaded files
    And User verifies clear draft,warning message is not present
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    And User clicks on clear draft and verifies the draft is not present

    Examples: 
      | formname                             | ratingSystem |
      | Purchasing-buildingProductsMaterials | O+M:EB       |

  #Scenario-7
  @SmokeTest
  Scenario Outline: Checking Auto Save functionality in Purchasing form for Electric Equipments
    Given User clicks on project <ratingSystem> AutoSave
    And User navigates to the credits page of the project
    And User should be on form <formname>
    And User will select the Radio Button
    And User verifies form draft is saved automatically after 10 sec complete by selecting radio button
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    And User will not make any changes in the form and verifies form is not saved as draft
    And User uploads files to Add file button and verifies form is not saved as draft
    And User verifies Auto save after entering text box with number
    And User checks the checkbox option and verifies form draft is saved automatically after 10 sec complete
    And User logout and login to the form <formname> and rating <ratingSystem>
    And User verifies warning message of form saved as draft is present and draft not changed
    Then User clicks on Save button and deletes the uploaded files
    And User verifies clear draft,warning message is not present
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    And User clicks on clear draft and verifies the draft is not present

    Examples: 
      | formname                      | ratingSystem |
      | Purchasing-electricEquipments | O+M:EB       |

  #Scenario-8
  @SmokeTest
  Scenario Outline: Checking Auto Save functionality in Purchasing form for Food and Beverage
    Given User clicks on project <ratingSystem> AutoSave
    And User navigates to the credits page of the project
    And User should be on form <formname>
    And User will select the Radio Button
    And User verifies form draft is saved automatically after 10 sec complete by selecting radio button
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    And User will not make any changes in the form and verifies form is not saved as draft
    And User uploads files to Add file button and verifies form is not saved as draft
    And User verifies Auto save after entering text box with number
    And User logout and login to the form <formname> and rating <ratingSystem>
    And User verifies warning message of form saved as draft is present and draft not changed
    Then User clicks on Save button and deletes the uploaded files
    And User verifies clear draft,warning message is not present
    And User verifies form draft is saved automatically after 10 sec complete by filling the Narrative
    And User clicks on clear draft and verifies the draft is not present

    Examples: 
      | formname                   | ratingSystem |
      | Purchasing-foodAndBeverage | O+M:EB       |

  #Scenario-9
  @NegativeTest
  Scenario Outline: Negative scenario for Purchasing form for Ongoing consumables
    Given User clicks on project <ratingSystem> Negative
    And User navigates to the credits page of the project
    And User should be on form <formname>
    And User will select the Radio Button
    When User clicks on save without entering the contents and verifies the error message
    And User enters data with decimal value to text box with number and verifies the value present is not same
    And User verifies Number formatting in text box with number
    And User enters data to text box with number and verifies the value present is not same
    ###And User uploads a file which is greater than 100MB <fileName> and verifies the error message
    And User uploads a file <fileName1>,clicks save button while uploading and verifies the error message

    Examples: 
      | formname                      | ratingSystem | fileName1     | fileName      |
      | Purchasing-ongoingConsumables | O+M:EB       | 24MBfile1.doc | 102MBfile.pdf |

  #Scenario-10
  @NegativeTest
  Scenario Outline: Negative scenario for Purchasing form for Building Products Materials
    Given User clicks on project <ratingSystem> Negative
    And User navigates to the credits page of the project
    And User should be on form <formname>
    When User will select the Radio Button
    When User clicks on save without entering the contents and verifies the error message
    And User enters data with decimal value to text box with number and verifies the value present is not same
    And User verifies Number formatting in text box with number
    And User enters data to text box with number and verifies the value present is not same
   	###And User uploads a file which is greater than 100MB <fileName> and verifies the error message
    And User uploads a file <fileName1>,clicks save button while uploading and verifies the error message

    Examples: 
      | formname                             | ratingSystem | fileName1     | fileName      |
      | Purchasing-buildingProductsMaterials | O+M:EB       | 24MBfile1.doc | 102MBfile.pdf |

  #Scenario-11
  @NegativeTest
  Scenario Outline: Negative scenario for Purchasing form for Electric Equipments
    Given User clicks on project <ratingSystem> Negative
    And User navigates to the credits page of the project
    And User should be on form <formname>
    When User will select the Radio Button
    When User clicks on save without entering the contents and verifies the error message
    And User enters data with decimal value to text box with number and verifies the value present is not same
    And User verifies Number formatting in text box with number
    And User enters data to text box with number and verifies the value present is not same
    ###And User uploads a file which is greater than 100MB <fileName> and verifies the error message
    And User uploads a file <fileName1>,clicks save button while uploading and verifies the error message

    Examples: 
      | formname                      | ratingSystem | fileName1     | fileName      |
      | Purchasing-electricEquipments | O+M:EB       | 24MBfile1.doc | 102MBfile.pdf |

  #Scenario-12
  @NegativeTest
  Scenario Outline: Negative scenario for Purchasing form for Food and Beverage
    Given User clicks on project <ratingSystem> Negative
    And User navigates to the credits page of the project
    And User should be on form <formname>
    When User will select the Radio Button
    When User clicks on save without entering the contents and verifies the error message
    And User enters data with decimal value to text box with number and verifies the value present is not same
    And User verifies Number formatting in text box with number
    And User enters data to text box with number and verifies the value present is not same
    ###And User uploads a file which is greater than 100MB <fileName> and verifies the error message
    And User uploads a file <fileName1>,clicks save button while uploading and verifies the error message

    Examples: 
      | formname                   | ratingSystem | fileName1     | fileName      |
      | Purchasing-foodAndBeverage | O+M:EB       | 24MBfile1.doc | 102MBfile.pdf |
