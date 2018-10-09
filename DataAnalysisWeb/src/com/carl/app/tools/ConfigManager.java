package com.carl.app.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	private static ConfigManager configManager;
	private Properties properties;
	
	//Read configuration files
	private ConfigManager() {
		String configFile="database.properties";
		properties=new Properties();
		InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
		try {
			properties.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Assess point
	public static synchronized ConfigManager getInstance() {
		if (configManager==null) {
			configManager = new ConfigManager();
		}
		return configManager;
	}
	//Get value from key
	public String getValue(String key) {
		return properties.getProperty(key);
	}
}
