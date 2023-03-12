/*
 * This class contains common methods like waits, generating random numbers etc
 */
package utils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.windows.WindowsDriver;

public class ReusableUtilities {
	
	WindowsDriver driver = null;
	
	public ReusableUtilities(WindowsDriver driver) {
		this.driver = driver;
	}
	public void implecitWaitTime() throws Exception{
		driver.manage().timeouts().implicitlyWait(Constants.TEN_SEC_WAIT, TimeUnit.SECONDS);
	}
	public String generateUniqueString(String oldVal) throws Exception{
		//generate and concatenates a 4 digit random number to the oldVal
		Random random = new Random();
		return oldVal+String.format("%04d", random.nextInt(10000));
	}
	public void charSequencingById(String elementId,String value) throws Exception{
		//This method will enter the value character by character. Ex- SUN will be sent as S then U then N
		for(int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			String val = String.valueOf(c);
			driver.findElementByAccessibilityId(elementId).sendKeys(val);
		}
	}
}
