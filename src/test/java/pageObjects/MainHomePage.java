/*********************************************************************************************
 * TC Id               : Common for all TCs
 * @author             : Vipan
 * LAST UPDATED ON     : 05-Mar-2023
 * LAST UPDATED BY     : Vipan
 * REASON OF THE UPDATE:
 * DESCRIPTION         : Page object class for Main Home Page, ie the first page after
 * 						opening the application 
 *********************************************************************************************/

package pageObjects;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;
import utils.ActionsImplementation;
import utils.ReusableUtilities;

public class MainHomePage {
	
	WindowsDriver driver = null;
	WebDriverWait wait = null;
	ActionsImplementation actions = null;
	
	public MainHomePage(WindowsDriver driver,WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		actions = new ActionsImplementation(driver,wait);
	}
	
	
	//Page objects
	protected String btn_Submit_Id = "";
	protected String txt_Username_Id = "";
	protected String ddl_Role_Id = "";
	protected String menu_Main_Id = " ";
	
	//Methods
	public void enterUsername(String username) throws Exception{
		
	}
}
