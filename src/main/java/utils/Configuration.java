package utils;

import java.io.IOException;
import java.util.Properties;

import constants.Profile;

public class Configuration {
	// The Properties class represents a persistent set of properties.
	private Properties properties = new Properties();
	
	// newly added
	String generalConfig = "config.properties";
	String browserStackConfig = "browserstack.properties";

	// This is a parameterized Constructor now
	public Configuration(Profile profile) {
		switch (profile) {
		case GENERAL:
			loadProperty(generalConfig);
			break;
			
		case BROWSERSTACK:
			loadProperty(browserStackConfig);
			break;

		default:
			break;
		}
	
	}

	// change here
	public void loadProperty(String profile) {
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream(profile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Individual return type method created
	public String getProperties(String key) {
		return properties.getProperty(key);
	}
}