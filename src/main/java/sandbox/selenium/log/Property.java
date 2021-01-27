package sandbox.selenium.log;

import static sandbox.selenium.log.LoggerHelper.logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Property {
	
	private static String FILE_NAME = "config.properties";
	private static Properties PROPERTIES;

	static {
		PROPERTIES = loadProperties();
	}

	private static Properties loadProperties() {
		Properties props = new Properties();
		try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_NAME);) {
			props.load(is);
		} catch (IOException e) {
			logger.error("Could not load properties from " + FILE_NAME + " file", e);
		}

		return props;
	}

	public static String getProperty(String key) {
		return key == null ? null : PROPERTIES.getProperty(key);
	}

}
