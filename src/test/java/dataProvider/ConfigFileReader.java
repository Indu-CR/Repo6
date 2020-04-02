package dataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.log4testng.Logger;


public class ConfigFileReader
{
	private static final Logger logger =Logger.getLogger(ConfigFileReader.class);
	private final Properties configProp = new Properties();
	private final Properties apiEndPoints = new Properties();
	
	private ConfigFileReader()
	{
		logger.debug("Read all properties from file");
		try
		{
			FileInputStream configPropFile=getFileInputStream(System.getProperty("user.dir")+"/configs/baseURI.properties");
			if(configPropFile!=null) {
				configProp.load(configPropFile);
			}
			logger.debug("config file has been loaded");
			
			FileInputStream apiEndPoint=getFileInputStream(System.getProperty("user.dir")+"/configs/endPoint.properties");
			if(apiEndPoint!=null) {
				apiEndPoints.load(apiEndPoint);
			}
			logger.debug("config file has been loaded");
		}
		catch(IOException e)
		{
			logger.debug("PropertiesHelper exception msg: "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static class LazyHolder 
	{
		private static final ConfigFileReader INSTANCE = new  ConfigFileReader();
	}
	
	public static ConfigFileReader getInstance()
	{
		return LazyHolder.INSTANCE;
	}
	
	public String getConfigPropProperty(String key)
	{
		return configProp.getProperty(key);
	}
	
	public String getEndPointPropProperties(String key)
	{
		return apiEndPoints.getProperty(key);
	}
	
	public FileInputStream getFileInputStream(String filepath)
	{ 
		FileInputStream fileInputStream=null;
		try 
		{
			fileInputStream = new FileInputStream(filepath);
		}
		catch(Exception e) {
			logger.error("GetFileInputStream() exception msg: "+e.getMessage());
		}
		return fileInputStream;
	}
		
}

