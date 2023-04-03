package testScripts;

import org.testng.annotations.BeforeClass;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

import elements.Button;
import elements.Dropdown;
import elements.Text;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.windows.WindowsDriver;
import utils.CloseApplicationFromTaskManager;
import utils.ReadConfig;

public class BaseClass implements Button,Dropdown,Text{
	
	public BaseClass(String name) {
		this.name = name;
	}
	
	//global variables
	String name;
	public static Field field;
	public static FindBy find;
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	public Assertion hardAssert;
	public SoftAssert softAssert;
	
	//Initialising Logger
	public static Logger logger = LogManager.getLogger(BaseClass.class.getName());
	
	//Read config.properties file
	ReadConfig readConfig = new ReadConfig();
	public String appurl = readConfig.getAppURL();
	public String userName = readConfig.getUsername();
	public String password = readConfig.getPassword();
	public String browser = readConfig.getBrowser();	
	
	

	@BeforeClass
	public void setup() {
		try {
			String projectpath = System.getProperty("user.dir");
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", projectpath+"\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if (browser.equalsIgnoreCase("IE")) {
				//wrie code for IE browser here
			}
			driver.get(appurl);		
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//Initialising hard assert
			hardAssert = new Assertion();
			//Initialising soft assert
			softAssert = new SoftAssert();
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.info(ExceptionUtils.getStackTrace(e));
			driver = null;
		}
	}
	
	@AfterClass
	public void tearDown() {
		//to close application drivers
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		
		//To close the application forcefully if kept open due to exception
		CloseApplicationFromTaskManager.closeApplication();
		logger.info("BaseClass.teardown invoked successfully....");
		System.out.println("Wait before initiating next test case...");
		try {
			Thread.sleep(3000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	//************** METHOD IMPLEMENTATION *********************************************************//
	//Implementing Button.java class
	@Override
	public void clickOnButtonById(String elementId) throws Exception{		
	    
	}
	@Override
	public void clickOnButtonByName(String elementName) throws Exception{
		
	}
	@Override
	public void scrollIntoViewByExpathWithoutClick(String elementId) throws Exception{
		//write code for the same here
	}
	
	//Implementing Text.java class
	@Override
	public void enterToTextFieldById(String value) throws Exception{
		
	}
	@Override
	public void enterToTextFieldByName(Object page,String value) throws Exception{
		field = page.getClass().getField(name);
		find = field.getAnnotation(FindBy.class);
		waitForVisibility(By.name(find.name()));
		driver.findElement(By.name(find.name())).sendKeys(value);
	}
	@Override
	public String getValueOfTextFieldById(String elementId) throws Exception{
			return null;
	}
	@Override
	public void clearTextFieldById(String elementId) throws Exception{
		
	}
	
	//Implementing Dropdown.java class
	@Override
	public void clickDropdownById(String elementId) throws Exception{
		
	}
	@Override
	public void selectFromDropDownById(String elementName) throws Exception{
			
	}
	
	//common methods
	public static void waitForVisibility(By by) throws Exception{
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
}
