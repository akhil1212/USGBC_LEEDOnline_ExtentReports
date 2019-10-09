import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/FunctionalTesting/TS_OM_ExistingBuildings')

suiteProperties.put('name', 'TS_OM_ExistingBuildings')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("H:\\Git Projects\\USGBC_LEEDOnline_ExtentReports\\USGBC_LEEDOnline_ExtentReports\\USGBC_LEED\\Reports\\20191009_105114\\FunctionalTesting\\TS_OM_ExistingBuildings\\20191009_105114\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/FunctionalTesting/TS_OM_ExistingBuildings', suiteProperties, new File("H:\\Git Projects\\USGBC_LEEDOnline_ExtentReports\\USGBC_LEEDOnline_ExtentReports\\USGBC_LEED\\Reports\\20191009_105114\\FunctionalTesting\\TS_OM_ExistingBuildings\\20191009_105114\\testCaseBinding"))
