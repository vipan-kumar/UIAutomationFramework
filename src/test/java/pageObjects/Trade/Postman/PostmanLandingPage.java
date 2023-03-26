/*********************************************************************************************
 * TC Id               : Common for all TCs
 * @author             : Vipan
 * LAST UPDATED ON     : 12-Mar-2023
 * LAST UPDATED BY     : Vipan
 * REASON OF THE UPDATE:
 * DESCRIPTION         : Page object Postman Landing page i.e the first page that appears after
 * 						opening the application
 *********************************************************************************************/

package pageObjects.Trade.Postman;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;
import utils.ActionsImplementation;
import utils.ReusableUtilities;

public class PostmanLandingPage {
	
	WindowsDriver driver = null;
	WebDriverWait wait = null;
	ActionsImplementation actions = null;
	
	public PostmanLandingPage(WindowsDriver driver,WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		actions = new ActionsImplementation(driver,wait);
	}
	
	
	//Page objects
	private String link_Request_Name = "File";
	
	
	//Methods
	public boolean verifyPostmanPgLoad() throws Exception{
		return driver.findElementByName(link_Request_Name).isDisplayed();
	}
	public void clickRequestLink() throws Exception{
		actions.clickOnButtonByName(link_Request_Name);
	}
}
