package sandbox.selenium.util;

import static sandbox.selenium.log.LoggerHelper.logger;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshot {
	
	private static final String SS_PATH = "C:/Sendbox/Screenshots/";
	private static final String SS_EXTENSION = ".png";

	public static String takeScreenshot(WebDriver driver, String fileName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		String fullFilePath = createFilePath(fileName);
		File destinationFile = new File(fullFilePath);

		try {
			FileUtils.copyFile(sourceFile, destinationFile);
			logger.info("Screenshot taken -> " + fullFilePath + '\n');
		} catch (IOException e) {
			logger.error("Screenshot (" + fileName + ") saving exception", e);
			return null;
		}

		return fullFilePath;
	}

	private static String createFilePath(String fileName) {
		StringBuffer sb = new StringBuffer();
		sb.append(SS_PATH).append(DateTime.getToday() + "/").append(fileName + "-")
				.append(DateTime.getNowTimestamp()).append(SS_EXTENSION);
		return sb.toString();
	}

}