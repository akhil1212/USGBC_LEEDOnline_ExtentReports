package projectKeywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject



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
import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import common.entities
import groovy.io.FileType

import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.hssf.util.CellReference


import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Row



import org.apache.http.entity.StringEntity
import org.openqa.selenium.remote.HttpCommandExecutor
import org.openqa.selenium.remote.SessionId

import org.apache.http.client.HttpClient
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpPost

import org.apache.http.io.SessionInputBuffer
import org.apache.http.entity.ContentType
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.Capabilities

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.json.Json


import org.apache.http.client.utils.URIBuilder
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients

import java.lang.reflect.Field
import com.testautomationguru.utility.PDFUtil
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;


import java.lang.reflect.Field


import java.io.File;
import java.io.IOException;
import java.text.DateFormat
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.time.DateFormatUtils
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor
//import com.aventstack.extentreports.LogStatus;
//import com.relevantcodes.extentreports.LogStatus;
import com.aventstack.extentreports.markuputils.MarkupHelper
import com.aventstack.extentreports.markuputils.MarkupHelper
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import common.commonReports;
import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.MediaModelProvider;
import org.openqa.selenium.TakesScreenshot;
import com.kms.katalon.core.annotation.Keyword
class LeedOnlineKeywords {


	//Navigation to form

	@Keyword
	def navigateToForm(String formName){

		String formNamePath = entities.scoreCard+formName+"'])"

		TestObject formNameObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,formNamePath,true)

		WebUI.delay(2)

		WebUI.click(formNameObj)

		String creditFormName = WebUI.getText(formNameObj)

		println "The form name in scorecard is "+ creditFormName
		WebUI.delay(3)

		String formVPath = entities.scoreCard+formName+entities.scorecardFormSuffix

		TestObject formV1 = new TestObject().addProperty('xpath',ConditionType.EQUALS,formVPath,true)

		WebUI.click(formV1)

