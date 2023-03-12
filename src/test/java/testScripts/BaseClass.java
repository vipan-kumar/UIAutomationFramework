package testScripts;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.windows.WindowsDriver;
import utils.CloseApplicationFromTaskManager;
import utils.ReadConfig;

public class BaseClass {
	
	//global variables
	public static WindowsDriver appdriver = null;
	public static WindowsDriver rootdriver = null;
	public static WindowsDriver driver = null;
	public WebDriverWait wait = null;
	public Assertion hardAssert;
	public SoftAssert softAssert;
	
	//Initialising Logger
	public static Logger logger = LogManager.getLogger(BaseClass.class.getName());
	
	//Read config.properties file
	ReadConfig readConfig = new ReadConfig();
	public String appName = readConfig.getAppName();
	public String userName = readConfig.getUsername();
	public String password = readConfig.getPassword();
	public String appPath = readConfig.getAppPath();
	public String appHeader = appPath + ".exe";
	
	//Windows driver URL with port
	String winDriverURL = "http://127.0.0.1:4723";
	
	/* Written during k8 automation************************************************************
	@BeforeClass
	public void setup() {
		
		DesiredCapabilities appLoginCaps = new DesiredCapabilities();
		appLoginCaps.setCapability("platformName", "Windows");
		appLoginCaps.setCapability("deviceName", "WindowsPC");
		appLoginCaps.setCapability("app", appName);
		
		try {
			appdriver = new WindowsDriver(new URL(winDriverURL),appLoginCaps);
			appdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//write code to add username , password, click connect and click oK btn in case of K8 application
			
			//Below caps are required to find out application window of all the opened window in the system
			DesiredCapabilities rootCaps = new DesiredCapabilities();
			rootCaps.setCapability("platformName", "Windows");
			rootCaps.setCapability("deviceName", "WindowsPC");
			rootCaps.setCapability("app", "Root");
			
			rootdriver = new WindowsDriver(new URL(winDriverURL),rootCaps);
			rootdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//Find out the desired application from the opened applications of the PC
			WebElement appWindow = rootdriver.findElementByName(appHeader);
			
			//get Hex value of the application 
			String appHandle = appWindow.getAttribute("NativeWindowHandle");
			int appHandleInt = Integer.parseInt(appHandle);
			String appHandleHex = Integer.toHexString(appHandleInt);
			appHandleHex = "0x"+appHandleHex;
			
			//These are the final caps and this driver will be used in the scripts
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", "Windows");
			caps.setCapability("deviceName", "WindowsPC");
			rootCaps.setCapability("appTopLevelWindow", appHandleHex);
			
			driver = new WindowsDriver(new URL(winDriverURL),caps);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//Initialising other classes
			wait = new WebDriverWait(driver,30);
			//Initialising hard assert
			hardAssert = new Assertion();
			//Initialising soft assert
			softAssert = new SoftAssert();
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.info(ExceptionUtils.getStackTrace(e));
			appdriver = null;
			rootdriver = null;
			driver = null;
		}
	}
	
	@AfterClass
	public void tearDown() {
		//to close application drivers
		if(appdriver != null) {
			appdriver.quit();
			appdriver = null;
		}
		if(rootdriver != null) {
			rootdriver.quit();
			rootdriver = null;
		}
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
	*********************************************************************************/
	
	
	//WRITTEN FOR NOTEPAD AUTOMATION ****************************************************
	@BeforeClass
	public void setup() {
		
		DesiredCapabilities appLoginCaps = new DesiredCapabilities();
		appLoginCaps.setCapability("platformName", "Windows");
		appLoginCaps.setCapability("deviceName", "WindowsPC");
		appLoginCaps.setCapability("app", appName);
		
		try {
			appdriver = new WindowsDriver(new URL(winDriverURL),appLoginCaps);
			appdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//write code to add username , password, click connect and click oK btn in case of K8 application
			
			//Below caps are required to find out application window of all the opened window in the system
			DesiredCapabilities rootCaps = new DesiredCapabilities();
			rootCaps.setCapability("platformName", "Windows");
			rootCaps.setCapability("deviceName", "WindowsPC");
			rootCaps.setCapability("app", "Root");
			
			rootdriver = new WindowsDriver(new URL(winDriverURL),rootCaps);
			rootdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//Find out the desired application from the opened applications of the PC
			WebElement appWindow = rootdriver.findElementByName(appHeader);
			
			//get Hex value of the application 
			String appHandle = appWindow.getAttribute("NativeWindowHandle");
			int appHandleInt = Integer.parseInt(appHandle);
			String appHandleHex = Integer.toHexString(appHandleInt);
			appHandleHex = "0x"+appHandleHex;
			
			//These are the final caps and this driver will be used in the scripts
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", "Windows");
			caps.setCapability("deviceName", "WindowsPC");
			rootCaps.setCapability("appTopLevelWindow", appHandleHex);
			
			driver = new WindowsDriver(new URL(winDriverURL),caps);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//Initialising other classes
			wait = new WebDriverWait(driver,30);
			//Initialising hard assert
			hardAssert = new Assertion();
			//Initialising soft assert
			softAssert = new SoftAssert();
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.info(ExceptionUtils.getStackTrace(e));
			appdriver = null;
			rootdriver = null;
			driver = null;
		}
	}
	
	@AfterClass
	public void tearDown() {
		//to close application drivers
		if(appdriver != null) {
			appdriver.quit();
			appdriver = null;
		}
		if(rootdriver != null) {
			rootdriver.quit();
			rootdriver = null;
		}
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
}
