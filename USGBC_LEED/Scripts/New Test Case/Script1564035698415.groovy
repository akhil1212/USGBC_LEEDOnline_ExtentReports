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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
/*ArrayList<String> fileNames = new ArrayList<String>()
for(int j=1;j<=findTestData("Data Files/TD_FileNames").getRowNumbers();j++){
	WebUI.delay(2)

	String fname = findTestData("Data Files/TD_FileNames").getValue("File Name", j)
	println fname
	
	fileNames.add(fname)
	
	
	
	
	
}
 println fileNames*/
/*
String downloadPath = "/home/promantusinc/Desktop/TestFolder"
File dir = new File(downloadPath);
File[] dirContents = dir.listFiles();

println "#################"+downloadPath
println dirContents.length
if (dirContents.length > 0) {

	for (int i = 0; i < dirContents.length; i++) {
		fileName = dirContents[i].getName()
		if(fileName == "creditForm.pdf"){
			
		}
		else{
		dirContents[i].delete();
		//return true;
		}

	}

}
*/
///##########

//String  fname_txt = WebUI.getText(fileNameObject)
String path = "/home/promantusinc/Desktop/TestFolder/creditform.pdf"//RunConfiguration.getProjectDir() + '/Include/TestData/DownloadedFiles/'+fname_txt
println "############################## Path = "+path
File file = new File(path);
println "############################## file = "+file
int i =5

while (!file.exists()) {
	println "######"+i
	if(i == 20){
		println "Waited for 10 minutes, unable to download because of network failure/internet issue"
		break
	}
	
	else{
		
		println "Waiting for file to download"
	WebUI.delay(i)
	i= i+5
	
	
	}
}



 
 
