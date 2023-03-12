/*
 * This class implements all the actions that needs to be performed on a Button, Text, Link, Dropdown etc
 */
package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.*;
import io.appium.java_client.windows.WindowsDriver;

public class ActionsImplementation implements Button,Dropdown,Text {
	
	WindowsDriver driver = null;
	ReusableUtilities reusableUtils = null;
	WebDriverWait wait;
	
	public ActionsImplementation(WindowsDriver driver,WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		reusableUtils = new ReusableUtilities(driver);
	}
	//Implementing Button.java class
	public void clickOnButtonById(String elementId) throws Exception{
		WebElement weBtn = driver.findElementByAccessibilityId(elementId);
		new Actions(driver).moveToElement(weBtn).click(weBtn).build().perform();
		reusableUtils.implecitWaitTime();
	}
	public void clickOnButtonByName(String elementName) throws Exception{
		WebElement weBtn = driver.findElementByName(elementName);
		new Actions(driver).moveToElement(weBtn).click(weBtn).build().perform();
		reusableUtils.implecitWaitTime();
	}
	public void scrollIntoViewByExpathWithoutClick(String elementId) throws Exception{
		//write code for the same here
	}
	
	//Implementing Text.java class
	public void enterToTextFieldById(String elementId,String value) throws Exception{
		driver.findElementByAccessibilityId(elementId).click();
		reusableUtils.implecitWaitTime();
		driver.findElementByAccessibilityId(elementId).sendKeys(value);
		reusableUtils.implecitWaitTime();
	}
	public String getValueOfTextFieldById(String elementId) throws Exception{
			return driver.findElementByAccessibilityId(elementId).getAttribute("Value.Value");
	}
	public void clearTextFieldById(String elementId) throws Exception{
		driver.findElementByAccessibilityId(elementId).clear();
		reusableUtils.implecitWaitTime();
	}
	
	//Implementing Dropdown.java class
	public void clickDropdownById(String elementId) throws Exception{
		
	}
	public void selectFromDropDownById(String elementName) throws Exception{
			
	}
}
