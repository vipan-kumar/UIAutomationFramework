package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	FileInputStream propRead = null;
	Properties prop;
	
	public ReadConfig()
	{
		try
		{
			prop= new Properties();
			propRead= new FileInputStream("./configs/config.properties");
			prop.load(propRead);
		}
		catch(Exception e)
		{
			System.out.println("Exception in utils/ReadConfig class: "+e.getMessage());
		}
	}
	
	//Define a method for each property written in config.properties file
	public String getAppName()
	{
		return prop.getProperty("appname");
	}
	public String getAppPath()
	{
		return prop.getProperty("apppath");
	}
	public String getUsername()
	{
		return prop.getProperty("username");
	}
	public String getPassword()
	{
		return prop.getProperty("password");
	}
}