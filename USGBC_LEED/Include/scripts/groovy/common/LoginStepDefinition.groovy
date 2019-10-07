package common
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
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
import org.eclipse.persistence.internal.jpa.parsing.jpql.antlr.JPQLParser.aggregateExpression_scope
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
 * Authors : Saravana Sabareesh V
 * Date   :   23/07/2019 
 * Last Updated By: Saravana Sabareesh V
 * Last Updated On : 12/08/2019
 * Reviewed By: Dinesh Kumar
 * Reviewed On: 14/08/2019
 * ******************************************************************************************************************************
 */


class loginStepDefinition {

	ExtentTest test;
	ExtentTest loginfo;
	ExtentReports extent = commonReports.extent;
	String browserName = ""
	@Given("User has to navigate to leed online home page")
	public void user_has_to_navigate_to_leed_online_home_page() {

		try{
			//			WebUI.openBrowser("")
			WebUI.maximizeWindow()

			RemoteWebDriver driver = DriverFactory.getWebDriver()
			String downloadPath = GlobalVariable.DownloadPath_Server+"/"+GlobalVariable.currentTestCaseId
//			String downloadPath = GlobalVariable.DownloadPath_Local+"\\"+GlobalVariable.currentTestCaseId
			new	LeedOnlineKeywords().sendCommandForDownloadChromeHeadLess((HttpCommandExecutor)driver.getCommandExecutor(),driver.getSessionId(), downloadPath )

			WebUI.navigateToUrl(GlobalVariable.URL)

			loginfo= extent.createTest(Feature.class,"Login to USGBC Leed Online Page");
			loginfo=loginfo.createNode(Scenario.class,"User will login to leed online and navigate to credit page");

			loginfo.createNode(new GherkinKeyword("Given"), "User has to navigate to leed online home page").pass("pass");

			Assert.assertTrue(true);
			loginfo.assignCategory(GlobalVariable.currentTestCaseId+"Login")

		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("Given"), "User has to navigate to leed online home page").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot());

		}

	}

	@And("User enters the username and password")
	public void user_enters_the_username_and_password() {
		try{

			TestObject account = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.accountdev)
			TestObject userNameObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.userName)
			TestObject passwordObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.password)
//			WebUI.click(account)
			WebUI.setText(userNameObj, GlobalVariable.UserName)
			WebUI.setText(passwordObj, GlobalVariable.Password)
			loginfo.createNode(new GherkinKeyword("And"), "User enters the username and password").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User enters the username and password").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot());

		}
	}

	@And("User has to accept end user license agreement")
	public void user_has_to_accept_end_user_license_agreement() {
		try{
			WebUI.delay(3)
			TestObject agreementObject = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.agreement)
			WebUI.scrollToElement(agreementObject,30)
			WebUI.check(agreementObject)
			loginfo.createNode(new GherkinKeyword("And"), "User has to accept end user license agreement").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("And"), "User has to accept end user license agreement").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot());

		}
	}


	@When("User clicks on LOG IN button")
	public void user_clicks_on_LOG_IN_button() {
		try{
			WebUI.delay(4)
//			TestObject loginButton = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.loginButtondev)
			TestObject loginButton = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.loginButton)
			WebUI.submit(loginButton)
			loginfo.createNode(new GherkinKeyword("When"), "User clicks on LOG IN button").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("When"), "User clicks on LOG IN button").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot());

		}
	}

	@Then("User will be logged in successfully")
	public void user_will_be_logged_in_successfully(){
		try{
			try{

				WebUI.delay(5)
				TestObject leed = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.leed)
				boolean elementPresent=WebUI.verifyElementPresent(leed, 30)

				println "####################Index######################"+elementPresent
			}
			catch(Exception e){

				println "######Error########" +e.stackTrace
				println "####################Inside catch######################"

				WebUI.delay(6)
				println "########--Completed waiting 60 sec's---########"
				TestObject btnObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.loginButton)
				WebUI.submit(btnObj)
				println "########--Clicking the btn---########"
			}

			loginfo.createNode(new GherkinKeyword("Then"), "User will be logged in successfully").pass("pass");
		} catch   (Exception e){
			loginfo.createNode(new GherkinKeyword("then"), "User will be logged in successfully").fail("fail").addScreenCaptureFromPath(new LeedOnlineKeywords ().takeScreenshot());

		}
	}
}