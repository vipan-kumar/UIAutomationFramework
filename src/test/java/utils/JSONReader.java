package utils;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {
	
	public Object readJson(String filePath) throws IOException, ParseException
	{
		FileReader fileReader = null;
		Object obj=null;
		JSONParser jsonParser = new JSONParser();
		try
		{
			fileReader = new FileReader(filePath);
			obj = jsonParser.parse(fileReader);
		}
		catch(IOException|ParseException e)
		{
			System.out.println("Exception in utils/JSONReader class: "+ e.getMessage());
			e.printStackTrace();
		}
		finally {
			if(fileReader!=null) {
				fileReader.close();
			}
		}
		return obj;
	}
}