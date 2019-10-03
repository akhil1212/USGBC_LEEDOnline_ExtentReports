$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Include/features/OM_ExistingBuildings/MinimumIndoorAirQuality.feature");
formatter.feature({
  "name": "Minimum Indoor Air Quality Form - LEED v4.1 O+M: EB",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@cucumberTags"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Filling Minimum Indoor Air Quality",
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
  "keyword": "When "
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
  "name": "User checks the checkbox option",
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
  "name": "User downloads the uploaded files and verifies",
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
        "Minimum Indoor Air Quality",
        "O+M:EB"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Filling Minimum Indoor Air Quality",
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
