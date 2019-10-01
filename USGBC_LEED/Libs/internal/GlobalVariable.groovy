package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object UserName
     
    /**
     * <p></p>
     */
    public static Object Password
     
    /**
     * <p></p>
     */
    public static Object URL
     
    /**
     * <p></p>
     */
    public static Object O_M_EB
     
    /**
     * <p></p>
     */
    public static Object DownloadPath_Server
     
    /**
     * <p></p>
     */
    public static Object DownloadPath_Local
     
    /**
     * <p></p>
     */
    public static Object currentTestCaseId
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            UserName = selectedVariables['UserName']
            Password = selectedVariables['Password']
            URL = selectedVariables['URL']
            O_M_EB = selectedVariables['O_M_EB']
            DownloadPath_Server = selectedVariables['DownloadPath_Server']
            DownloadPath_Local = selectedVariables['DownloadPath_Local']
            currentTestCaseId = selectedVariables['currentTestCaseId']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