		return creditFormName

	}



	/**
	 * Upload files to Add File field
	 */
	@Keyword
	def uploadFilesToAddfile(int addFileIndex) {

		String elementPath = entities.addFile+'['+addFileIndex+']'

		println "Path inside Keyword "+elementPath
		String iframePath = entities.formIframe

		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,iframePath,true)

		WebUI.switchToFrame(iFrame, 1)
		def list = []

		String path = RunConfiguration.getProjectDir() + '/Include/TestData/FilesToUpload'

		def dir = new File(path)
		dir.eachFile (FileType.FILES) { file -> list << file}
		for (item in list) {

			String filePath = item

			println "File path is "+filePath

			TestObject inputField  = new TestObject().addProperty('xpath', ConditionType.EQUALS, elementPath, true)
			println "tiny ui button "+ entities.AddFileEnabled+addFileIndex+"]"
			TestObject waitEnabled = new TestObject().addProperty('xpath', ConditionType.EQUALS, entities.AddFileEnabled+addFileIndex+"]", true)
			WebUI.waitForElementAttributeValue(waitEnabled, 'class', 'tiny ui button', 20)
			WebUI.delay(15)
			WebUI.uploadFile(inputField, filePath)

		}

		WebUI.switchToDefaultContent()
	}







	//######################Writing into Narrative Field###############

	@Keyword

	def fillingNarrative(String narrativeFrameXpath, String data){


		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)

		TestObject editorFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,narrativeFrameXpath,true)

		TestObject editorBody = new TestObject().addProperty('xpath',ConditionType.EQUALS,"//body",true)

		WebUI.switchToFrame(iFrame, 2)

		WebUI.switchToFrame(editorFrame, 2)

		WebUI.setText(editorBody, data)

		WebUI.delay(2)

		String textAdded = WebUI.getText(editorBody)

		println textAdded

		boolean isNarrative = WebUI.verifyMatch(data, textAdded, false)

		println "Narrative verification is "+isNarrative

		WebUI.switchToDefaultContent()



	}


	//Selecting Radio Button

	@Keyword

	def selectRadioButton(TestObject radioBtnXpath){

		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
		WebUI.switchToFrame(iFrame, 2)
		WebUI.click(radioBtnXpath)

		WebUI.switchToDefaultContent()
	}




	//################Filling the Text Box (Medium Text)#############################
	@Keyword

	def enterTextBoxData(TestObject textBoxObject,String textValue){
		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
		WebUI.switchToFrame(iFrame, 2)

		WebUI.setText(textBoxObject, textValue)

		WebUI.delay(2)

		String textFilled = WebUI.getAttribute(textBoxObject, "value")

		boolean textVerify = WebUI.verifyMatch(textFilled, textValue, false)
		println "The entered text value and the text value present is matched "+textVerify

		WebUI.switchToDefaultContent()


	}


	//################Filling the Text Box (Medium Text) for Negative scenario#############################
	@Keyword

	def enterTextBoxDataForNegativeCase(TestObject textBoxObject,String textValue){
		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
		WebUI.switchToFrame(iFrame, 2)

		WebUI.setText(textBoxObject, textValue)

		WebUI.delay(2)

		String textFilled = WebUI.getAttribute(textBoxObject, "value")
		WebUI.switchToDefaultContent()


	}


	//########################Filling Text Box (RTL), with numbers################
	@Keyword
	def enterDataToNumericTextbox(TestObject rtlText, String number){
		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
		WebUI.switchToFrame(iFrame, 2)
		WebUI.setText(rtlText, number)

		WebUI.delay(2)

		String numValue = WebUI.getAttribute(rtlText, "value")

		boolean isNumber = WebUI.verifyMatch(numValue, number, false)

		println "The entered number value and the number value present is matched  "+isNumber
		WebUI.switchToDefaultContent()

	}


	//########################Filling Text Box (RTL), with numbers for negative scenario################
	@Keyword
	def enterDataToNumericTextboxNegativeCase(TestObject rtlText, String number){
		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
		WebUI.switchToFrame(iFrame, 2)
		WebUI.setText(rtlText, number)

		WebUI.delay(2)

		String numVal = WebUI.getAttribute(rtlText, "value")
		WebUI.switchToDefaultContent()

	}

	//################################CheckBox######################

	@Keyword
	def selectCheckBox(TestObject checkBoxObject){
		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
		WebUI.switchToFrame(iFrame, 2)
		WebUI.check(checkBoxObject)
		WebUI.switchToDefaultContent()
	}


	//Get the row number of the form name from excel

	@Keyword
	def getRowNumberOfFormFromExcel(String formName){
		WebUI.delay(2)
		String fileName = RunConfiguration.getProjectDir()+'/Include/TestData/FormBase/USGBC-FormList.xlsx'
		String cellContent = formName


		InputStream input = new FileInputStream(fileName);

		XSSFWorkbook wb = new XSSFWorkbook(fileName)

		XSSFSheet sheet = wb.getSheetAt(0);
		for (Row row : sheet) {
			for (Cell cell : row) {
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
						println row.getRowNum();

						return row.getRowNum();
					}
				}
			}
		}

		return 0
	}

	/*
	 * Entering data to tables
	 *
	 */
	@Keyword

	def enterDataToTable(String tableName, String testData, String isAddRow) {


		String iframePath = entities.formIframe
		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,iframePath,true)
		WebUI.switchToFrame(iFrame, 1)

		println tableName
		int columnCount = findTestData("Data Files/"+testData).getColumnNumbers()
		println "Column Number"+columnCount

		int[] tableColums = new int[columnCount]

		for (int i=0;i<columnCount;i++){
			String ColuName = findTestData("Data Files/"+testData).getColumnNames()[i]
			if(ColuName.contains("SelectField")){
				tableColums[i] = 1
				println ColuName
			}
			else{
				tableColums[i] = 0
			}

			println "i value #######"+i
		}
		int cellIndex =1
		int rowCount = findTestData("Data Files/"+testData).getRowNumbers()

		for(int row=1;row<=rowCount;row++){

			println "Row index value "+row
			for(int col=1;col<=columnCount;col++)
			{

				if(tableColums[col-1] == 1 && findTestData("Data Files/"+testData).getValue(col, row) != ""){

					String xpathSelect = entities.tableSelectPrefix + tableName +entities.tableSelectSuffix+ "[" + row + "]" + "//td//select)" + '['+cellIndex+']'
					println "Inside if ###############"+xpathSelect
					TestObject tablePathSelect = new TestObject().addProperty('xpath',ConditionType.EQUALS, xpathSelect,true)
					WebUI.selectOptionByValue(tablePathSelect,findTestData("Data Files/"+testData).getValue(col, row),true)

					WebUI.delay(2)
					String cellValueSelect = WebUI.getAttribute(tablePathSelect, 'value')



					WebUI.verifyMatch(cellValueSelect, findTestData("Data Files/"+testData).getValue(col, row), false)
					cellIndex++
				}

			}

			//Reinitiailize cellindex =0 to handle input text to start from 1
			cellIndex=1
			for(int col=1;col<=columnCount;col++)
			{
				println "Cell Index"+cellIndex
				println "Column index number##############"+col
				if(tableColums[col-1] == 0 && findTestData("Data Files/"+testData).getValue(col, row) != ""){

					String xpathText = entities.tableTextPrefix+tableName+entities.tableTextSuffix+"[" + row + "]" + "//td//input[@type = 'text'])" + '['+cellIndex+']'

					TestObject tablePathText = new TestObject().addProperty('xpath',ConditionType.EQUALS,xpathText,true)
					WebUI.clearText(tablePathText)
					WebUI.setText(tablePathText, findTestData("Data Files/"+testData).getValue(col, row))

					WebUI.delay(2)

					String cellValueText = WebUI.getAttribute(tablePathText, 'value')

					WebUI.verifyMatch(cellValueText, findTestData("Data Files/"+testData).getValue(col, row), false)
					cellIndex++

				}

			}

			String xpathAdd = "(//label[contains(text(),'"+tableName+"')]/following::table[1]//td//i)"+[row]
			TestObject addIcon = new TestObject().addProperty('xpath',ConditionType.EQUALS,xpathAdd,true)

			//There are few rows which doesn't have add icon at last column ,We consider that as a static rows,
			//So to avoid failure we have to skip clicking on add icon
			if(row<rowCount && isAddRow == "Yes"){
				//To Add new row in the Table,Click on the ADD Button ICON

				WebUI.click(addIcon)
				cellIndex=1
			}

			else{
				cellIndex =1
			}

		}

		WebUI.switchToDefaultContent()
		WebUI.delay(4)
	}

	//##########################Click Save Button#######################

	@Keyword
	def clickSaveButton(){
		TestObject saveButton = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.saveButton,true)
		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
		WebUI.switchToFrame(iFrame, 2)
		WebUI.click(saveButton)
		WebUI.switchToDefaultContent()
	}

	//######################Get number of rows of uploaded files' table

	@Keyword
	def countRowsPerPage(String xpath){

		WebDriver driver = DriverFactory.getWebDriver()

		//Find the table element on the page

		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
		WebUI.switchToFrame(iFrame, 2)

		WebElement webTable=driver.findElement(By.xpath(xpath))


		List totalRowCount=webTable.findElements(By.xpath(xpath))

		//Get the size of the List, this is the number of rows
		int totalNumberOfRows=totalRowCount.size()
		println('Total Number of rows on the page:= ' + totalNumberOfRows)

		WebUI.switchToDefaultContent()

		return totalNumberOfRows

	}

	//#####################Set Download Location################################

	@Keyword
	def setDownloadPath() {

		HashMap<Object, String> chromePrefs = new HashMap<Object, String>();

		chromePrefs.put("download.default_directory", RunConfiguration.getProjectDir() + "/Include/TestData/DownloadedFiles"+"/"+GlobalVariable.currentTestCaseId)

		RunConfiguration.setWebDriverPreferencesProperty("prefs", chromePrefs)


	}

	//------------------Check whether File gets Downloaded-----------------------

	@Keyword
	def isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);

		File[] dirContents = dir.listFiles();

		String lastAttempt = '';
		String fileNameInExcel ='';
		WebUI.delay(1)

		println "######################## dowloadPath" + downloadPath
		println "######################## dirContents.length"+ dirContents.length
		if (dirContents.length > 0) {

			for (int i = 0; i < dirContents.length; i++) {

				if (dirContents[i].getName().equals(fileName)) {

					// File has been found, it can now be deleted:

					dirContents[i].delete();

					KeywordUtil.markPassed(fileName + ' exist in ' + downloadPath + ' and was deleted')
					KeywordUtil.markPassed("")
					println "Fname from folder "+dirContents[i].getName() + "equals to" + fileName
					fileNameInExcel = dirContents[i].getName()
					println "File name is = "+ fileNameInExcel
					return fileNameInExcel;


				}


				lastAttempt = dirContents[i].getName()
				println "lastAttempt is = "+ lastAttempt
			}

			if (lastAttempt != fileName) {

				KeywordUtil.markFailed(fileName + ' does not exist in ' + downloadPath)
				println "lastAttempt is = "+ lastAttempt
				return lastAttempt

			}
		}

		return false;
	}

	//##################  Mark As complete

	@Keyword
	def markAsComplete(String formName){

		String completeIcon = entities.markCompletePrefix+formName+entities.markCompleteSuffix

		TestObject markAsComplete = new TestObject().addProperty('xpath',ConditionType.EQUALS,completeIcon,true)

		WebUI.click(markAsComplete)

		WebUI.delay(5)
	}


	///###################Deleting Uploaded Files############

	@Keyword
	def deleteUploadedFiles(int fileIndex){

		String tablePath = entities.uploadedTablePrefix+fileIndex+entities.uploadedTableSuffix

		int numberOfRows = new LeedOnlineKeywords().countRowsPerPage(tablePath)
		println "Number of rows "+numberOfRows


		if (numberOfRows > 0){
			for (int k = numberOfRows; k>=1; k--) {


				TestObject  delete = new TestObject().addProperty('xpath', ConditionType.EQUALS, entities.deleteIconPrefix+fileIndex+entities.deleteIconSuffix+"["+k+"]", true)
				WebUI.delay(2)

				TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
				WebUI.switchToFrame(iFrame, 2)

				WebUI.delay(5)
				WebUI.click(delete)
				WebUI.delay(2)
				TestObject yesButton = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.yesButton,true)
				WebUI.click(yesButton)
				WebUI.switchToDefaultContent()

				WebUI.delay(2)
			}

			WebUI.delay(5)
			String uploadedFilesInTable = entities.uploadedFileTable+"["+fileIndex+"]"

			TestObject uploadedFileObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,uploadedFilesInTable,true)

			boolean isNotFound = WebUI.verifyElementNotPresent(uploadedFileObj, 2)

			println "Is uploaded files in the table not found "+isNotFound
		}
	}


	//##########################Download the uploded files

	@Keyword
	def downloadTheUploadedFiles(int fileIndex){

		String tablePath = entities.uploadedTablePrefix+fileIndex+entities.uploadedTableSuffix

		int numberOfRows = new LeedOnlineKeywords().countRowsPerPage(tablePath)
		println "Number of rows "+numberOfRows


		if (numberOfRows > 0){
			for (int k = numberOfRows; k>=1; k--) {

				TestObject  downloadXpath = new TestObject().addProperty('xpath', ConditionType.EQUALS, entities.downloadIconPrefix+fileIndex+entities.downloadIconSuffix+"["+k+"]", true)

				WebUI.delay(2)

				TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
				WebUI.switchToFrame(iFrame, 2)
				TestObject fileName =  new TestObject().addProperty('xpath', ConditionType.EQUALS, entities.uploadedFileNamePrefix+fileIndex+entities.uploadedFileNameSuffix+"["+k+"]", true)

				WebUI.delay(5)
				WebUI.click(downloadXpath)
				isFileExist(fileName)
				WebUI.mouseOver(iFrame)
				WebUI.switchToDefaultContent()
				WebUI.delay(2)
			}

			WebUI.delay(5)

		}

		String path = RunConfiguration.getProjectDir() + '/Include/TestData/DownloadedFiles'+"/"+GlobalVariable.currentTestCaseId

		for(int j=1;j<=findTestData("Data Files/TD_FileNames").getRowNumbers();j++){
			WebUI.delay(2)

			String fname = findTestData("Data Files/TD_FileNames").getValue("File Name", j)
			println fname
			String isDownloaded = new LeedOnlineKeywords().isFileDownloaded(path,fname )
			Boolean isFilePresent =  WebUI.verifyMatch(isDownloaded, fname, false)
			println isFilePresent
			println isDownloaded

			WebUI.delay(2)
		}

		deleteDownloadedFiles(path)

	}

	//####################################Delete All the Files From Downloaded Location###################

	@Keyword
	def deleteDownloadedFiles(String downloadPath){
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		println "#################"+downloadPath
		println dirContents.length
		if (dirContents.length > 0) {

			for (int i = 0; i < dirContents.length; i++) {

				String fileName = dirContents[i].getName()
				if(fileName == "creditForm.pdf"){

				}
				else{
					dirContents[i].delete();
					//return true;
				}
			}

		}

		return false
	}


	//Delete the previous creditform pdf
	@Keyword
	def deletePreviousCreditForm(String downloadPath){

		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		println "#################"+downloadPath
		println dirContents.length
		if (dirContents.length > 0) {

			for (int i = 0; i < dirContents.length; i++) {

				dirContents[i].delete();

			}

		}

		return false
	}

	//####################To fill date field

	@Keyword
	def fillingTheDateField(){

		String iframePath = entities.formIframe

		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,iframePath,true)
		WebUI.switchToFrame(iFrame, 1)

		TestObject dateTextXpath = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.dateText,true)
		WebUI.delay(2)
		WebUI.click(dateTextXpath)

		TestObject dateSelectXpath = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.dateSelect,true)
		WebUI.delay(2)
		WebUI.click(dateSelectXpath)

		WebUI.delay(2)

		String dateFilled = WebUI.getAttribute(dateTextXpath, "value")

		println "Date entered is "+dateFilled
		WebUI.switchToDefaultContent()

	}



	//Enter date for Auto save
	@Keyword
	def fillingTheDateFieldForAutosave(){

		String iframePath = entities.formIframe

		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,iframePath,true)
		WebUI.switchToFrame(iFrame, 1)

		TestObject dateTextXpath = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.dateText,true)
		WebUI.click(dateTextXpath)

		TestObject dateSelectXpath = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.dateSelectAutosave,true)
		WebUI.click(dateSelectXpath)

		WebUI.delay(2)

		String dateFilled = WebUI.getAttribute(dateTextXpath, "value")

		println "Date entered is "+dateFilled

		WebUI.verifyNotMatch(dateFilled, "", false)

		WebUI.switchToDefaultContent()

	}

	//########################Selecting check box (Both Normal and Optional)

	@Keyword
	def String getXpathForCheckBox(String nameAttr,String checkBoxType){
		String checkBoxPath

		if(checkBoxType == "option"){
			checkBoxPath = "(//div[@class='ui checkbox leed-checkbox']//input[@type='checkbox' and (@name='"+nameAttr+"')])"

		}

		else{
			checkBoxPath = "(//div[@class='ui checkbox leed-checkbox']//input[@type='checkbox' and not(@name='"+nameAttr+"')])"

		}

		return checkBoxPath
	}

	@Keyword
	def public String generateRandomString(int strLen) {

		String aToZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
		Random rand=new Random();
		StringBuilder res=new StringBuilder();
		for (int i = 0; i <strLen ; i++) {
			int randIndex=rand.nextInt(aToZ.length());
			res.append(aToZ.charAt(randIndex));
		}
		return res.toString();
	}



	@Keyword
	static void sendCommandForDownloadChromeHeadLess(HttpCommandExecutor driverCommandExecutor,SessionId sessionId,String downloadPath) {
		println "Entered now"
		println ""+driverCommandExecutor
		println ""+sessionId
		println "" +downloadPath
		Json json = new Json()

		Map<String, Object> paramsMap = new HashMap<>();
		paramsMap.put("cmd", "Page.setDownloadBehavior");


		Map<String,String> cmdParamsMap = new HashMap<>();
		cmdParamsMap.put("behavior", "allow");

		cmdParamsMap.put("downloadPath", downloadPath);

		paramsMap.put("params", cmdParamsMap);


		String content = json.toJson(paramsMap)

		URL remoteServerUri = null;
		try {

			Field field = HttpCommandExecutor.class.getDeclaredField("remoteServer")


			field.setAccessible(true);
			remoteServerUri = (URL)field.get(driverCommandExecutor);

		}catch (Exception e) {
			println "############# ERROR"+e
			println "This will cause all the file validations to fail"

			return;
		}

		CloseableHttpClient httpclient = null;

		try {


			httpclient = HttpClients.createDefault()

			URIBuilder builder = new URIBuilder(remoteServerUri.toURI())

			builder.setPath("/session/"+sessionId.toString()+"/chromium/send_command");

			HttpPost sendCommandPost = new HttpPost(builder.build())

			sendCommandPost.setHeader("Content-Type", ContentType.APPLICATION_JSON.getMimeType())



			StringEntity entity = new StringEntity(content, ContentType.APPLICATION_JSON)

			sendCommandPost.setEntity(entity);

			CloseableHttpResponse response = httpclient.execute(sendCommandPost);

			int statusCode = response.getStatusLine().getStatusCode();

			println"The Response Status code is {}" + statusCode;
			if(statusCode <= 200 && statusCode >= 300) {

				println "Failure"
			}
		}catch (IOException e) {

			println "This will cause all the file validations to fail"+e

		} catch (URISyntaxException e) {

			println "this should never ever occur"

		}
		finally {
			if(httpclient != null) {
				try {

				} catch (IOException e) {

					println "Error Occured while closing the http client" + e
				}
			}
		}

	}


	@Keyword
	def isFileExist(TestObject fileNameObject){

		String  fileNameText = WebUI.getText(fileNameObject)
		String path = RunConfiguration.getProjectDir() + '/Include/TestData/DownloadedFiles/'+GlobalVariable.currentTestCaseId+"/"+fileNameText
		println "############################## Path = "+path
		File file = new File(path);
		println "############################## file = "+file
		int i =5

		while (!file.exists()) {
			println "#### delay time is "+i
			if(i == 600){
				println "Waited for 10 minutes, unable to download because of network failure/internet issue"

				break
			}

			else{
				println "Waiting for file to download"
				WebUI.delay(i)
				i= i+5
			}
		}
	}

	//To uncheck optional checkbox

	@Keyword
	def public isChecked(String xpath){
		WebDriver driver = DriverFactory.getWebDriver()

		String iframePath = entities.formIframe

		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,iframePath,true)
		WebUI.switchToFrame(iFrame, 1)
		WebElement checkbox =driver.findElement(By.xpath(xpath))
		if(checkbox.isSelected()){
			println"Checked ##########"
			checkbox.click()
		}
		WebUI.switchToDefaultContent()




	}


	//Clear Draft

	@Keyword
	def clearTheDraft(){

		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
		TestObject clearDraft = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.clearDraft,true)
		TestObject yesButton = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.yesButton,true)
		WebUI.delay(4)
		WebUI.switchToFrame(iFrame, 2)
		WebUI.click(clearDraft)
		WebUI.delay(2)
		WebUI.click(yesButton)
		WebUI.delay(5)
		WebUI.verifyElementNotPresent(clearDraft, 2)
		WebUI.switchToDefaultContent()

	}


	//get Narrative Text

	@Keyword
	def String getNarrativeText(){
		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
		TestObject editorFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.narrative+"[1]",true)
		TestObject editorBody = new TestObject().addProperty('xpath',ConditionType.EQUALS,"//body",true)

		WebUI.switchToFrame(iFrame, 2)
		WebUI.switchToFrame(editorFrame, 2)
		String textValue = WebUI.getText(editorBody)
		WebUI.switchToDefaultContent()
		return textValue
	}


	@Keyword

	def public clickGeneratedPdfIcon(){

		String path = RunConfiguration.getProjectDir() + '/Include/TestData/DownloadedFiles' +"/"+GlobalVariable.currentTestCaseId
		File folder = new File(path)

		if(folder.exists()){
			deletePreviousCreditForm(path)
		}
		TestObject pdfButton = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.verifypdf,true)
		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
		WebUI.switchToFrame(iFrame, 2)
		WebUI.click(pdfButton)
		WebUI.delay(15)
		WebUI.switchToDefaultContent()

		WebUI.delay(6)
	}


	@Keyword
	def public String readPdf(){

		String pdf = RunConfiguration.getProjectDir()+"/Include/TestData/DownloadedFiles/"+GlobalVariable.currentTestCaseId+"/creditForm.pdf"
		PDFUtil pdfUtil1 = new PDFUtil()
		String file = pdfUtil1.getText(pdf)

		return file
	}

	@Keyword
	def public verifyNarrativeTextFromPdf(int index){

		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
		String flag = "Found"
		String file = readPdf()

		for(int i=1;i<=index;i++){
			WebUI.switchToFrame(iFrame, 4)

			TestObject narrativeFrameObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.narrative+"["+i+"]",true)
			WebUI.switchToFrame(narrativeFrameObj, 2)
			TestObject editorBody = new TestObject().addProperty('xpath',ConditionType.EQUALS,"//body",true)
			String narrativeContent = WebUI.getText(editorBody)

			println narrativeContent
			if (file.contains(narrativeContent)){
				println('Found Text')
				if(flag != "NotFound"){
					flag = "Found"
				}
			}
			else{
				println "Not found"
				flag = "NotFound"
			}
			WebUI.switchToDefaultContent()
		}
		return flag

	}


	@Keyword

	def public verifyTextBoxValueFromPdf(TestObject textObj){

		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
		String flag = "Found"
		String file = readPdf()
		WebUI.switchToFrame(iFrame, 2)
		String rtlValue = WebUI.getText(textObj)
		println rtlValue

		if (file.contains(rtlValue)){
			println('Found Text')

			if(flag != "NotFound"){
				flag = "Found"
			}
		}
		else{
			println "Not found"
			flag = "NotFound"
		}

		WebUI.switchToDefaultContent()
		return flag

	}

	/*
	 * 
	 * Verify Date with pdf and form page
	 */

	@Keyword

	def public verifyDateFromPdf(TestObject dateObj){
		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
		String flag = "Found"
		String file = readPdf()
		WebUI.switchToFrame(iFrame, 2)
		String dateValue = WebUI.getAttribute(dateObj,'value')
		println dateValue
		if (file.contains(dateValue)){
			println('Found Text')

			if(flag != "NotFound"){
				flag = "Found"
			}
		}
		else{
			println "Not found"
			flag = "NotFound"
		}

		WebUI.switchToDefaultContent()
		return flag

	}

	@Keyword
	def verifyTableContentFromPdf(int index){

		String flag= "Found"
		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)

		for(int i=1;i<=index;i++){
			String pdf = RunConfiguration.getProjectDir()+"/Include/TestData/DownloadedFiles/"+GlobalVariable.currentTestCaseId+"/creditForm.pdf"

			String tablePath = "(//table[not(@class='ui collapsing celled table unstackable')])"+"["+i+"]"
			PDFUtil pdfUtil1 = new PDFUtil()
			String file = pdfUtil1.getText(pdf)
			WebUI.delay(8)
			println(file)
			WebDriver webDriver = DriverFactory.getWebDriver()
			WebUI.switchToFrame(iFrame, 4)

			WebElement table = webDriver.findElement(By.xpath(tablePath))
			List<WebElement> rowTable = table.findElements(By.tagName('tr'))
			int rowsCount = rowTable.size()
			println "Number of rows: "+rowsCount
			for (int row =2 ;row < rowsCount;row++){
				List<WebElement> column_row = rowTable.get(row).findElements(By.tagName('td'))
				List<WebElement> getText = rowTable.get(row).findElements(By.tagName('input'))
				int columnCount = getText.size()

				println "Number of columns : "+columnCount
				println('Number of cells in row\t'+ row + '\tare\t'+ columnCount)
				for (int column = 0; column <columnCount; column++){
					String getTextContent = getText.get(column).getAttribute("value")
					println(getTextContent)
					if (file.contains(getTextContent)){
						println('Found Text')

						if(flag != "Not Found"){
							flag= "Found"
						}
					}

					else{

						flag = "NotFound"
					}
				}

			}
			WebUI.switchToDefaultContent()
		}
		return flag
	}
	//####################################Delete pdf From Downloaded Location###################

	@Keyword
	def deletePdfFile(){
		File dir = new File(RunConfiguration.getProjectDir()+'/Include/TestData/DownloadedFiles'+"/"+GlobalVariable.currentTestCaseId)
		File[] dirContents = dir.listFiles();


		println dirContents.length
		if (dirContents.length > 0) {

			for (int i = 0; i < dirContents.length; i++) {

				dirContents[i].delete();
			}

		}

		return false
	}

	//To check whether revision icon is present

	@Keyword
	def checkRevisionIcon(){
		TestObject revisionIconObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.rivisionIcon,true)
		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
		WebUI.switchToFrame(iFrame, 4)
		boolean isIconPresent = WebUI.verifyElementPresent(revisionIconObj, 3)
		println "Presence of rivision Icon: "+isIconPresent
		WebUI.switchToDefaultContent()

	}

	//Keyword to delete Table rows

	@Keyword

	def deleteTableRows(String tableName,String testData){

		String iframePath = entities.formIframe
		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,iframePath,true)
		WebDriver webDriver = DriverFactory.getWebDriver()
		WebUI.switchToFrame(iFrame, 1)

		int rowCount = findTestData("Data Files/"+testData).getRowNumbers()
		String xpathIcon = "(//label[contains(text(),'"+tableName+"')]/following::table[1]//td//i[@class='minus icon'])"

		String tableXpath = "(//label[contains(text(),'"+tableName+"')]/following::table[1])"

		WebElement table = webDriver.findElement(By.xpath(tableXpath))
		List<WebElement> rowTable = table.findElements(By.xpath(xpathIcon))
		int rowsCount = rowTable.size()
		println "Number of Delete icon rows "+rowsCount
		for(int row=rowsCount; row>=1;row--){
			println row
			String xpathDelete = "(//label[contains(text(),'"+tableName+"')]/following::table[1]//td//i[@class='minus icon'])"+[row]
			TestObject deleteIcon = new TestObject().addProperty('xpath',ConditionType.EQUALS,xpathDelete,true)
			WebUI.click(deleteIcon)
			WebUI.delay(2)

		}
		WebUI.switchToDefaultContent()
	}

	//Keyword to cancel while deleting the uploaded file

	@Keyword

	def clickCancelWhileDeletingFile(){
		TestObject  delete = new TestObject().addProperty('xpath', ConditionType.EQUALS, entities.deleteIconPrefix+"1"+entities.deleteIconSuffix+"[1]", true)
		String iframePath = entities.formIframe
		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,iframePath,true)
		TestObject cancleBtn = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.cancelButton,true)
		WebUI.switchToFrame(iFrame, 2)
		WebUI.click(delete)
		WebUI.delay(2)
		WebUI.click(cancleBtn)
		WebUI.delay(3)

		TestObject fileName = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.fileNameColumn,true)
		boolean isNotDeleted =  WebUI.verifyElementPresent(fileName, 2)

		println "Status whether file Not deleted "+ isNotDeleted

		WebUI.switchToDefaultContent()
	}

	//Keyword to verify the uploaded files

	@Keyword
	def verifyUploadedFiles(int fileIndex){
		String iframePath = entities.formIframe
		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,iframePath,true)

		println "Inside Iframe"
		String tablePath = entities.uploadedTablePrefix+fileIndex+entities.uploadedTableSuffix
		String statusMatch
		int numberOfRows = new LeedOnlineKeywords().countRowsPerPage(tablePath)
		println "Number of rows "+numberOfRows

		WebUI.switchToFrame(iFrame, 2)
		if (numberOfRows > 0){

			for (int k=1;k <= numberOfRows; k++) {
				TestObject fileNameObj =  new TestObject().addProperty('xpath', ConditionType.EQUALS, entities.uploadedFileNamePrefix+fileIndex+entities.uploadedFileNameSuffix+"["+k+"]", true)
				String  fileNameText = WebUI.getText(fileNameObj)
				println "Inside table "+fileNameText
				String isFileMatched = getFileNamesFromExcel(fileNameText)
				println "After File matched " + isFileMatched

				WebUI.verifyMatch(fileNameText, isFileMatched, false, FailureHandling.CONTINUE_ON_FAILURE)

			}
			WebUI.switchToDefaultContent()

		}

	}

	//Get file names from the Excel

	@Keyword
	def getFileNamesFromExcel(String fileName){
		String fileNameInExcel
		for(int j=1;j<=findTestData("Data Files/TD_FileNames").getRowNumbers();j++){
			WebUI.delay(2)

			fileNameInExcel = findTestData("Data Files/TD_FileNames").getValue("File Name", j)
			println fileNameInExcel

			if(fileNameInExcel.equals(fileName)){
				println fileNameInExcel +" is equal to "+fileName

				KeywordUtil.markPassed(fileNameInExcel+ ' is equal to '+fileName)

				return fileNameInExcel

			}

		}

		if(fileNameInExcel!=fileName){
			KeywordUtil.markFailed(fileNameInExcel + " is not equal to "+ fileName)

			return fileNameInExcel
		}


	}


	//Verify the uploaded files from the generated pdf

	@Keyword
	def verifyUploadedFilesFromPdf(int fileIndex){

		String flag= "Found"
		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
		WebUI.switchToFrame(iFrame, 2)

		String pdf = RunConfiguration.getProjectDir()+"/Include/TestData/DownloadedFiles/"+GlobalVariable.currentTestCaseId+"/creditForm.pdf"
		String tablePath = entities.uploadedFileTable+"["+fileIndex+"]"

		PDFUtil pdfUtil1 = new PDFUtil()

		String file = pdfUtil1.getText(pdf)
		println(file)
		WebDriver webDriver = DriverFactory.getWebDriver()
		WebElement table = webDriver.findElement(By.xpath(tablePath))
		List<WebElement> rowTable = table.findElements(By.tagName('tr'))
		int rowsCount = rowTable.size()
		println "Number of rows: "+rowsCount
		for (int row =2 ;row < rowsCount;row++){
			List<WebElement> columnRow = rowTable.get(row).findElements(By.tagName('td'))

			int columnCount = columnRow.size()

			println "Number of columns : "+columnCount
			println('Number of cells in row\t'+ row + '\tare\t'+ columnCount)
			for (int column = 0; column <2; column++){
				String gettext = columnRow.get(column).getText()
				println(gettext)
				if (file.contains(gettext)){
					println('Found Text')

					if(flag != "NotFound"){

						flag = "Found"
					}

				}

				else{
					flag = "NotFound"
				}
			}

		}

		WebUI.switchToDefaultContent()
		return flag

	}


	//To Check/Uncheck optional checkbox

	@Keyword
	def public checkOrUncheckCheckbox(String xpath){
		WebDriver driver = DriverFactory.getWebDriver()

		String iframePath = entities.formIframe

		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,iframePath,true)
		WebUI.switchToFrame(iFrame, 1)
		WebElement checkBox =driver.findElement(By.xpath(xpath))
		if(checkBox.isSelected()){
			println"Checked ##########"
			checkBox.click()
		}

		else{
			checkBox.click()
		}
		WebUI.switchToDefaultContent()

	}

	/*
	 * 
	 * Changing the units from IP <--> SI
	 */

	String nameOfTheForm
	int rowNum

	@Keyword
	def changeUnitsType(String unitType, formName,rating){ //, table_name, testData

		WebUI.back()
		WebUI.delay(2)

		TestObject details = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.details,true)
		println "##################### Before Details clicked "
		WebUI.click(details)
		println "##################### After Details clicked "

		WebUI.delay(2)
		TestObject editBtn = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.editBtn,true)
		println "##################### Before EditBtn clicked "
		WebUI.click(editBtn)
		println "##################### After EditBtn clicked "

		TestObject popup = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.popup,true)
		println "##################### Before Verify Popup "
		WebUI.verifyElementPresent(popup, 30)
		println "##################### After Verify Popup "

		WebUI.delay(7)
		if(unitType=="IP"){
			TestObject unitsIP = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.Units_IP,true)
			println "##################### Before Units_IP clicked "
			WebUI.click(unitsIP)
			println "##################### After Units_IP clicked "
		}
		else if(unitType=="SI"){
			TestObject unitsSI = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.Units_SI,true)
			println "##################### Before Units_SI clicked "
			WebUI.click(unitsSI)
			println "##################### After Units_SI clicked "
		}
		else{
			println "Use Unit types SI or IP"
		}
		WebUI.delay(2)
		TestObject updateBtn = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.Update,true)
		println "##################### Before UpdateBtn clicked "
		WebUI.delay(2)
		WebUI.submit(updateBtn)
		println "##################### After UpdateBtn clicked "
		WebUI.delay(5)
		TestObject creditsBtn = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.creditsBtn,true)
		println "##################### Before creditsBtn clicked "
		WebUI.delay(2)
		WebUI.click(creditsBtn)
		println "##################### After creditsBtn clicked "
		WebUI.delay(3)

		println "formName***"+formName

		int formRow = new LeedOnlineKeywords().getRowNumberOfFormFromExcel(formName)
		rowNum = formRow

		println "rowNum**********"+ rowNum

		String getFormName = findTestData("Data Files/TD_FormElements").getValue("Form Name", rowNum)

		nameOfTheForm =getFormName
		println "nameOfTheForm*******:"+nameOfTheForm
		String formNamePath = entities.scoreCard+nameOfTheForm+"'])"
		TestObject formNameObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,formNamePath,true)
		WebUI.click(formNameObj)
		WebUI.delay(3)

		String formVPath = entities.scoreCard+nameOfTheForm+entities.scorecardFormSuffix
		TestObject formV1 = new TestObject().addProperty('xpath',ConditionType.EQUALS,formVPath,true)
		WebUI.click(formV1)
		WebUI.delay(3)


	}


	@Keyword
	def tableColumnWithUnitType(int index){

		Map<Integer,ArrayList<String>> map = new HashMap<>()
		Map<Integer,ArrayList<String>> map1 = new HashMap<>()


		for(int i=1;i<=index;i++){
			println "inside if and value of i ***:" +i
			String tablePath = "(//table[not(@class='ui collapsing celled table unstackable')])"+"["+i+"]"
			println "tablepath*******:"+tablePath

			String iframePath = entities.formIframe
			TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,iframePath,true)
			WebUI.switchToFrame(iFrame, 1)

			WebDriver driver = DriverFactory.getWebDriver()
			WebElement table = driver.findElement(By.xpath(tablePath))

			List<WebElement> getText = table.findElements(By.tagName('th'))
			List<WebElement> rowsTable = table.findElements(By.tagName('tr'))
			List<WebElement> rowText = table.findElements(By.tagName('td'))

			int columnCount = getText.size()
			int rowCount = rowText.size()

			println "column_count******* :" +columnCount
			println "row_count******* :" +rowCount

			List<String> allList = new ArrayList<>()
			for (int column = 0; column <columnCount; column++){
				String getColumnText = getText.get(column).getText()

				if(getColumnText.contains("(")){
					allList.add(getColumnText);
					println "Col list******* :" +allList
				}
			}
			map.put(i,allList);

			for (int row = 0; row <rowCount; row++){
				String getRowText = rowText.get(row).getText()

				if(getRowText.contains("(")){
					allList.add(getRowText);
				}
			}
			map.put(i,allList);
			WebUI.switchToDefaultContent()
		}
		return map;
	}


	@Keyword
	def textBoxWithUnitType(int index){

		Map<Integer,ArrayList<String>> map = new HashMap<>()
		List<String> txtList = new ArrayList<>()

		for(int i=1;i<=index;i++){

			String textBoxXpath = "(//div[@class='leed-single-row']//div[1])"+"["+i+"]"

			String iframePath = entities.formIframe
			TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,iframePath,true)
			WebUI.switchToFrame(iFrame, 1)

			WebDriver driver = DriverFactory.getWebDriver()
			WebElement textBox = driver.findElement(By.xpath(textBoxXpath))
			String txtValue=textBox.getText();

			println "textbox value is ********** : "+txtValue

			if(txtValue.contains("(")){
				txtList.add(txtValue)
			}
			map.put(i,txtList);
			WebUI.switchToDefaultContent()
		}
		return map
	}

	/*
	 * 
	 * Keyword for selecting the options from select dropdown
	 */

	@Keyword
	def selectOptionFromDropdown(String optionValue, int fieldIndex){

		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
		WebUI.switchToFrame(iFrame, 1)
		TestObject selectbDropDownObject = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.selectDropDown+"["+fieldIndex+"]",true)
		WebUI.selectOptionByValue(selectbDropDownObject, optionValue, true)

		WebUI.delay(3)

		String selectedValue = WebUI.getAttribute(selectbDropDownObject, 'value')

		WebUI.verifyMatch(selectedValue, optionValue, false)

		WebUI.switchToDefaultContent()

	}

	/*
	 * Verify select dropdown value with page and pdf
	 * 
	 */

	@Keyword
	def verifySelectedOptionFromPdf(int fieldIndex){
		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
		String flag = "Found"
		String file = readPdf()
		TestObject selectbDropDownObject = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.selectDropDown+"["+fieldIndex+"]",true)

		WebUI.switchToFrame(iFrame, 2)
		String selectedValue = WebUI.getAttribute(selectbDropDownObject,'value')
		println selectedValue
		if (file.contains(selectedValue)){
			println('Found Text')

			if(flag != "NotFound"){
				flag = "Found"
			}
		}
		else{
			println "Not found"
			flag = "NotFound"
		}

		WebUI.switchToDefaultContent()
		return flag

	}


	//Uploading 100MB file
	@Keyword
	def uploadFileForNegativeCases(int addFileIndex,String fileName){

		String filePath = RunConfiguration.getProjectDir()+'/Include/TestData/NegativeFiles/'+fileName
		String elementPath = entities.addFile+'['+addFileIndex+']'
		println "Path inside Keyword "+elementPath
		String iframePath = entities.formIframe
		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,iframePath,true)
		WebUI.switchToFrame(iFrame, 1)
		TestObject inputField  = new TestObject().addProperty('xpath', ConditionType.EQUALS, elementPath, true)
		println "tiny ui button "+ entities.AddFileEnabled+addFileIndex+"]"
		TestObject waitEnabled = new TestObject().addProperty('xpath', ConditionType.EQUALS, entities.AddFileEnabled+addFileIndex+"]", true)
		WebUI.waitForElementAttributeValue(waitEnabled, 'class', 'tiny ui button', 20)
		WebUI.delay(1)
		WebUI.uploadFile(inputField, filePath)
		WebUI.switchToDefaultContent()
	}

	//Clearing all the data in the form

	@Keyword
	def clearTheEntireForm(int rowNum){

		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
		String narrativeCount = findTestData("Data Files/TD_FormElements").getValue("Narrative", rowNum)
		println "Number of Narrative "+narrativeCount
		int totalNumberOfNarrative = Integer.parseInt(narrativeCount)
		if(totalNumberOfNarrative>0){
			for(int i=1;i<=totalNumberOfNarrative;i++){
				String narrativeXpath = entities.narrative+'['+i+']'

				TestObject narrativeFrameObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,narrativeXpath,true)
				TestObject editorBody = new TestObject().addProperty('xpath',ConditionType.EQUALS,"//body",true)
				WebUI.switchToFrame(iFrame, 1)
				WebUI.switchToFrame(narrativeFrameObj, 2)
				WebUI.clearText(editorBody)
				WebUI.switchToDefaultContent()
			}
		}
		String textNumberCount = findTestData("Data Files/TD_FormElements").getValue("Text Box", rowNum)
		println "Number of text "+textNumberCount
		int totalTextBoxNumber = Integer.parseInt(textNumberCount)

		if(totalTextBoxNumber>0){

			for(int i=1;i<=totalTextBoxNumber;i++){
				TestObject textBoxObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.textMedium+"["+i+"]",true)
				WebUI.switchToFrame(iFrame, 1)
				WebUI.delay(2)
				println "Inside frame"
				WebUI.setText(textBoxObj," ")
				WebUI.delay(2)
				WebUI.switchToDefaultContent()
			}
		}


		String textRtlCount = findTestData("Data Files/TD_FormElements").getValue("Text Box for Numbers", rowNum)
		println "Number of rtl "+textRtlCount
		int totalTextRtlCount = Integer.parseInt(textRtlCount)

		if(totalTextRtlCount>0){

			for(int i=1;i<=totalTextRtlCount;i++){
				TestObject textBoxRtlObj = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.textRtl+"["+i+"]",true)
				WebUI.switchToFrame(iFrame, 1)
				WebUI.setText(textBoxRtlObj," ")
				WebUI.switchToDefaultContent()
			}
		}
	}
	@Keyword
	def getBrowserName(){

		RemoteWebDriver driver = DriverFactory.getWebDriver()
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		println "The browserName is ########### " + browserName
		return browserName

	}

	@Keyword
	def public String takeScreenshot(ExtentTest loginfo) {
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_")+ ".png";
		String dest=WebUI.takeScreenshot(System.getProperty("user.dir") + "/screenshots/" + screenshotFile)
		println "dest---->"+ System.getProperty("user.dir") + "/screenshots/"
		WebDriver driver=DriverFactory.getWebDriver()
		TakesScreenshot screen =(TakesScreenshot) driver;
		File src =screen.getScreenshotAs(OutputType.FILE);

		File target = new File(dest,screenshotFile);
		FileUtils.copyFile(src,target);
//		return dest;
//		return screenshotFile
		return target.getName()
	}
