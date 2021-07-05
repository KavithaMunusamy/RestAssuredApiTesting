package com.api.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class to get the configuration from properties file
 * @author Kavitha M
 *
 */
public class PropertiesConfiguration {
	
	static Properties propFile;
	private static Logger logger = LogManager.getLogger(PropertiesConfiguration.class);
	
	
	/**
	 * Constructor to load the properties file
	 * @param fileName
	 */
	public PropertiesConfiguration(String fileName){
		File file = new File(Constants.CONFIG_PATH+fileName);
		try {
			FileInputStream inputStream = new FileInputStream(file);
			propFile = new Properties();
			propFile.load(inputStream);
			logger.info("file loaded successfully", this);
		} catch (FileNotFoundException e) {
			logger.error("unable to load properties file:" + e.getMessage(), e);
			
		} catch (IOException e) {
			logger.error("unable to load properties file:" + e.getMessage(), e);
		}
		
	}
	
	/**
	 * Gets the property value for given property name
	 * @param propertyName
	 * @return
	 */
	public  String getProperty(String propertyName) {
		return propFile.getProperty(propertyName);
	}
	
	
	/**
	 * Gets the base url from properties file
	 * @return
	 */
	public  String getBaseUrl() {
		logger.debug(propFile.getProperty(Constants.BASE_URL));
		return propFile.getProperty(Constants.BASE_URL);
	}
	

}
