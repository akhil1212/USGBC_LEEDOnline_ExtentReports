
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject

import org.openqa.selenium.remote.HttpCommandExecutor

import org.openqa.selenium.remote.SessionId

import org.openqa.selenium.remote.RemoteWebDriver


def static "projectKeywords.LeedOnlineKeywords.navigateToForm"(
    	String formName	) {
    (new projectKeywords.LeedOnlineKeywords()).navigateToForm(
        	formName)
}

def static "projectKeywords.LeedOnlineKeywords.uploadFilesToAddfile"(
    	int addFileIndex	) {
    (new projectKeywords.LeedOnlineKeywords()).uploadFilesToAddfile(
        	addFileIndex)
}

def static "projectKeywords.LeedOnlineKeywords.fillingNarrative"(
    	String narrativeFrameXpath	
     , 	String data	) {
    (new projectKeywords.LeedOnlineKeywords()).fillingNarrative(
        	narrativeFrameXpath
         , 	data)
}

def static "projectKeywords.LeedOnlineKeywords.selectRadioButton"(
    	TestObject radioBtnXpath	) {
    (new projectKeywords.LeedOnlineKeywords()).selectRadioButton(
        	radioBtnXpath)
}

def static "projectKeywords.LeedOnlineKeywords.enterTextBoxData"(
    	TestObject textBoxObject	
     , 	String textValue	) {
    (new projectKeywords.LeedOnlineKeywords()).enterTextBoxData(
        	textBoxObject
         , 	textValue)
}

def static "projectKeywords.LeedOnlineKeywords.enterTextBoxDataForNegativeCase"(
    	TestObject textBoxObject	
     , 	String textValue	) {
    (new projectKeywords.LeedOnlineKeywords()).enterTextBoxDataForNegativeCase(
        	textBoxObject
         , 	textValue)
}

def static "projectKeywords.LeedOnlineKeywords.enterDataToNumericTextbox"(
    	TestObject rtlText	
     , 	String number	) {
    (new projectKeywords.LeedOnlineKeywords()).enterDataToNumericTextbox(
        	rtlText
         , 	number)
}

def static "projectKeywords.LeedOnlineKeywords.enterDataToNumericTextboxNegativeCase"(
    	TestObject rtlText	
     , 	String number	) {
    (new projectKeywords.LeedOnlineKeywords()).enterDataToNumericTextboxNegativeCase(
        	rtlText
         , 	number)
}

def static "projectKeywords.LeedOnlineKeywords.selectCheckBox"(
    	TestObject checkBoxObject	) {
    (new projectKeywords.LeedOnlineKeywords()).selectCheckBox(
        	checkBoxObject)
}

def static "projectKeywords.LeedOnlineKeywords.getRowNumberOfFormFromExcel"(
    	String formName	) {
    (new projectKeywords.LeedOnlineKeywords()).getRowNumberOfFormFromExcel(
        	formName)
}

def static "projectKeywords.LeedOnlineKeywords.enterDataToTable"(
    	String tableName	
     , 	String testData	
     , 	String isAddRow	) {
    (new projectKeywords.LeedOnlineKeywords()).enterDataToTable(
        	tableName
         , 	testData
         , 	isAddRow)
}

def static "projectKeywords.LeedOnlineKeywords.clickSaveButton"() {
    (new projectKeywords.LeedOnlineKeywords()).clickSaveButton()
}

def static "projectKeywords.LeedOnlineKeywords.countRowsPerPage"(
    	String xpath	) {
    (new projectKeywords.LeedOnlineKeywords()).countRowsPerPage(
        	xpath)
}

def static "projectKeywords.LeedOnlineKeywords.setDownloadPath"() {
    (new projectKeywords.LeedOnlineKeywords()).setDownloadPath()
}

def static "projectKeywords.LeedOnlineKeywords.isFileDownloaded"(
    	String downloadPath	
     , 	String fileName	) {
    (new projectKeywords.LeedOnlineKeywords()).isFileDownloaded(
        	downloadPath
         , 	fileName)
}

def static "projectKeywords.LeedOnlineKeywords.markAsComplete"(
    	String formName	) {
    (new projectKeywords.LeedOnlineKeywords()).markAsComplete(
        	formName)
}

