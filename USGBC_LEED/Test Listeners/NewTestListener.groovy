import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import common.commonReports

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.LogStatus;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.relevantcodes.extentreports.LogStatus;
//import common.CommonReport;
import projectKeywords.LeedOnlineKeywords
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.Capabilities
class NewTestListener {
	static ExtentHtmlReporter htmlReporter1;
	static ExtentReports extent = commonReports.extent;
		String browserName = ""
		
		@BeforeTestCase
		def sampleBeforeTestCase(TestCaseContext testCaseContext) {
		String a=testCaseContext.getTestCaseId()
		
		String lastWord = a.substring(a.lastIndexOf("/")+1);
		String last= a.substring(a.lastIndexOf("_")+1);
		GlobalVariable.currentTestCaseId=last
		println "GlobalVariable.currentTestCaseId#############"+ lastWord
		
		}
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {

		WebUI.openBrowser("")
		
		String folderName
		if(DriverFactory.getExecutedBrowser().getName() == "FIREFOX_DRIVER"){	
			folderName = "Firefox_Report"
		}
		else {
			folderName = "Chrome_Report"
		}
		
		htmlReporter1 = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/"+folderName+"/TestReport.html");
		
		htmlReporter1.config().setDocumentTitle("Extent Report"); // Tile of report
		htmlReporter1.config().setReportName("Functional Testing"); // Name of the report
		htmlReporter1.config().setTheme(Theme.DARK);
		
		extent.attachReporter(htmlReporter1);
//		htmlReporter1.setAppendExisting(true);
		
		println "@@@@"
		// Passing General information
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "sainath");
		browserName= new LeedOnlineKeywords().getBrowserName()
		extent.setSystemInfo("Browser",browserName);
		
		println "The browserName is ########### " + browserName
	}
	
	
	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {

		extent.flush();
	}
}