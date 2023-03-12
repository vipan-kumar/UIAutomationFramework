package elements;

public interface Text {
	
	public void enterToTextFieldById(String elementId,String value) throws Exception;
	
	public String getValueOfTextFieldById(String elementId) throws Exception;
	
	public void clearTextFieldById(String elementId) throws Exception;
}
