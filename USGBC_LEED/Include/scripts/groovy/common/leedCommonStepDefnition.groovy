import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatterBuilder.InstantPrinterParser

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import projectKeywords.LeedOnlineKeywords
import common.entities
import common.commonReports

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.HttpCommandExecutor
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.remote.SessionId
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.LogStatus;
import com.aventstack.extentreports.gherkin.model.Scenario
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.annotation.JsonFormat.Feature
import com.aventstack.extentreports.GherkinKeyword
import common.commonReports;

/*
 * ******************************************************************************************************************************
 * Authors : Saravana Sabareesh V & Gelli Akhil
 * Date   :   31/07/2019
 * Last Updated By: Saravana Sabareesh V
 * Last Updated On : 13/08/2019
 * Reviewed By: Dinesh Kumar
 * Reviewed On: 14/08/2019
 * ******************************************************************************************************************************
 */

class leedCommonStepDefnition {
	ExtentTest loginfo;
	ExtentReports extent = commonReports.extent;
	int rowNum
	String nameOfTheForm
	static String scoreCardFormName
	String	prjName
	String browserName = ""

	@Given("User clicks on project (.*) positiveFlow")
	public void user_clicks_on_Project_positiveFlow(String project) {

		try{
			WebUI.callTestCase(findTestCase("Test Cases/TC_Login"), null)

			if (project == "O+M:EB"){
				prjName = GlobalVariable.O_M_EB
			}

			TestObject projectName = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.projectName+prjName+"']")
			WebUI.click(projectName)

			loginfo= extent.createTest(Feature.class,GlobalVariable.currentTestCaseId);
			loginfo=loginfo.createNode(Scenario.class," leed online"+GlobalVariable.currentTestCaseId);

			loginfo.createNode(new GherkinKeyword("Given"), "User clicks on project").pass("pass");
			Assert.assertTrue(true);
			loginfo.assignCategory(GlobalVariable.currentTestCaseId+"Form")

		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("Given"), "User clicks on project").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	@Given("User clicks on project (.*) AutoSave")
	public void user_clicks_on_Project_AutoSave(String project) {

		try{
			WebUI.callTestCase(findTestCase("Test Cases/TC_Login"), null)

			if (project == "O+M:EB"){
				prjName = GlobalVariable.O_M_EB
			}

			TestObject projectName = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.projectName+prjName+"']")
			WebUI.click(projectName)

			loginfo.createNode(new GherkinKeyword("Given"), "User clicks on project").pass("pass");

		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("Given"), "User clicks on project").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	@Given("User clicks on project (.*) Negative")
	public void user_clicks_on_Project_Negative(String project) {

		try{
			WebUI.callTestCase(findTestCase("Test Cases/TC_Login"), null)

			if (project == "O+M:EB"){
				prjName = GlobalVariable.O_M_EB
			}

			TestObject projectName = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.projectName+prjName+"']")
			WebUI.click(projectName)

			loginfo.createNode(new GherkinKeyword("Given"), "User clicks on project").pass("pass");
			Assert.assertTrue(true);

		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("Given"), "User clicks on project").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}
	@And("User navigates to the credits page of the project")
	public void user_navigates_to_the_credits_page_of_the_project() {
		try{
			TestObject creditsBtn = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.creditsBtn)
			WebUI.click(creditsBtn)
			loginfo.createNode(new GherkinKeyword("And"), "User navigates to the credits page of the project").pass("pass");
			Assert.assertTrue(true);
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User navigates to the credits page of the project").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}



	@And("User should be on form (.*)")
	public void user_should_be_on_FRM_form(String creditFormName) {
		try{

			println creditFormName
			int formRow = new LeedOnlineKeywords().getRowNumberOfFormFromExcel(creditFormName)
			rowNum = formRow

			println rowNum

			String formName = findTestData("Data Files/TD_FormElements").getValue("Form Name", rowNum)

			nameOfTheForm =formName

			String formStatus = entities.scoreCardStatusPrefix+formName+entities.scoreCardStatusSuffix

			TestObject formStatusObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,formStatus,true)

			String scoreCardStatus = WebUI.getText(formStatusObj)

			println "The form Status is "+scoreCardStatus

			if(scoreCardStatus == "READY FOR REVIEW"){

				new LeedOnlineKeywords().markAsComplete(formName)
			}

			WebUI.delay(3)
			scoreCardFormName = new LeedOnlineKeywords().navigateToForm(formName)
			WebUI.delay(5)

			String stringToSplit = findTestData("Data Files/TD_FormElements").getValue("Form Name with option", rowNum)
			loginfo.createNode(new GherkinKeyword("And"), "User navigates to the credits page of the project").pass("pass");
			Assert.assertTrue(true);
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User navigates to the credits page of the project").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	/* Verify the form version (v01) and 
	 * Verify the credit name matches in score card and form page */

	@And("User verifies form version,credit name matches in scorecard and form page")
	public void user_verifies_form_version_credit_name_matches_in_scorecard_and_form_page(){
		try{
			TestObject formTitleObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.projectTitle,true)

			String formTitle = WebUI.getText(formTitleObj)

			println "The form Title is "+formTitle

			WebUI.verifyMatch(scoreCardFormName, formTitle, false)

			boolean isVersion = WebUI.verifyTextPresent("(V01)", false)

			println "Is version v01 present "+isVersion
			//			logger = extent.startTest(GlobalVariable.currentTestCaseId);
			//			Assert.assertTrue(true);
			//
			//			browserName = new LeedOnlineKeywords().getBrowserName()
			//
			//			logger.assignCategory(GlobalVariable.currentTestCaseId+" - "+browserName);
			loginfo.createNode(new GherkinKeyword("And"), "User navigates to the credits page of the project").pass("pass");
			Assert.assertTrue(true);
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User navigates to the credits page of the project").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	/*
	 * Verify to upload one file at a times
	 */

	@When("User uploads files to Add file button")
	public void user_uploads_files_to_Add_file_button() {
		try{
			println rowNum
			String totalAddFileCount = findTestData("Data Files/TD_FormElements").getValue("Add File", rowNum)

			println "Number of Add files "+totalAddFileCount
			int totalNumberofAddFiles = Integer.parseInt(totalAddFileCount)

			println "Total AddFile Count "+totalNumberofAddFiles

			for(int i=1;i<=totalNumberofAddFiles;i++){

				new LeedOnlineKeywords().uploadFilesToAddfile(i)
				WebUI.delay(3)
			}
			loginfo.createNode(new GherkinKeyword("When"), "User uploads files to Add file button").pass("pass");
			Assert.assertTrue(true);
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("When"), "User uploads files to Add file button").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}



	@And("User Enters data to Narrative field and verifies")
	public void user_enters_data_to_Narrative_field(){
		try{
			println rowNum

			String randomString = new LeedOnlineKeywords().generateRandomString(5)
			String narrativeContent = findTestData("Data Files/TD_TestDataPositiveFlow").getValue("Narrative", 1)
			String data = narrativeContent+randomString

			String totalNarrativeCount = findTestData("Data Files/TD_FormElements").getValue("Narrative", rowNum)
			println "Number of Narrative "+totalNarrativeCount
			int totalNumberOfNarratives = Integer.parseInt(totalNarrativeCount)

			for(int i=1;i<=totalNumberOfNarratives;i++){
				String narrativePath = entities.narrative+'['+i+']'
				new LeedOnlineKeywords().fillingNarrative(narrativePath,data)
			}
			loginfo.createNode(new GherkinKeyword("And"), "User Enters data to Narrative field and verifies").pass("pass");
			Assert.assertTrue(true);
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User Enters data to Narrative field and verifies").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	/*
	 * Verify check boxes and radio button working properly.
	 */

	@And("User will select the Radio Button")
	public void User_will_select_the_Radio_Button(){
		try{
			println rowNum

			String optionValue
			String stringToSplit = findTestData("Data Files/TD_FormElements").getValue("Form Name with option", rowNum)

			if(stringToSplit.contains("!R")){

				String checkBoxVal = findTestData("Data Files/TD_FormElements").getValue("Checkbox Value", rowNum)

				String optionalCheckboxXpath =  new LeedOnlineKeywords().getXpathForCheckBox(checkBoxVal,"option")+"[1]"

				println "Checkbox to be unchecked "+optionalCheckboxXpath

				new LeedOnlineKeywords().isChecked(optionalCheckboxXpath)
			}

			if(stringToSplit.contains("!R")){

				String[] form_name = stringToSplit.split("!R")
				optionValue = form_name[0].substring(form_name[0].lastIndexOf("-")+1)
			}

			else{

				optionValue = stringToSplit.substring(stringToSplit.lastIndexOf("-")+1)
			}

			println "The option Value "+optionValue

			String optionXpath = entities.radioButton+"[@value='"+optionValue+"'] | "+entities.radioButton1+"@value='"+optionValue+"']"

			TestObject radioButton = new TestObject().addProperty('xpath',ConditionType.EQUALS,optionXpath,true)
			println "The xpath is "+optionXpath

			new LeedOnlineKeywords().selectRadioButton(radioButton)

			String radioButtonCount = findTestData("Data Files/TD_FormElements").getValue("Radio Button", rowNum)

			int totalRadioButtonCount = Integer.parseInt(radioButtonCount)

			if(totalRadioButtonCount>0){

				for(int i=1;i<=totalRadioButtonCount;i++){

					String radioBtnXpath = entities.radioOptions+"["+i+"]"
					TestObject radioBtn = new TestObject().addProperty('xpath',ConditionType.EQUALS,radioBtnXpath,true)
					new LeedOnlineKeywords().selectRadioButton(radioBtn)
				}
			}
			loginfo.createNode(new GherkinKeyword("And"), "User will select the Radio Button").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User will select the Radio Button").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}




	@And("User enters data to text box and verifies")
	public void user_enters_data_to_text_box(){
		try{
			String textBoxCount = findTestData("Data Files/TD_FormElements").getValue("Text Box", rowNum)

			println "Total number of Text boxes "+textBoxCount
			int totalNumberOfTextBoxes = Integer.parseInt(textBoxCount)
			String textValue = findTestData("Data Files/TD_TestDataPositiveFlow").getValue("Text Box", 1)
			for(int i=1;i<=totalNumberOfTextBoxes;i++){
				TestObject textBoxXpath =  new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.textMedium+'['+i+']',true)
				new LeedOnlineKeywords().enterTextBoxData(textBoxXpath,textValue)
			}
			loginfo.createNode(new GherkinKeyword("And"), "User enters data to text box and verifies").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User enters data to text box and verifies").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	/*
	 * Verify check boxes and radio button working properly.
	 */

	@And("User checks the checkbox option")
	public void user_checks_the_checkbox_option(){
		try{
			String checkBoxValue = findTestData("Data Files/TD_FormElements").getValue("Checkbox Value", rowNum)

			println "The form Name "+checkBoxValue

			String stringToSplit = findTestData("Data Files/TD_FormElements").getValue("Form Name with option", rowNum)

			//To check check boxes apart from the optional check box

			if(stringToSplit.contains("!R")){
				String checkBoxCount = findTestData("Data Files/TD_FormElements").getValue("Checkbox", rowNum)

				int totalCheckBoxes = Integer.parseInt(checkBoxCount)

				if(totalCheckBoxes>0){

					for(int i=1;i<=totalCheckBoxes;i++){
						String fieldCheckBoxPath = new LeedOnlineKeywords().getXpathForCheckBox(checkBoxValue,"")+"["+i+"]"

						TestObject fieldCheckBoxObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,fieldCheckBoxPath,true)
						new LeedOnlineKeywords().selectCheckBox(fieldCheckBoxObj)
					}

				}

			}


			else if(checkBoxValue!='' && stringToSplit.contains("!C")){

				String checkBoxXpath =  new LeedOnlineKeywords().getXpathForCheckBox(checkBoxValue,"option")
				TestObject checkBoxObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,checkBoxXpath,true)
				new LeedOnlineKeywords().selectCheckBox(checkBoxObj)
				String checkBoxCount = findTestData("Data Files/TD_FormElements").getValue("Checkbox", rowNum)
				int totalCheckBoxes = Integer.parseInt(checkBoxCount)

				if(totalCheckBoxes>0){

					for(int i=1;i<=totalCheckBoxes;i++){

						String fieldCheckBoxPath = new LeedOnlineKeywords().getXpathForCheckBox(checkBoxValue,"")+"["+i+"]"
						TestObject fieldCheckBoxObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,fieldCheckBoxPath,true)
						new LeedOnlineKeywords().selectCheckBox(fieldCheckBoxObj)
					}

				}
			}

			else{

				String checkBoxCount = findTestData("Data Files/TD_FormElements").getValue("Checkbox", rowNum)
				int length = Integer.parseInt(checkBoxCount)
				String chkBoxValue = ""

				if(length>0){

					for(int i=1;i<=length;i++){
						String fieldCheckBoxPath = new LeedOnlineKeywords().getXpathForCheckBox(chkBoxValue,"")+"["+i+"]"
						TestObject fieldCheckBoxObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,fieldCheckBoxPath,true)
						new LeedOnlineKeywords().selectCheckBox(fieldCheckBoxObj)
					}

				}

			}
			loginfo.createNode(new GherkinKeyword("And"), "User checks the checkbox option").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User checks the checkbox option").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}



	@And("User enters data to text box with number and verifies")
	public void user_enters_data_to_text_box_with_number(){
		try{
			String textBoxNumberCount = findTestData("Data Files/TD_FormElements").getValue("Text Box for Numbers", rowNum)
			String numberToEnter = findTestData("Data Files/TD_TestDataPositiveFlow").getValue("Number Text Box", 1)
			int totalNumberOfTextBoxes=Integer.parseInt(textBoxNumberCount)

			for(int i=1;i<=totalNumberOfTextBoxes;i++){
				TestObject numberTextBox = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.textRtl+'['+i+']',true)
				new LeedOnlineKeywords().enterDataToNumericTextbox(numberTextBox,numberToEnter)
			}
			loginfo.createNode(new GherkinKeyword("And"), "User enters data to text box with number and verifies").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User enters data to text box with number and verifies").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	/*
	 * Verify the add and delete button by adding an deleting the rows in the table.
	 */

	@And("User fills the table (.*) with data (.*) isAddRow (.*) and verifies")
	public void user_fills_the_table(String table, String data, String isAddRow){
		try{
			new LeedOnlineKeywords().enterDataToTable(table, data, isAddRow)
			loginfo.createNode(new GherkinKeyword("And"), "User fills the table with data isAddRow and verifies").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User fills the table with data isAddRow and verifies").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify the forms data saving on click of save button.
	 */
	@And("User clicks on Save button")
	public void User_clicks_on_Save_button() {
		try{
			new LeedOnlineKeywords().clickSaveButton()
			WebUI.delay(4)
			loginfo.createNode(new GherkinKeyword("And"), "User clicks on Save button").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User clicks on Save button").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	/*
	 * Verify message 'Form data saved successfully' displays after save button clicked
	 */
	@Then("User can able to see the form got saved")
	public void user_can_able_to_see_the_form_got_saved(){
		try{
			WebUI.verifyTextPresent("Form data saved successfully.", false)

			WebUI.delay(6)
			loginfo.createNode(new GherkinKeyword("And"), "User can able to see the form got saved").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User can able to see the form got saved").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify user is able to download the uploaded files
	 */
	@And("User downloads the uploaded files and verifies")
	public void user_downloads_the_uploaded_files(){
		try{
			String addFileCount = findTestData("Data Files/TD_FormElements").getValue("Add File", rowNum)

			int totalNumberOfAddFiles = Integer.parseInt(addFileCount)

			for(int i=1;i<=totalNumberOfAddFiles;i++){

				new LeedOnlineKeywords().downloadTheUploadedFiles(i)

			}
			loginfo.createNode(new GherkinKeyword("And"), "User downloads the uploaded files and verifies").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User downloads the uploaded files and verifies").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify selected file upload should be delete if user clicks on ''Yes'
	 */
	@And("User deletes the uploaded files and verifies the files are deleted")
	public void user_deletes_the_uploaded_files(){
		try{
			String addFileCount = findTestData("Data Files/TD_FormElements").getValue("Add File", rowNum)

			int totalNumberOfAddFiles = Integer.parseInt(addFileCount)

			for(int i=totalNumberOfAddFiles;i>=1;i--){

				new LeedOnlineKeywords().deleteUploadedFiles(i)
			}
			loginfo.createNode(new GherkinKeyword("And"), "User deletes the uploaded files and verifies the files are deleted").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User deletes the uploaded files and verifies the files are deleted").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	@And("User clicks the Complete icon to set status to Ready for Review")
	public void User_clicks_the_Complete_icon_to_set_status_to_Ready_for_Review(){
		try{
			WebUI.back()
			WebUI.delay(2)

			new LeedOnlineKeywords().markAsComplete(nameOfTheForm)

			WebUI.delay(2)
			WebUI.forward()
			loginfo.createNode(new GherkinKeyword("And"), "User clicks the Complete icon to set status to Ready for Review").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User clicks the Complete icon to set status to Ready for Review").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	@And("User sets the date field and verifies")
	public void User_sets_the_date_field(){
		try{
			new LeedOnlineKeywords().fillingTheDateField()

			loginfo.createNode(new GherkinKeyword("And"), "User sets the date field and verifies").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User sets the date field and verifies").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify that user able to upload files < 100mb
	 */
	@And("User verifies the uploaded files")
	public void user_verifies_the_uploaded_files(){
		try{
			String addFileCount = findTestData("Data Files/TD_FormElements").getValue("Add File", rowNum)

			println "Total Number of Add files "+addFileCount
			int totalNumberOfAddFiles = Integer.parseInt(addFileCount)

			println "Addfile num "+totalNumberOfAddFiles

			for(int i=1;i<=totalNumberOfAddFiles;i++){
				boolean statusMatch = new LeedOnlineKeywords().verifyUploadedFiles(i)
				println "Is files matched " +statusMatch

			}
			loginfo.createNode(new GherkinKeyword("And"), "User verifies the uploaded files").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User verifies the uploaded files").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	/*
	 * Verify the date field showing the date in correct format.
	 */
	@And("User validates the date format")
	public void User_check_the_date_field_is_validated(){
		try{
			WebDriver driver = DriverFactory.getWebDriver()

			String iframePath = entities.formIframe
			TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,iframePath,true)
			WebUI.switchToFrame(iFrame, 1)

			TestObject obj1 = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.dateText,true)
			String strDate=WebUI.getAttribute(obj1, "value")
			println "******strDate*********"+strDate

			SimpleDateFormat sdfrmt = new SimpleDateFormat("dd MMM yyyy");


			Date javaDate = sdfrmt.parse(strDate);

			WebUI.switchToDefaultContent()
			loginfo.createNode(new GherkinKeyword("And"), "User validates the date format").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User validates the date format").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify 'Credit form' pdf icon should not be visible before saving the form.It should be visible and generate/download the pdf once we save the form. 
	 */
	@And("User dowloads the generated pdf form")
	public void user_verifies_the_PDF(){
		try{
			new LeedOnlineKeywords().click_pdf_Icon()
			loginfo.createNode(new GherkinKeyword("And"), "User dowloads the generated pdf form").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User dowloads the generated pdf form").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify Forms edit revisions/switch icon visible only after save the form.
	 */
	@And("User verifies the revision icon present after saving the form")
	public void user_verifies_the_revision_icon_present_after_saving_the_form(){
		try{
			WebUI.delay(2)
			new LeedOnlineKeywords().checkRevisionIcon()
			loginfo.createNode(new GherkinKeyword("And"), "User verifies the revision icon present after saving the form").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User verifies the revision icon present after saving the form").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify 'Credit form' pdf icon should not be visible before saving the form.It should be visible and generate/download the pdf once we save the form.
	 */
	@And("User verifies the uploaded files from pdf and form page")
	public void user_verifies_the_uploaded_files_from_pdf_and_form_page(){
		try{
			String addFileCount = findTestData("Data Files/TD_FormElements").getValue("Add File", rowNum)
			println "Number of Add files "+addFileCount
			int totalNumberOfAddFiles = Integer.parseInt(addFileCount)
			println "Total no of Addfiles "+totalNumberOfAddFiles

			for(int i=1;i<=totalNumberOfAddFiles;i++){
				String compare = new LeedOnlineKeywords().verifyUploadedFilesFromPdf(i)
				WebUI.verifyMatch(compare, "Found", false, FailureHandling.CONTINUE_ON_FAILURE)
			}
			loginfo.createNode(new GherkinKeyword("And"), "User verifies the uploaded files from pdf and form page").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User verifies the uploaded files from pdf and form page").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	/*
	 * Verify 'Credit form' pdf icon should not be visible before saving the form.It should be visible and generate/download the pdf once we save the form.
	 */
	@And("User verifies text with pdf and form page")
	public void user_verifies_text_with_pdf(){
		try{
			String textBoxCount = findTestData("Data Files/TD_FormElements").getValue("Text Box", rowNum)
			println "Text box number "+textBoxCount
			int totalNumberOfTextBoxes = Integer.parseInt(textBoxCount)

			String textBoxForNumberCount = findTestData("Data Files/TD_FormElements").getValue("Text Box for Numbers", rowNum)

			int totalTextBoxesForNumberCount=Integer.parseInt(textBoxForNumberCount)


			if(totalNumberOfTextBoxes>0){

				for(int i=1;i<=totalNumberOfTextBoxes;i++){
					TestObject textBox = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.textMedium+"["+i+"]",true)
					String compare = new LeedOnlineKeywords().verifyTextBoxValueFromPdf(textBox)
					WebUI.verifyMatch(compare, "Found", false)
				}
			}

			if(totalTextBoxesForNumberCount>0){

				for(int i=1;i<=totalTextBoxesForNumberCount;i++){
					TestObject textBoxWithNumber = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.textRtl+"["+i+"]",true)
					String compare = new LeedOnlineKeywords().verifyTextBoxValueFromPdf(textBoxWithNumber)
					WebUI.verifyMatch(compare, "Found", false)
				}
			}
			loginfo.createNode(new GherkinKeyword("And"), "User verifies text with pdf and form page").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User verifies text with pdf and form page").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	/*
	 * Verify 'Credit form' pdf icon should not be visible before saving the form.It should be visible and generate/download the pdf once we save the form.
	 */
	@And("User verifies the tables with pdf and form page")
	public void user_verifies_tables(){
		try{
			String tableCount = findTestData("Data Files/TD_FormElements").getValue("Table", rowNum)
			int totalNumberOfTables=Integer.parseInt(tableCount)
			String compare = new LeedOnlineKeywords().verifyTableContentFromPdf(totalNumberOfTables)
			WebUI.verifyMatch(compare, "Found", false)
			loginfo.createNode(new GherkinKeyword("And"), "User verifies the tables with pdf and form page").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User verifies the tables with pdf and form page").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	/*
	 * Verify 'Credit form' pdf icon should not be visible before saving the form.It should be visible and generate/download the pdf once we save the form.
	 */
	@And("User verifies the date with pdf and form page")
	public void user_verifies_the_date_with_pdf_and_form_page(){
		try{
			TestObject dateObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.dateText,true)
			String compare = new LeedOnlineKeywords().verifyDateFromPdf(dateObj)
			WebUI.verifyMatch(compare, "Found", false)

			loginfo.createNode(new GherkinKeyword("And"), "User verifies the date with pdf and form page").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User verifies the date with pdf and form page").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify 'Credit form' pdf icon should not be visible before saving the form.It should be visible and generate/download the pdf once we save the form.
	 */
	@And("User verifies the narrative from pdf and form page")
	public void user_verifies_the_narraive_from_pdf(){
		try{
			String narrativeCount = findTestData("Data Files/TD_FormElements").getValue("Narrative", rowNum)
			println "Number of Narrative "+narrativeCount
			int totalNumberOfNarratives = Integer.parseInt(narrativeCount)

			for(int i=1;i<=totalNumberOfNarratives;i++){
				String compare = new LeedOnlineKeywords().verifyNarrativeTextFromPdf(i)
				WebUI.verifyMatch(compare, "Found", false)
			}
			loginfo.createNode(new GherkinKeyword("And"), "User verifies the narrative from pdf and form page").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User verifies the narrative from pdf and form page").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}

	}


	/* Auto Save Functionality Scripts  ----- Started  */

	String dateTime

	@And("User creating a category for Autosave")
	public void User_creating_a_category_for_Autosave(){
		try{

			browserName = new LeedOnlineKeywords().getBrowserName()
			//logger.assignCategory(GlobalVariable.currentTestCaseId+"Autosave"+" - "+browserName);
			//browserName = new LeedOnlineKeywords().getBrowserName()
			Assert.assertTrue(true);
			//			logger.log(LogStatus.PASS, "User has to navigate to leed online home page",browserName);
			loginfo.createNode(new GherkinKeyword("And"), "User creating a category for Autosave").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User creating a category for Autosave").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify form draft is saved automatically with date & time every after 10 sec complete only if there is change in the form w.r.t Narrative/Checkboxes/Date /number fields/String fields.
	 */
	@And("User verifies form draft is saved automatically after 10 sec complete by filling the Narrative")
	public void user_verifies_Auto_save_after_entering_Narrative(){
		try{
			TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
			String randomText = new LeedOnlineKeywords().generateRandomString(5)
			String narrativeContent = findTestData("Data Files/TD_TestDataAutoSave").getValue("Narrative", 1)
			String data = narrativeContent+randomText

			String narrativeCount = findTestData("Data Files/TD_FormElements").getValue("Narrative", rowNum)
			println "Number of Narrative "+narrativeCount
			int totalNumberOfNarratives = Integer.parseInt(narrativeCount)

			for(int i=1;i<=totalNumberOfNarratives;i++){
				String narrativeXpath = entities.narrative+"["+i+"]"
				new LeedOnlineKeywords().fillingNarrative(narrativeXpath,data)
			}

			WebUI.delay(10)
			TestObject draftDateObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.draftDate,true)
			WebUI.switchToFrame(iFrame, 1)
			String dateTimeNarrative = WebUI.getText(draftDateObj)

			println "dateTimeNarrative "+dateTimeNarrative
			println "Initially "+dateTime
			if(dateTime == ""){
				WebUI.verifyElementPresent(draftDateObj, 3)
			}
			else{
				WebUI.verifyNotMatch(dateTime, dateTimeNarrative, false)
			}

			dateTime = dateTimeNarrative
			WebUI.switchToDefaultContent()
			loginfo.createNode(new GherkinKeyword("And"), "User verifies form draft is saved automatically after 10 sec complete by filling the Narrative").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User verifies form draft is saved automatically after 10 sec complete by filling the Narrative").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	/*
	 * Verify form draft is saved automatically with date & time every after 10 sec complete only if there is change in the form w.r.t Narrative/Checkboxes/Date /number fields/String fields.
	 */
	@And("User verifies Auto save after entering text box")
	public void user_verifies_Auto_save_after_entering_text_box(){
		try{
			TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)

			TestObject draftDateObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.draftDate,true)

			String textBoxCount = findTestData("Data Files/TD_FormElements").getValue("Text Box", rowNum)
			println "Total no of Text boxes "+textBoxCount
			int totalNumberOfTextBoxes = Integer.parseInt(textBoxCount)
			String textValue = findTestData("Data Files/TD_TestDataAutoSave").getValue("Text Box", 1)

			for(int i=1;i<=totalNumberOfTextBoxes;i++){
				TestObject textObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.textMedium+"["+i+"]",true)
				new LeedOnlineKeywords().enterTextBoxData(textObj, textValue)
			}
			WebUI.delay(10)
			WebUI.switchToFrame(iFrame, 1)
			String dateTimeText = WebUI.getText(draftDateObj)

			println "The draft value after entering the text box "+dateTimeText
			WebUI.verifyNotMatch(dateTime, dateTimeText, false)

			dateTime = dateTimeText
			WebUI.switchToDefaultContent()
			loginfo.createNode(new GherkinKeyword("And"), "User verifies Auto save after entering text box").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User verifies Auto save after entering text box").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify form draft is saved automatically with date & time every after 10 sec complete only if there is change in the form w.r.t Narrative/Checkboxes/Date /number fields/String fields.
	 */
	@And("User verifies Auto save after entering text box with number")
	public void user_verifies_Auto_save_after_entering_text(){
		try{
			TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)

			TestObject draftDateObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.draftDate,true)

			String textBoxForNumberCount = findTestData("Data Files/TD_FormElements").getValue("Text Box for Numbers", rowNum)
			String numberToEnter = findTestData("Data Files/TD_TestDataAutoSave").getValue("Number Text Box", 1)

			int totalNumberOfTextBoxes=Integer.parseInt(textBoxForNumberCount)

			for(int i=1;i<=totalNumberOfTextBoxes;i++){
				TestObject textBoxForNumberObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.textRtl+"["+i+"]",true)
				new LeedOnlineKeywords().enterDataToNumericTextbox(textBoxForNumberObj,numberToEnter)

			}
			WebUI.delay(10)
			WebUI.switchToFrame(iFrame, 1)

			String dateTimeForTextBoxNumber = WebUI.getText(draftDateObj)
			println "dateTimeNumbertext "+dateTimeForTextBoxNumber
			WebUI.verifyNotMatch(dateTime, dateTimeForTextBoxNumber, false)
			dateTime = dateTimeForTextBoxNumber
			WebUI.switchToDefaultContent()
			loginfo.createNode(new GherkinKeyword("And"), "User verifies Auto save after entering text box with number").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User verifies Auto save after entering text box with number").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify form draft is saved automatically with date & time every after 10 sec complete only if there is change in the form w.r.t Narrative/Checkboxes/Date /number fields/String fields.
	 */
	@And("User verifies form draft is saved automatically after 10 sec by entering the date field")
	public void user_verifies_Auto_save_after_entering_the_date_field(){
		try{
			TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)

			TestObject draftDateObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.draftDate,true)
			new LeedOnlineKeywords().fillingTheDateFieldForAutosave()
			WebUI.delay(10)
			WebUI.switchToFrame(iFrame, 1)
			String dateTimeForDateField = WebUI.getText(draftDateObj)
			println "dateTimeDate "+dateTimeForDateField
			WebUI.verifyNotMatch(dateTime,dateTimeForDateField,false)

			dateTime = dateTimeForDateField
			WebUI.switchToDefaultContent()
			loginfo.createNode(new GherkinKeyword("And"), "User verifies form draft is saved automatically after 10 sec by entering the date field").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User verifies form draft is saved automatically after 10 sec by entering the date field").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	/*
	 * Verify form draft is not saved automatically every after 10 sec completed if there is no change in the form.
	 */
	@And("User will not make any changes in the form and verifies form is not saved as draft")
	public void user_will_not_make_any_changes_in_the_form_and_verifies_form_not_saved_as_draft(){
		try{
			WebUI.delay(10)
			TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
			WebUI.switchToFrame(iFrame, 1)
			TestObject draftDateObject = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.draftDate,true)
			String noChangeInDateTime = WebUI.getText(draftDateObject)
			println "noChangeInDateTime "+ noChangeInDateTime
			WebUI.verifyMatch(dateTime, noChangeInDateTime, false)

			dateTime = noChangeInDateTime
			WebUI.switchToDefaultContent()
			loginfo.createNode(new GherkinKeyword("And"), "User will not make any changes in the form and verifies form is not saved as draft").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User will not make any changes in the form and verifies form is not saved as draft").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify form draft is not saved automatically with date & time every after 10 sec complete if upload files in the form.
	 */
	@And("User uploads files to Add file button and verifies form is not saved as draft")
	public void user_uploads_files_to_Add_file_button_and_verifies_form_not_saved_as_draft(){
		try{
			String addFileCount = findTestData("Data Files/TD_FormElements").getValue("Add File", rowNum)
			int totalNumberOfAddFiles = Integer.parseInt(addFileCount)

			for(int i=1;i<=totalNumberOfAddFiles;i++){

				new LeedOnlineKeywords().uploadFilesToAddfile(i)
				WebUI.delay(3)
			}

			WebUI.delay(10)
			TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
			WebUI.switchToFrame(iFrame, 1)
			TestObject draftDateObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.draftDate,true)

			String dateTimeForAddFile = WebUI.getText(draftDateObj)
			println "dateTimeAddfile "+dateTimeForAddFile
			WebUI.verifyMatch(dateTime, dateTimeForAddFile, false)
			dateTime = dateTimeForAddFile
			WebUI.switchToDefaultContent()
			loginfo.createNode(new GherkinKeyword("And"), "User uploads files to Add file button and verifies form is not saved as draft").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User uploads files to Add file button and verifies form is not saved as draft").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify form draft is saved automatically with date & time every after 10 sec complete only if there is change in the form w.r.t Narrative/Checkboxes/Date /number fields/String fields.
	 */
	@And("User checks the checkbox option and verifies form draft is saved automatically after 10 sec complete")
	public void user_checks_the_checkbox_option_and_verifies_autosave(){
		try{
			String checkBoxValue = findTestData("Data Files/TD_FormElements").getValue("Checkbox Value", rowNum)

			println "The form Name "+checkBoxValue

			String stringToSplit = findTestData("Data Files/TD_FormElements").getValue("Form Name with option", rowNum)

			//To check check box apart from the optional check box

			if(stringToSplit.contains("!R")){
				String checkBoxCount = findTestData("Data Files/TD_FormElements").getValue("Checkbox", rowNum)

				int totalNumberOfCheckBox = Integer.parseInt(checkBoxCount)

				if(totalNumberOfCheckBox>0){

					for(int i=1;i<=totalNumberOfCheckBox;i++){
						String fieldCheckBoxPath = new LeedOnlineKeywords().getXpathForCheckBox(checkBoxValue,"")+"["+i+"]"
						TestObject fieldCheckBoxObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,fieldCheckBoxPath,true)
						new LeedOnlineKeywords().checkOrUncheckCheckbox(fieldCheckBoxPath)
						WebUI.delay(3)

					}

				}

			}


			else if(checkBoxValue!='' && stringToSplit.contains("!C")){

				String checkBoxXpath =  new LeedOnlineKeywords().getXpathForCheckBox(checkBoxValue,"option")
				TestObject checkBoxObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,checkBoxXpath,true)
				new LeedOnlineKeywords().selectCheckBox(checkBoxObj)
				String checkBoxCount = findTestData("Data Files/TD_FormElements").getValue("Checkbox", rowNum)
				int totalNumberofCheckBoxes = Integer.parseInt(checkBoxCount)

				if(totalNumberofCheckBoxes>0){

					for(int i=1;i<=totalNumberofCheckBoxes;i++){
						String fieldCheckBoxPath = new LeedOnlineKeywords().getXpathForCheckBox(checkBoxValue,"")+"["+i+"]"
						TestObject fieldCheckBoxObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,fieldCheckBoxPath,true)
						new LeedOnlineKeywords().checkOrUncheckCheckbox(fieldCheckBoxPath)
						WebUI.delay(3)

					}

				}
			}

			else{

				String checkBoxCount = findTestData("Data Files/TD_FormElements").getValue("Checkbox", rowNum)
				int totalNumberofCheckBoxes = Integer.parseInt(checkBoxCount)
				String chkBoxValue = ""

				if(totalNumberofCheckBoxes>0){

					for(int i=1;i<=totalNumberofCheckBoxes;i++){
						String fieldCheckBoxPath = new LeedOnlineKeywords().getXpathForCheckBox(chkBoxValue,"")+"["+i+"]"
						TestObject fieldCheckBoxObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,fieldCheckBoxPath,true)

						new LeedOnlineKeywords().checkOrUncheckCheckbox(fieldCheckBoxPath)
					}

				}
			}

			WebUI.delay(10)

			TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
			WebUI.switchToFrame(iFrame, 1)
			TestObject draftDateObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.draftDate,true)

			String dateTimeCheckbox = WebUI.getText(draftDateObj)
			println "dateTimeCheckbox "+dateTimeCheckbox
			WebUI.verifyNotMatch(dateTime, dateTimeCheckbox, false)

			dateTime = dateTimeCheckbox
			WebUI.switchToDefaultContent()
			loginfo.createNode(new GherkinKeyword("And"), "User checks the checkbox option and verifies form draft is saved automatically after 10 sec complete").pass("pass");
			Assert.assertTrue(true);
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User checks the checkbox option and verifies form draft is saved automatically after 10 sec complete").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify form draft is saved automatically with date & time every after 10 sec complete only if there is change in the form w.r.t Narrative/Checkboxes/Date /number fields/String fields.
	 */
	@And("User verifies form draft is saved automatically after 10 sec complete by selecting radio button")
	public void user_verifies_auto_save_after_selecting_radio_button(){
		try{
			WebUI.delay(10)

			TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
			WebUI.switchToFrame(iFrame, 1)
			TestObject draftDateObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.draftDate,true)
			WebUI.verifyElementPresent(draftDateObj, 2)
			String dateTimeRadioButton = WebUI.getText(draftDateObj)
			println "dateTimeRadioButton "+dateTimeRadioButton

			dateTime = dateTimeRadioButton
			WebUI.switchToDefaultContent()
			loginfo.createNode(new GherkinKeyword("And"), "User verifies form draft is saved automatically after 10 sec complete by selecting radio button").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User verifies form draft is saved automatically after 10 sec complete by selecting radio button").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify the below warning message is displayed with date & time when opening the form next time once after saved the form draft
	 "Form drafted and not yet saved!
	 This credit form has been drafted on 14 Mar 2019 06:01:33 PM. The drafted form must be saved in order to submit this credit to review."
	 */
	@And("User verifies warning message of form saved as draft is present and draft not changed")
	public void user_verifies_warning_message_of_form_saved_as_draft(){
		try{
			WebUI.delay(4)

			String warning = "//div[contains(text(),'Form drafted and not yet saved!')]"

			TestObject warningObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,warning,true)


			TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
			WebUI.switchToFrame(iFrame, 1)

			WebUI.verifyElementPresent(warningObj, 2)

			TestObject draftDateObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.draftDate,true)

			String dateTimeAfterLogin = WebUI.getText(draftDateObj)
			println "dateTimeAfterLogin "+dateTimeAfterLogin

			WebUI.verifyMatch(dateTime, dateTimeAfterLogin, false)

			dateTime = dateTimeAfterLogin

			WebUI.switchToDefaultContent()
			loginfo.createNode(new GherkinKeyword("And"), "User verifies warning message of form saved as draft is present and draft not changed").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User verifies warning message of form saved as draft is present and draft not changed").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify the form draft warning message is not retained when form is saved.
	 */
	@And("User verifies clear draft,warning message is not present")
	public void user_verifies_clear_draft_warning_message_are_not_present(){
		try{
			TestObject clearDraft = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.clearDraft,true)
			WebUI.verifyElementNotPresent(clearDraft, 3)

			String warning = "//div[contains(text(),'Form drafted and not yet saved!')]"

			TestObject warningObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,warning,true)


			TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
			WebUI.switchToFrame(iFrame, 1)

			WebUI.verifyElementNotPresent(warningObj, 2)
			WebUI.switchToDefaultContent()
			loginfo.createNode(new GherkinKeyword("And"), "User verifies clear draft,warning message is not present").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User verifies clear draft,warning message is not present").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	/*
	 * Verify able to clear the form draft saved.
	 */
	@And("User clicks on clear draft and verifies the draft is not present")
	public void user_clears_draft(){
		try{
			new LeedOnlineKeywords().clearTheDraft()
			WebUI.delay(4)
			loginfo.createNode(new GherkinKeyword("And"), "User clicks on clear draft and verifies the draft is not present").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User clicks on clear draft and verifies the draft is not present").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}



	@Then("User clicks on Save button and deletes the uploaded files")
	public void User_clicks_on_Save_button_and_deletes_the_uploaded_files() {
		try{
			new LeedOnlineKeywords().clickSaveButton()
			WebUI.delay(4)

			String addFileCount = findTestData("Data Files/TD_FormElements").getValue("Add File", rowNum)

			int totalNumberOfAddFiles = Integer.parseInt(addFileCount)

			for(int i=totalNumberOfAddFiles;i>=1;i--){

				new LeedOnlineKeywords().deleteUploadedFiles(i)

			}
			loginfo.createNode(new GherkinKeyword("And"), "User clicks on Save button and deletes the uploaded files").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User clicks on Save button and deletes the uploaded files").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify form draft is saved automatically with date & time every after 10 sec complete only if there is change in the form w.r.t Narrative/Checkboxes/Date /number fields/String fields.
	 */
	@And("User verifies draft saved automatically after filling the table")
	public void user_verifies_draft_saved_automatically_after_filling_the_table(){
		try{
			WebUI.delay(10)

			TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
			WebUI.switchToFrame(iFrame, 1)
			TestObject draftDateObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.draftDate,true)
			String dateTimeTable = WebUI.getText(draftDateObj)
			println "dateTimeTable "+dateTimeTable

			WebUI.verifyNotMatch(dateTime, dateTimeTable, false)

			dateTime = dateTimeTable
			WebUI.switchToDefaultContent()
			loginfo.createNode(new GherkinKeyword("And"), "User verifies draft saved automatically after filling the table").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User verifies draft saved automatically after filling the table").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	/*
	 * Verify the selected file upload retains if user clicks on 'No'
	 */
	@And("User clicks on cancel while deleting the uploaded file and verifies the files are retained")
	public void user_cancels_file_deleting_the_uploaded_file(){
		try{
			new LeedOnlineKeywords().clickCancelWhileDeletingFile()
			loginfo.createNode(new GherkinKeyword("And"), "User clicks on cancel while deleting the uploaded file and verifies the files are retained").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User clicks on cancel while deleting the uploaded file and verifies the files are retained").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify the add and delete button by adding an deleting the rows in the table.
	 */
	@And("User deletes the table rows table (.*) with data (.*)")
	public void user_deletes_the_table_rows(String table, String data){
		try{
			new LeedOnlineKeywords().deleteTableRows(table, data)
			WebUI.delay(3)
			new LeedOnlineKeywords().clickSaveButton()
			loginfo.createNode(new GherkinKeyword("And"), "User deletes the table rows table with data").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User deletes the table rows table with data").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	/* Login and Logout for auto save functionality */

	/*
	 * Once draft is saved automatically with date & time, Verify that draft version is not deleted/changed even after logout and login back to project
	 */
	@And("User logout and login to the form (.*) and rating(.*)")
	public void user_logout_and_login_to_the_form(String formName, String rating){
		try{
			TestObject account=new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.account,true)

			println "################################ Before Clicking Account"
			WebUI.click(account)
			println "################################ After Clicking Account"

			TestObject signOut=new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.signOut,true)
			println "################################ Before Clicking Signout"
			WebUI.click(signOut)
			println "################################ After Clicking Signout"
			WebUI.delay(2)

			WebUI.callTestCase(findTestCase("Test Cases/TC_Login"), null)

			if (rating == "O+M:EB"){
				prjName = GlobalVariable.O_M_EB

			}
			TestObject projectName = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.projectName+prjName+"']")

			WebUI.delay(2)
			println "################################ Before Clicking Project"
			WebUI.click(projectName)
			println "################################ After Clicking Project"


			WebUI.delay(2)
			TestObject creditsBtn = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.creditsBtn)
			println "################################ After Clicking Credits"
			WebUI.click(creditsBtn)
			println "################################ Before Clicking Credits"

			int formRow = new LeedOnlineKeywords().getRowNumberOfFormFromExcel(formName)
			rowNum = formRow

			println rowNum

			formName = findTestData("Data Files/TD_FormElements").getValue("Form Name", rowNum)

			nameOfTheForm =formName

			new LeedOnlineKeywords().navigateToForm(formName)
			loginfo.createNode(new GherkinKeyword("And"), "User logout and login to the form and rating").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User logout and login to the form and rating").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/* Login and Logout for auto save functionality --- Ended*/

	/* Auto Save Functionality Scripts  ----- Ended*/


	/* IP and SI   -- Started
	 * Verify unit in the form displays based on the selection of unit type (IP/SI) of the project.
	 */
	Map<Integer,ArrayList<String>> map = new HashMap<>()
	Map<Integer,ArrayList<String>> map2 = new HashMap<>()

	@And("User checks the units of table")
	public void user_check_the_units_of_table_with_data(){
		try{
			String tableNum = findTestData("Data Files/TD_FormElements").getValue("Table", rowNum)
			int length=Integer.parseInt(tableNum)
			println "length******* : "+length
			LeedOnlineKeywords leedOnline = new LeedOnlineKeywords();

			map = leedOnline.tableColumnWithUnitType(length);
			for (Map.Entry<Integer,ArrayList<String>> entry : map.entrySet())
				println "Key = " + entry.getKey() +	", Value = " + entry.getValue();
			loginfo.createNode(new GherkinKeyword("And"), "User checks the units of table").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User checks the units of table").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	Map<Integer,ArrayList<String>> map_textbox = new HashMap<>()
	Map<Integer,ArrayList<String>> map_tb = new HashMap<>()

	@And("User checks the units of textbox")
	public void user_check_the_units_of_textbox_with_data(){
		try{
			String txtBoxNumberCount = findTestData("Data Files/TD_FormElements").getValue("Text Box for Numbers", rowNum)
			int totalNumberOfTextBoxForNumber=Integer.parseInt(txtBoxNumberCount)
			println "totalNumberOfTextBoxForNumber******* : "+totalNumberOfTextBoxForNumber
			LeedOnlineKeywords leedOnline = new LeedOnlineKeywords();

			map_textbox = leedOnline.textBoxWithUnitType(totalNumberOfTextBoxForNumber);
			for (Map.Entry<Integer,ArrayList<String>> entry : map_textbox.entrySet())
				println "Key = " + entry.getKey() +	", Value = " + entry.getValue();
			loginfo.createNode(new GherkinKeyword("And"), "User checks the units of textbox").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User checks the units of textbox").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	@And("User changes the unit type (.*) rating (.*)")
	public void User_changes_the_unit_type(String formName,String rating){
		try{
			String unitType='SI'
			new LeedOnlineKeywords().changeUnitsType(unitType,formName,rating)
			loginfo.createNode(new GherkinKeyword("And"), "User changes the unit type rating").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User changes the unit type rating").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	@And("User checks the units are not same in table")
	public void User_checks_the_units_are_not_same_in_table(){
		try{
			String tableCount = findTestData("Data Files/TD_FormElements").getValue("Table", rowNum)
			int totalNumberOfTables=Integer.parseInt(tableCount)
			println "totalNumberOfTables******* : "+totalNumberOfTables
			LeedOnlineKeywords leedOnline = new LeedOnlineKeywords();
			map2 = leedOnline.tableColumnWithUnitType(totalNumberOfTables);

			for (Map.Entry<Integer,ArrayList<String>> entry : map2.entrySet())
				println "Key = " + entry.getKey() +	", Value = " + entry.getValue();

			List <String> list1 = new ArrayList<>();
			List <String> list2 = new ArrayList<>();
			for(int i =1; i <=totalNumberOfTables; i++){
				list1 = map.get(i);
				list2 = map2.get(i);

				println "Assertaion value of two tables key:"+i+"->"+ list1.equals(list2)
				WebUI.verifyNotEqual(list1, list2)

			}
			loginfo.createNode(new GherkinKeyword("And"), "User checks the units are not same in table").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User checks the units are not same in table").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	@And("User checks the units are not same in textbox")
	public void User_checks_the_units_are_not_same_in_textbox(){
		try{
			String txtBoxNumberCount = findTestData("Data Files/TD_FormElements").getValue("Text Box for Numbers", rowNum)
			int totalNumberOfTextBoxForNumber=Integer.parseInt(txtBoxNumberCount)
			println "totalNumberOfTextBoxForNumber******* : "+totalNumberOfTextBoxForNumber
			LeedOnlineKeywords leedOnline = new LeedOnlineKeywords();

			map_tb = leedOnline.textBoxWithUnitType(totalNumberOfTextBoxForNumber);

			for (Map.Entry<Integer,ArrayList<String>> entry : map_tb.entrySet())
				println "Key = " + entry.getKey() +	", Value = " + entry.getValue();

			List <String> list1 = new ArrayList<>();
			List <String> list2 = new ArrayList<>();
			for(int i =1; i <=totalNumberOfTextBoxForNumber; i++){
				list1 = map_textbox.get(i);
				list2 = map_tb.get(i);
				println "Assertaion value of two textboxs key:"+i+"->"+ list1.equals(list2)
			}
			loginfo.createNode(new GherkinKeyword("And"), "User checks the units are not same in textbox").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User checks the units are not same in textbox").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	@And("User revert the unit type (.*) rating (.*)")
	public void User_revert_the_unit_type(String formName,rating){
		try{
			String unitType='IP'
			new LeedOnlineKeywords().changeUnitsType(unitType,formName,rating)
			loginfo.createNode(new GherkinKeyword("And"), "User revert the unit type rating").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User revert the unit type rating").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	//#########End of IP SI######################

	//Select option from Dropdown

	@And("User selects option from dropdown and verifies (.*)")

	public void User_selects_option_from_dropdown_and_verifies(String optionValue){
		try{
			String dropDownCount = findTestData("Data Files/TD_FormElements").getValue("Select Dropdown", rowNum)

			println "Dropdown count "+dropDownCount
			int totalNumberOfDropDowns = Integer.parseInt(dropDownCount)

			for(int i=1;i<=totalNumberOfDropDowns;i++){

				new LeedOnlineKeywords().selectOptionFromDropdown(optionValue, i)
			}
			loginfo.createNode(new GherkinKeyword("And"), "User selects option from dropdown and verifies").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User selects option from dropdown and verifies").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	@And("User verifies the dropdown value with pdf and form page")
	public void User_verifies_the_dropdown_value_with_pdf_and_form_page(){
		try{
			String dropDownCount = findTestData("Data Files/TD_FormElements").getValue("Select Dropdown", rowNum)

			println "Dropdown count "+dropDownCount
			int totalNumberOfDropDowns = Integer.parseInt(dropDownCount)

			for(int i=1;i<=totalNumberOfDropDowns;i++){
				new LeedOnlineKeywords().verifySelectedOptionFromPdf(i)
			}
			loginfo.createNode(new GherkinKeyword("And"), "User verifies the dropdown value with pdf and form page").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User verifies the dropdown value with pdf and form page").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	@And("User verifies form draft is saved automatically after 10 sec complete after changing dropdown option (.*)")
	public void User_verifies_form_draft_is_save_automatically_after_10_sec_complete_after_changing_dropdown_option(String optionValue){
		try{
			String dropDownCount = findTestData("Data Files/TD_FormElements").getValue("Select Dropdown", rowNum)

			println "Dropdown count "+dropDownCount
			int totalNumberOfDropDowns = Integer.parseInt(dropDownCount)

			for(int i=1;i<=totalNumberOfDropDowns;i++){

				new LeedOnlineKeywords().selectOptionFromDropdown(optionValue, i)
			}
			WebUI.delay(10)
			TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
			WebUI.switchToFrame(iFrame, 1)
			TestObject draftDateObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.draftDate,true)
			String dateTimeDropdown = WebUI.getText(draftDateObj)
			println "dateTimeDropdown "+ dateTimeDropdown
			WebUI.verifyNotMatch(dateTime, dateTimeDropdown, false)

			dateTime = dateTimeDropdown
			WebUI.switchToDefaultContent()
			loginfo.createNode(new GherkinKeyword("And"), "User verifies form draft is saved automatically after 10 sec complete after changing dropdown option").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User verifies form draft is saved automatically after 10 sec complete after changing dropdown option").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	@And("User Ends Autosave")
	public void User_Ends_Autosave(){
		try{
			loginfo.createNode(new GherkinKeyword("And"), "User Ends Autosave").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User Ends Autosave").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	/*
	 Negative Scenarios -- Started
	 */

	/*
	 * Verify validation message display if user upload files >100mb -'Maximum allowed file size is 100 MB only.'
	 */

	@And("User Checking for Negative scenario")
	public void User_Checking_for_Negative_scenario(){
		try{
			loginfo.createNode(new GherkinKeyword("And"), "User Checking for Negative scenario").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User Checking for Negative scenario").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}
	@And("User uploads a file which is greater than 100MB (.*) and verifies the error message")
	public void user_uploads_a_file_which_is_greater_than_100MB_and_verifies_the_error_message(String fileName){
		try{
			String addFileCount = findTestData("Data Files/TD_FormElements").getValue("Add File", rowNum)

			println "Number of Add files "+addFileCount
			int totalNumberOfAddFiles = Integer.parseInt(addFileCount)

			println "Total number of Addfile "+totalNumberOfAddFiles

			for(int i=1;i<=totalNumberOfAddFiles;i++){

				new LeedOnlineKeywords().uploadFileForNegativeCases(i,fileName)

				WebUI.delay(2)

				boolean str =	WebUI.verifyTextPresent("Maximum allowed file size is 100 MB only.", false)
				println "###########" + str

			}
			loginfo.createNode(new GherkinKeyword("And"), "User uploads a file which is greater than 100MB and verifies the error message").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User uploads a file which is greater than 100MB and verifies the error message").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify validation message is displayed as "Please wait running actions to complete." on clicking save button while uploads are processing. 
	 */
	@And("User uploads a file (.*),clicks save button while uploading and verifies the error message")
	public void user_uploads_a_file_clicks_save_button_while_uploading_and_verifies_the_error_message(String fileName){
		try{
			String addFileCount = findTestData("Data Files/TD_FormElements").getValue("Add File", rowNum)

			println "Number of Add files "+addFileCount
			int totalNumberOfAddFiles = Integer.parseInt(addFileCount)

			println "Addfile num "+totalNumberOfAddFiles

			for(int i=1;i<=totalNumberOfAddFiles;i++){

				WebUI.refresh()
				new LeedOnlineKeywords().uploadFileForNegativeCases(i,fileName)
				WebUI.delay(1)
				new LeedOnlineKeywords().clickSaveButton()

				WebUI.delay(2)

				boolean str =	WebUI.verifyTextPresent("Please wait running actions to complete.", false)
				println "###########" + str
				WebUI.delay(2)

				WebUI.refresh()
			}
			loginfo.createNode(new GherkinKeyword("And"), "User uploads a file,clicks save button while uploading and verifies the error message").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User uploads a file,clicks save button while uploading and verifies the error message").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify the form will highlight the fields for the missing data with the message 'Please fix the highlighted errors.'
	 */
	@And("User clicks on save without entering the contents and verifies the error message")
	public void user_clicks_on_save_without_entering_the_contents_and_verifies_the_error_message(){
		try{
			new LeedOnlineKeywords().clearTheEntireForm(rowNum)
			WebUI.delay(2)
			new LeedOnlineKeywords().clickSaveButton()
			WebUI.delay(1)
			WebUI.verifyTextPresent("Please fix the highlighted errors.", false)
			WebUI.delay(5)
			loginfo.createNode(new GherkinKeyword("And"), "User clicks on save without entering the contents and verifies the error message").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User clicks on save without entering the contents and verifies the error message").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify ‘0’ value accepting in string fields (For string fields - blank or '0' consider as empty and set Max length as 100 chars)
	 */
	@And("User enters the data more than 100 characters for text box and verifies")
	public void user_enters_the_data_more_than_100_characters_for_text_box_and_verifies(){
		try{
			String textBoxCount = findTestData("Data Files/TD_FormElements").getValue("Text Box", rowNum)

			println "Total Text box count "+textBoxCount
			int totalNumberOfTextBoxes = Integer.parseInt(textBoxCount)

			String textValue = "I am trying to capture the Error that comes after entering the characters more than 100 as it allows only 100 characters"

			for(int i=1;i<=totalNumberOfTextBoxes;i++){
				TestObject textBoxXpath =  new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.textMedium+'['+i+']',true)
				new LeedOnlineKeywords().enterTextBoxDataForNegativeCase(textBoxXpath,textValue)
				WebUI.delay(2)
				TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
				WebUI.switchToFrame(iFrame, 2)
				String valueText = WebUI.getText(textBoxXpath)
				WebUI.switchToDefaultContent()

				boolean isMatch = WebUI.verifyNotMatch(textValue, valueText, false)

				println "The original value and the value from the text box dosen't match "+isMatch
			}

			loginfo.createNode(new GherkinKeyword("And"), "User enters the data more than 100 characters for text box and verifies").pass("pass");
			Assert.assertTrue(true);
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User enters the data more than 100 characters for text box and verifies").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}

	}

	/*
	 * Verify ‘0’ value accepting in string fields (For string fields - blank or '0' consider as empty and set Max length as 100 chars)
	 */
	@And("User enters the data Zero for text box and verifies")
	public void user_enters_the_data_Zero_for_text_box_and_verifies(){
		try{
			String textBoxCount = findTestData("Data Files/TD_FormElements").getValue("Text Box", rowNum)

			println "Total Text box count "+textBoxCount
			int totalNumberOfTextBoxes = Integer.parseInt(textBoxCount)

			String TextValue = "0"

			for(int i=1;i<=totalNumberOfTextBoxes;i++){
				TestObject textBoxXpath =  new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.textMedium+'['+i+']',true)
				new LeedOnlineKeywords().enterTextBoxDataForNegativeCase(textBoxXpath,TextValue)

				new LeedOnlineKeywords().clickSaveButton()
				WebUI.delay(1)
				WebUI.verifyTextPresent("Please fix the highlighted errors.", false)

			}
			loginfo.createNode(new GherkinKeyword("And"), "User enters the data Zero for text box and verifies").pass("pass");
			Assert.assertTrue(true);
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User enters the data Zero for text box and verifies").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	/*
	 * Verify Numeric length (10 digits + 2 decimal values)
	 */
	@And("User enters data to text box with number and verifies the value present is not same")
	public void user_enters_data_to_text_box_with_number_and_verifies_the_value_present_is_not_same(){
		try{
			String textBoxNumberCount = findTestData("Data Files/TD_FormElements").getValue("Text Box for Numbers", rowNum)
			String numberValue = "66612334567"
			int totalNumberOfTextBoxesForNumber =Integer.parseInt(textBoxNumberCount)

			for(int i=1;i<=totalNumberOfTextBoxesForNumber;i++){
				TestObject rtlTextBox = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.textRtl+'['+i+']',true)
				new LeedOnlineKeywords().enterDataToNumericTextboxNegativeCase(rtlTextBox,numberValue)

				TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
				WebUI.switchToFrame(iFrame, 2)

				WebUI.delay(2)

				String valueText = WebUI.getAttribute(rtlTextBox, 'value')

				println "Number is "+valueText
				WebUI.switchToDefaultContent()

				boolean isMatch = WebUI.verifyNotMatch(numberValue,valueText, false)

				println "The original number and the number from the text box dosen't match "+isMatch
			}
			loginfo.createNode(new GherkinKeyword("And"), "User enters data to text box with number and verifies the value present is not same").pass("pass");
			Assert.assertTrue(true);
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User enters data to text box with number and verifies the value present is not same").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}


	/*
	 * Verify Numeric length (10 digits + 2 decimal values)
	 */
	@And("User enters data with decimal value to text box with number and verifies the value present is not same")
	public void User_enters_data_with_decimal_value_to_text_box_with_number_and_verifies_the_value_present_is_not_same(){
		try{
			String textBoxNumberCount = findTestData("Data Files/TD_FormElements").getValue("Text Box for Numbers", rowNum)
			String numberValue = "66,612,334,4.25"
			int totalNumberOfTextBoxesForNumber=Integer.parseInt(textBoxNumberCount)

			for(int i=1;i<=totalNumberOfTextBoxesForNumber;i++){
				TestObject rtlTextBox = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.textRtl+'['+i+']',true)
				new LeedOnlineKeywords().enterDataToNumericTextboxNegativeCase(rtlTextBox,numberValue)

				TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
				WebUI.switchToFrame(iFrame, 2)

				WebUI.delay(2)
				String valueText = WebUI.getAttribute(rtlTextBox, 'value')
				println "Decimal Number is "+valueText
				WebUI.switchToDefaultContent()

				boolean isMatch = WebUI.verifyNotMatch(numberValue,valueText, false)

				println "The original number and the number from the text box dosen't match  "+isMatch
			}
			loginfo.createNode(new GherkinKeyword("And"), "User enters data with decimal value to text box with number and verifies the value present is not same").pass("pass");
			Assert.assertTrue(true);
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User enters data with decimal value to text box with number and verifies the value present is not same").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}
	}

	/*
	 * Verify Number formatting (separator by 1000) For example 2,200,245.00
	 */
	@And("User verifies Number formatting in text box with number")
	public void user_verifies_Number_formatting_in_text_box_with_number(){
		try{
			String textBoxNumberCount = findTestData("Data Files/TD_FormElements").getValue("Text Box for Numbers", rowNum)
			String numberValue = "6661233444"
			int totalNumberOfTextBoxesForNumber=Integer.parseInt(textBoxNumberCount)

			for(int i=1;i<=totalNumberOfTextBoxesForNumber;i++){
				TestObject rtlTextBox = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.textRtl+'['+i+']',true)
				new LeedOnlineKeywords().enterDataToNumericTextboxNegativeCase(rtlTextBox,numberValue)

				TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
				WebUI.switchToFrame(iFrame, 2)

				WebUI.delay(2)

				String valueText = WebUI.getAttribute(rtlTextBox, 'value')
				println "Text is "+valueText

				if(valueText.contains(',')){
					println "Formatting is correct"
				}
				WebUI.switchToDefaultContent()

				boolean isMatch = WebUI.verifyNotMatch(numberValue,valueText, false)

				println "The original number with decimal and the number with decimal from the text box dosen't match  "+isMatch
			}
			loginfo.createNode(new GherkinKeyword("And"), "User verifies Number formatting in text box with number").pass("pass");
			Assert.assertTrue(true);
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User verifies Number formatting in text box with number").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}

	}

	@And("User Ends the Negative scenario")
	public void User_Ends_the_Negative_scenario(){
		try{
			loginfo.createNode(new GherkinKeyword("And"), "User Ends the Negative scenario").pass("pass");
			Assert.assertTrue(true);
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User Ends the Negative scenario").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot(loginfo));

		}

	}
}
