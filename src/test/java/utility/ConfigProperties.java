package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
	
	private static Properties prop = new Properties();
	public static void loadProperties() {
		try {
			prop.load(new FileInputStream("config/avactis.properties"));
		}catch(FileNotFoundException e) {
			System.out.println("File Not Found Exception");
		}catch(IOException e) {
			System.out.println("IO Exception");
			
		}
	}
	
	public static String getProperties(String keyValue) {
		return prop.getProperty(keyValue);
		
	}

}
