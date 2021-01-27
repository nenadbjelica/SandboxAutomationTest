package sandbox.selenium.log;
import static sandbox.selenium.log.LoggerHelper.logger;

import org.openqa.selenium.WebElement;

public class SandboxLog {
	
	public static void inputField(String text) {
		StringBuilder sb = new StringBuilder();
		sb.append("Entering text ").append("'").append(text).append("'");
		logger.info(sb.toString());
	}
	
	public static void clickField(WebElement element) {
		StringBuilder sb = new StringBuilder();
		sb.append("Clicking on '").append(element.getText()).append("' item");
		logger.info(sb.toString());
	}
	
	public static void inputDropDownList(String value) {
		StringBuilder sb = new StringBuilder();
		sb.append("Choosing value '").append(value).append("' from dropdown list");
		logger.info(sb.toString());
	}
	
	public static void navigateUrl(String url) {
		logger.info("Navigating to " + url);
	}
	
	public static void assertingTextPassed(String text) {
		logger.info("Asserting app text '" + text + "' done successfully!");
	}
	
	public static void assertingUrlPassed(String text) {
		logger.info("Asserting Url '" + text + "' done successfully");
	}
	
	public static String assertingTextFailed(String elementText, String text) {
		return "Element text '" + elementText + "' does not contains passed '" + text + "' text! ->";
	}

}