def static "projectKeywords.LeedOnlineKeywords.deleteUploadedFiles"(
    	int fileIndex	) {
    (new projectKeywords.LeedOnlineKeywords()).deleteUploadedFiles(
        	fileIndex)
}

def static "projectKeywords.LeedOnlineKeywords.downloadTheUploadedFiles"(
    	int fileIndex	) {
    (new projectKeywords.LeedOnlineKeywords()).downloadTheUploadedFiles(
        	fileIndex)
}

def static "projectKeywords.LeedOnlineKeywords.deleteDownloadedFiles"(
    	String downloadPath	) {
    (new projectKeywords.LeedOnlineKeywords()).deleteDownloadedFiles(
        	downloadPath)
}

def static "projectKeywords.LeedOnlineKeywords.deletePreviousCreditForm"(
    	String downloadPath	) {
    (new projectKeywords.LeedOnlineKeywords()).deletePreviousCreditForm(
        	downloadPath)
}

def static "projectKeywords.LeedOnlineKeywords.fillingTheDateField"() {
    (new projectKeywords.LeedOnlineKeywords()).fillingTheDateField()
}

def static "projectKeywords.LeedOnlineKeywords.fillingTheDateFieldForAutosave"() {
    (new projectKeywords.LeedOnlineKeywords()).fillingTheDateFieldForAutosave()
}

def static "projectKeywords.LeedOnlineKeywords.getXpathForCheckBox"(
    	String nameAttr	
     , 	String checkBoxType	) {
    (new projectKeywords.LeedOnlineKeywords()).getXpathForCheckBox(
        	nameAttr
         , 	checkBoxType)
}

def static "projectKeywords.LeedOnlineKeywords.generateRandomString"(
    	int strLen	) {
    (new projectKeywords.LeedOnlineKeywords()).generateRandomString(
        	strLen)
}

def static "projectKeywords.LeedOnlineKeywords.sendCommandForDownloadChromeHeadLess"(
    	HttpCommandExecutor driverCommandExecutor	
     , 	SessionId sessionId	
     , 	String downloadPath	) {
    (new projectKeywords.LeedOnlineKeywords()).sendCommandForDownloadChromeHeadLess(
        	driverCommandExecutor
         , 	sessionId
         , 	downloadPath)
}

def static "projectKeywords.LeedOnlineKeywords.isFileExist"(
    	TestObject fileNameObject	) {
    (new projectKeywords.LeedOnlineKeywords()).isFileExist(
        	fileNameObject)
}

def static "projectKeywords.LeedOnlineKeywords.isChecked"(
    	String xpath	) {
    (new projectKeywords.LeedOnlineKeywords()).isChecked(
        	xpath)
}

def static "projectKeywords.LeedOnlineKeywords.clearTheDraft"() {
    (new projectKeywords.LeedOnlineKeywords()).clearTheDraft()
}

def static "projectKeywords.LeedOnlineKeywords.getNarrativeText"() {
    (new projectKeywords.LeedOnlineKeywords()).getNarrativeText()
}

def static "projectKeywords.LeedOnlineKeywords.clickGeneratedPdfIcon"() {
    (new projectKeywords.LeedOnlineKeywords()).clickGeneratedPdfIcon()
}

def static "projectKeywords.LeedOnlineKeywords.readPdf"() {
    (new projectKeywords.LeedOnlineKeywords()).readPdf()
}

def static "projectKeywords.LeedOnlineKeywords.verifyNarrativeTextFromPdf"(
    	int index	) {
    (new projectKeywords.LeedOnlineKeywords()).verifyNarrativeTextFromPdf(
        	index)
}

def static "projectKeywords.LeedOnlineKeywords.verifyTextBoxValueFromPdf"(
    	TestObject textObj	) {
    (new projectKeywords.LeedOnlineKeywords()).verifyTextBoxValueFromPdf(
        	textObj)
}

def static "projectKeywords.LeedOnlineKeywords.verifyDateFromPdf"(
    	TestObject dateObj	) {
    (new projectKeywords.LeedOnlineKeywords()).verifyDateFromPdf(
        	dateObj)
}

def static "projectKeywords.LeedOnlineKeywords.verifyTableContentFromPdf"(
    	int index	) {
    (new projectKeywords.LeedOnlineKeywords()).verifyTableContentFromPdf(
        	index)
}

