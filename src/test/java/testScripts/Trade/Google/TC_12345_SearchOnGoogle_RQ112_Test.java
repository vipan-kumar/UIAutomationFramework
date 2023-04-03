/*********************************************************************************************
 * TC Id               : 12345
 * @author             : Vipan Kumar
 * LAST UPDATED ON     : 12-Mar-2023
 * LAST UPDATED BY     : Vipan Kumar
 * REASON OF THE UPDATE:
 * DESCRIPTION         : Open Postman and verify the page definition
 *********************************************************************************************/
package testScripts.Trade.Google;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import pageObjects.MainHomePage;
import testScripts.BaseClass;
import utils.AllureListeners;
import utils.JSONReader;

@Listeners({AllureListeners.class})
public class TC_12345_SearchOnGoogle_RQ112_Test extends BaseClass{
	
	public TC_12345_SearchOnGoogle_RQ112_Test(String name) {
		super(name);
	}
	

	//global variables
	private static MainHomePage mhp = null;
	
	//Test Run
	@Test(dataProvider="tc12345_dp", priority = 1, description = "Open google and search string", groups = {"Trade" , "Google"})
	@Description("TC-12345-Open google and search string")
	@Story("TC-12345-Open google and search string")
	@Severity(SeverityLevel.MINOR)
	public void tc_12345_runner(String searchStr) throws Exception{
		
		try {
			logger.info("Execution for TC_12345 STARTED..............");
			mhp = new MainHomePage();
			
			//Step 1 - Open google and search string
			openGoogleAndSearch(searchStr);
			
			logger.info("Execution for TC_12345 COMPLETED..............");
		}
		catch(Exception e) {
			System.out.println("In catch block of the main test method.......");
			logger.info(ExceptionUtils.getStackTrace(e));
			Assert.fail("TC 12345 failed....");
		}
		finally {
			System.out.println("In finally block of the main test method.......");
			tc_12345_cleaner();
			logger.info("Cleaner service for above test ran successfully..............");
		}
	}
	@Step("Step 1 - Open google and search string") 
	public void openGoogleAndSearch(String searchVal) throws Exception{
		mhp.searchBar.enterToTextFieldByName(mhp,searchVal);
	}

	
	public void  tc_12345_cleaner() throws Exception{
		mhp = null;
	}
	
	//Data provide method should be written here
	@DataProvider(name="tc12345_dp")
	public Iterator<Object[]> tc12345_dp() throws IOException, ParseException, org.json.simple.parser.ParseException
	{
		ArrayList<Object[]> testData = new ArrayList<Object[]>();
		String tdFilePath = ".\\testData\\Trade\\Google\\TC_12345_TestData.json";
		JSONReader jsonReader = new JSONReader();
		JSONObject tdElements = null;
		
		try {
			//Calling Json reader class to read test data from json file
			Object tempTDobj = jsonReader.readJson(tdFilePath);
			tdElements = (JSONObject)tempTDobj;
		}
		catch(IOException e) {
			System.out.println("Exception in utils/JSONReader class: "+ e.getMessage());
			logger.error("Exception in utils/JSONReader class: "+ e.getStackTrace());
		}
		//getting element values from json file
		String searchString = (String) tdElements.get("SearchString");
		
		//data will be added to Object array which will then be added to ArrayList then iterator will be sent to @Test method
		Object[] ob = {searchString};
		testData.add(ob);
		return testData.iterator();
	}
}

