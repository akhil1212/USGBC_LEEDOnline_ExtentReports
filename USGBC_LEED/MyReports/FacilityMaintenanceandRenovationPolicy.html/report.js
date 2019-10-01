$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Include/features/OM_ExistingBuildings/FacilityMaintenanceandRenovationPolicy.feature");
formatter.feature({
  "name": "Facility Maintenance and Renovation Policy Form - LEED v4.1 O+M: EB",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@cucumberTags"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Filling Facility Maintenance and Renovation Policy",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "name": "User clicks on project \u003cratingSystem\u003e positiveFlow",
  "keyword": "Given "
});
formatter.step({
  "name": "User navigates to the credits page of the project",
  "keyword": "And "
});
formatter.step({
  "name": "User should be on form \u003cformname\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "User verifies form version,credit name matches in scorecard and form page",
  "keyword": "And "
});
formatter.step({
  "name": "User uploads files to Add file button",
  "keyword": "And "
});
formatter.step({
  "name": "User verifies the uploaded files",
  "keyword": "And "
});
formatter.step({
  "name": "User Enters data to Narrative field and verifies",
  "keyword": "And "
});
formatter.step({
  "name": "User clicks on Save button",
  "keyword": "And "
});
formatter.step({
  "name": "User can able to see the form got saved",
  "keyword": "Then "
});
formatter.step({
  "name": "User verifies the revision icon present after saving the form",
  "keyword": "And "
});
formatter.step({
  "name": "User dowloads the generated pdf form",
  "keyword": "And "
});
formatter.step({
  "name": "User verifies the narrative from pdf and form page",
  "keyword": "And "
});
formatter.step({
  "name": "User verifies the uploaded files from pdf and form page",
  "keyword": "And "
});
formatter.step({
  "name": "User clicks the Complete icon to set status to Ready for Review",
  "keyword": "And "
});
formatter.step({
  "name": "User clicks on cancel while deleting the uploaded file and verifies the files are retained",
  "keyword": "And "
});
formatter.step({
  "name": "User deletes the uploaded files and verifies the files are deleted",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "formname",
        "ratingSystem"
      ]
    },
    {
      "cells": [
        "Facility Maintenance and Renovation Policy",
        "O+M:EB"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Filling Facility Maintenance and Renovation Policy",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@cucumberTags"
    },
    {
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "name": "User clicks on project O+M:EB positiveFlow",
  "keyword": "Given "
});
formatter.match({
  "location": "leedCommonStepDefnition.user_clicks_on_Project_positiveFlow(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to the credits page of the project",
  "keyword": "And "
});
formatter.match({
  "location": "leedCommonStepDefnition.user_navigates_to_the_credits_page_of_the_project()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be on form Facility Maintenance and Renovation Policy",
  "keyword": "And "
});
formatter.match({
  "location": "leedCommonStepDefnition.user_should_be_on_FRM_form(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verifies form version,credit name matches in scorecard and form page",
  "keyword": "And "
});
formatter.match({
  "location": "leedCommonStepDefnition.user_verifies_form_version_credit_name_matches_in_scorecard_and_form_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User uploads files to Add file button",
  "keyword": "And "
});
formatter.match({
  "location": "leedCommonStepDefnition.user_uploads_files_to_Add_file_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verifies the uploaded files",
  "keyword": "And "
});
formatter.match({
  "location": "leedCommonStepDefnition.user_verifies_the_uploaded_files()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Enters data to Narrative field and verifies",
  "keyword": "And "
});
formatter.match({
  "location": "leedCommonStepDefnition.user_enters_data_to_Narrative_field()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on Save button",
  "keyword": "And "
});
formatter.match({
  "location": "leedCommonStepDefnition.User_clicks_on_Save_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User can able to see the form got saved",
  "keyword": "Then "
});
formatter.match({
  "location": "leedCommonStepDefnition.user_can_able_to_see_the_form_got_saved()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verifies the revision icon present after saving the form",
  "keyword": "And "
});
formatter.match({
  "location": "leedCommonStepDefnition.user_verifies_the_revision_icon_present_after_saving_the_form()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User dowloads the generated pdf form",
  "keyword": "And "
});
formatter.match({
  "location": "leedCommonStepDefnition.user_verifies_the_PDF()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verifies the narrative from pdf and form page",
  "keyword": "And "
});
formatter.match({
  "location": "leedCommonStepDefnition.user_verifies_the_narraive_from_pdf()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verifies the uploaded files from pdf and form page",
  "keyword": "And "
});
formatter.match({
  "location": "leedCommonStepDefnition.user_verifies_the_uploaded_files_from_pdf_and_form_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks the Complete icon to set status to Ready for Review",
  "keyword": "And "
});
formatter.match({
  "location": "leedCommonStepDefnition.User_clicks_the_Complete_icon_to_set_status_to_Ready_for_Review()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on cancel while deleting the uploaded file and verifies the files are retained",
  "keyword": "And "
});
formatter.match({
  "location": "leedCommonStepDefnition.user_cancels_file_deleting_the_uploaded_file()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User deletes the uploaded files and verifies the files are deleted",
  "keyword": "And "
});
formatter.match({
  "location": "leedCommonStepDefnition.user_deletes_the_uploaded_files()"
});
formatter.result({
  "status": "passed"
});
});