def static "projectKeywords.LeedOnlineKeywords.deletePdfFile"() {
    (new projectKeywords.LeedOnlineKeywords()).deletePdfFile()
}

def static "projectKeywords.LeedOnlineKeywords.checkRevisionIcon"() {
    (new projectKeywords.LeedOnlineKeywords()).checkRevisionIcon()
}

def static "projectKeywords.LeedOnlineKeywords.deleteTableRows"(
    	String tableName	
     , 	String testData	) {
    (new projectKeywords.LeedOnlineKeywords()).deleteTableRows(
        	tableName
         , 	testData)
}

def static "projectKeywords.LeedOnlineKeywords.clickCancelWhileDeletingFile"() {
    (new projectKeywords.LeedOnlineKeywords()).clickCancelWhileDeletingFile()
}

def static "projectKeywords.LeedOnlineKeywords.verifyUploadedFiles"(
    	int fileIndex	) {
    (new projectKeywords.LeedOnlineKeywords()).verifyUploadedFiles(
        	fileIndex)
}

def static "projectKeywords.LeedOnlineKeywords.getFileNamesFromExcel"(
    	String fileName	) {
    (new projectKeywords.LeedOnlineKeywords()).getFileNamesFromExcel(
        	fileName)
}

def static "projectKeywords.LeedOnlineKeywords.verifyUploadedFilesFromPdf"(
    	int fileIndex	) {
    (new projectKeywords.LeedOnlineKeywords()).verifyUploadedFilesFromPdf(
        	fileIndex)
}

def static "projectKeywords.LeedOnlineKeywords.checkOrUncheckCheckbox"(
    	String xpath	) {
    (new projectKeywords.LeedOnlineKeywords()).checkOrUncheckCheckbox(
        	xpath)
}

def static "projectKeywords.LeedOnlineKeywords.changeUnitsType"(
    	String unitType	
     , 	Object formName	
     , 	Object rating	) {
    (new projectKeywords.LeedOnlineKeywords()).changeUnitsType(
        	unitType
         , 	formName
         , 	rating)
}

def static "projectKeywords.LeedOnlineKeywords.tableColumnWithUnitType"(
    	int index	) {
    (new projectKeywords.LeedOnlineKeywords()).tableColumnWithUnitType(
        	index)
}

def static "projectKeywords.LeedOnlineKeywords.textBoxWithUnitType"(
    	int index	) {
    (new projectKeywords.LeedOnlineKeywords()).textBoxWithUnitType(
        	index)
}

def static "projectKeywords.LeedOnlineKeywords.selectOptionFromDropdown"(
    	String optionValue	
     , 	int fieldIndex	) {
    (new projectKeywords.LeedOnlineKeywords()).selectOptionFromDropdown(
        	optionValue
         , 	fieldIndex)
}

def static "projectKeywords.LeedOnlineKeywords.verifySelectedOptionFromPdf"(
    	int fieldIndex	) {
    (new projectKeywords.LeedOnlineKeywords()).verifySelectedOptionFromPdf(
        	fieldIndex)
}

def static "projectKeywords.LeedOnlineKeywords.uploadFileForNegativeCases"(
    	int addFileIndex	
     , 	String fileName	) {
    (new projectKeywords.LeedOnlineKeywords()).uploadFileForNegativeCases(
        	addFileIndex
         , 	fileName)
}

def static "projectKeywords.LeedOnlineKeywords.clearTheEntireForm"(
    	int rowNum	) {
    (new projectKeywords.LeedOnlineKeywords()).clearTheEntireForm(
        	rowNum)
}

def static "projectKeywords.LeedOnlineKeywords.getBrowserName"() {
    (new projectKeywords.LeedOnlineKeywords()).getBrowserName()
}

def static "projectKeywords.LeedOnlineKeywords.takeScreenshot"(
    	RemoteWebDriver webDriver	) {
    (new projectKeywords.LeedOnlineKeywords()).takeScreenshot(
        	webDriver)
}

def static "projectKeywords.LeedOnlineKeywords.click_pdf_Icon"() {
    (new projectKeywords.LeedOnlineKeywords()).click_pdf_Icon()
}
