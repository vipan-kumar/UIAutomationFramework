package elements;

public interface Button {
	
	public void clickOnButtonById(String elementId) throws Exception;
	
	public void clickOnButtonByName(String elementName) throws Exception;
	
	public void scrollIntoViewByExpathWithoutClick(String elementId) throws Exception;
}
