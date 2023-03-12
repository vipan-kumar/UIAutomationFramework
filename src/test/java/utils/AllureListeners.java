package utils;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class AllureListeners implements IInvokedMethodListener{
	
	//Method to take screenshot
	@Attachment
	public <ActionsSequence> String performedActions(ActionsSequence actionSequence) {
		return actionSequence.toString();
	}
	@Attachment(value = "Allure Screenshot", type = "image/png")
	public static byte[] saveScreenshot() {
		byte[] screenShot = null;
		try {
			//Creating Robot class object
			Robot robotClassObject = new Robot();
			
			//Get screen size
			Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			
			//CApturing screenshot by providing size
		    BufferedImage capture = robotClassObject.createScreenCapture(screenSize);
		    
		    //Converting the image to byte array
		    ByteArrayOutputStream bos = new ByteArrayOutputStream();
		    ImageIO.write(capture, "png", bos);
		    screenShot = bos.toByteArray();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return screenShot;
	}
	
	//Method to write text for screenshot
	@Attachment(value = "{0}",type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}
	//below code helps to take screenshot when a TC is failed
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		int executionsResult = method.getTestResult().getStatus();
		if(executionsResult == 2) { // 2 means the TC is failed
			saveScreenshot();
		}
	}
}
