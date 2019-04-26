package fr.eni.GestionListesCourses.dal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class Settings {
	private Properties properties;
	
	public Settings() {
		properties = new Properties();
		FileInputStream streamXML = null;
		try {
			streamXML = new FileInputStream("./WebContent/META-INF/settings.xml"); 
			properties.loadFromXML(streamXML);
		} catch (InvalidPropertiesFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

}