//	@Keyword
//	public static String takeScreenshot(final RemoteWebDriver webDriver) {
//		Date d = new Date();
//		String imageName = d.toString().replace(":", "_").replace(" ", "_")+ ".png";
//		File screenshotFile = webDriver.getScreenshotAs(OutputType.FILE);
//		String screenShotsDirectory=System.getProperty("user.dir")+"/ExtentReport/Chrome_Report/screenshots"
//		File targetFile = new File(screenShotsDirectory, imageName);
//		
//			FileUtils.copyFile(screenshotFile, targetFile);
//		
//		return targetFile.getName();
//	}

	@Keyword

	def public click_pdf_Icon(){

		String path = RunConfiguration.getProjectDir() + '/Include/TestData/DownloadedFiles'+"/"+GlobalVariable.currentTestCaseId
		File folder = new File(path)

		if(folder.exists()){
			deletePreviousCreditForm(path)
		}

		TestObject pdfButton = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.verifypdf,true)
		TestObject iFrame = new TestObject().addProperty('xpath',ConditionType.EQUALS,entities.formIframe,true)
		WebUI.switchToFrame(iFrame, 2)
		WebUI.click(pdfButton)
		WebUI.delay(15)
		WebUI.switchToDefaultContent()
		//isFiledownloaded("", "")
		WebUI.delay(6)
	}

	/*	@Keyword
	 public void before(Scenario scenario) {
	 String sName = scenario.getName(); //getKeyword()  //getDescription()//getName();
	 GlobalVariable.scenarioName=sName
	 println "##############"+sName  //GlobalVariable.scenarioName
	 }*/
}
