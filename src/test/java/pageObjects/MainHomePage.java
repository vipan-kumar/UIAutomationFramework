/*********************************************************************************************
 * TC Id               : Common for all TCs
 * @author             : Vipan
 * LAST UPDATED ON     : 05-Mar-2023
 * LAST UPDATED BY     : Vipan
 * REASON OF THE UPDATE:
 * DESCRIPTION         : Page object class for Google search main page
 *********************************************************************************************/

package pageObjects;

import org.openqa.selenium.support.FindBy;

import elements.Test;
import elements.Text;

public class MainHomePage {
	
	@FindBy(name = "q")
	public Text searchBar = new Test("searchBar");
}
