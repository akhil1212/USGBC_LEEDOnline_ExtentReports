import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import common.entities
import common.runnerLogin
import internal.GlobalVariable as GlobalVariable
import projectKeywords.LeedOnlineKeywords

WebUI.openBrowser("");
WebUI.maximizeWindow();
WebUI.navigateToUrl("https://leedonline-dev.usgbc.org/Form/simpleform?__creditId=EBCRPI101L-1000148269&__creditShortId=PI101&creditHash=aa3caa46ca078a03e0250eb5483ad84e&projectId=1000148269")

TestObject account = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.accountdev)
TestObject userNameObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.userName)
TestObject passwordObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.password)
WebUI.click(account)
WebUI.setText(userNameObj, GlobalVariable.UserName)
WebUI.setText(passwordObj, GlobalVariable.Password)

WebUI.delay(3)
TestObject agreementObject = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.agreement)
WebUI.scrollToElement(agreementObject,30)
WebUI.check(agreementObject)

TestObject loginButton = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.loginButtondev)
WebUI.submit(loginButton)
WebUI.delay(5)

//	TestObject saveButton = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.saveButton,true)
////	TestObject saveButton = new TestObject().addProperty('xpath',ConditionType.EQUALS,"/html/body/div[2]/div[6]/button",true)
//		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
//		WebUI.switchToFrame(iFrame, 2)
//		WebUI.comment("before click")
//		WebUI.click(saveButton)
//		WebUI.comment("After click")
//		WebUI.switchToDefaultContent()
////		new LeedOnlineKeywords().clickSaveButton()	
//		WebUI.verifyTextPresent("Please fix the highlighted errors.", false)
////		WebUI.verifyTextPresent("Form data saved successfully.", false)

		TestObject acc=new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.account,true)
		
					println "################################ Before Clicking Account"
					WebUI.click(acc)
					println "################################ After Clicking Account"
		
					TestObject signOut=new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.signOut,true)
					println "################################ Before Clicking Signout"
					WebUI.click(signOut)
					println "################################ After Clicking Signout"
					WebUI.delay(2)
WebUI.closeBrowser()