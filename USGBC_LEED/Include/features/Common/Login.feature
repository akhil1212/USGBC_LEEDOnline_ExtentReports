#---------------------------------------------------------------------------------------------------------------------------------
# Authors : Saravana Sabareesh V						  																											Reviewed By: Dinesh Kumar                                                      
# Date   :   23/07/2019                                                                             Reviewed On: 13/08/2019                                                        
# Last Updated By:
# Last Updated On:
# Feature Name: Login to USGBC Leed Online Page 
# Feature Description: Login to the USGBC LEED online website with the username and password
#---------------------------------------------------------------------------------------------------------------------------------
@FunctionalTest
Feature: Login to USGBC Leed Online Page

  #Scenario-1
  @SmokeTest
  Scenario: User will login to leed online and navigate to credit page
    Given User has to navigate to leed online home page
    And User enters the username and password
    And User has to accept end user license agreement
    When User clicks on LOG IN button
    Then User will be logged in successfully