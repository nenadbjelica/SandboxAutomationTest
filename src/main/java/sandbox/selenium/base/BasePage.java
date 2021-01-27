package sandbox.selenium.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import sandbox.selenium.log.Property;
import sandbox.selenium.log.SandboxLog;
import sandbox.selenium.util.RandomHelper;

public class BasePage {
	
	private WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	protected WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	protected List<WebElement> findElements(By locator) {
		return (List<WebElement>) driver.findElements(locator);
	}

	protected void click(By locator) {
		WebElement element = findElement(locator);
		SandboxLog.clickField(element);
		element.click();
	}
	
	protected void clickAllElements(By locator) {
		List<WebElement> elements = findElements(locator);
		for (WebElement element : elements) {
			SandboxLog.clickField(element);
			element.click();
		}
	}
	
	protected void input(By locator, String value) {
		WebElement element = findElement(locator);
		inputActions(element, value);
	}
	
	public void inputByIndex(By locator, String value, int index) {
		List<WebElement> elements = findElements(locator);
		WebElement element = elements.get(index);
		inputActions(element, value);
	}
	
	private void inputActions(WebElement element, String value) {
		SandboxLog.inputField(value);
		element.clear();
		element.click();
		element.sendKeys(value);
	}
	
	protected String getText(By locator) {
		return findElement(locator).getText();
	}
	
	protected String getValue(By locator) {
		return findElement(locator).getAttribute("value");
	}
	
	protected String getValue(WebElement element) {
		return element.getAttribute("value");
	}
	
	protected Select getSelect(By locator) {
		return new Select(findElement(locator));
	}
	
	protected void selectDropdownByIndex(By locator, int index) {
		getSelect(locator).selectByIndex(index);
	}

	protected void selectDropdownByValue(By locator, String value) {
		SandboxLog.inputDropDownList(value);
		getSelect(locator).selectByValue(value);
	}

	protected void selectDropdownByVisibleText(By locator, String text) {
		getSelect(locator).selectByVisibleText(text);
	}
	
	protected void selectDropdownByRandomIndex(By locator) {
		Select dropdown = getSelect(locator);
		int index = RandomHelper.getRandomNumberFromInterval(1, dropdown.getOptions().size() - 1);
		dropdown.selectByIndex(index);
	}

	protected WebDriverWait getWebDriverWait() {
		return new WebDriverWait(driver, 10);
	}
	
	protected void waitForElementToBeClickable(By locator) {
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	protected void waitForVisibilityOfElementLocated(By locator) {
		getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	protected void waitForPresenceOfElementLocated(By locator) {
		getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void waitFor(int ms) {
		synchronized (driver) {
			try {
				driver.wait(ms);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void assertingValidationText(By locator, String text) {
		String element = getText(locator);
		Assert.assertTrue(element.equals(text), SandboxLog.assertingTextFailed(element, text));
		SandboxLog.assertingTextPassed(element);
	}
	
	public void assertingUrlEndsWithText(String relativeUrl) {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.endsWith(relativeUrl), SandboxLog.assertingTextFailed(url, relativeUrl));
		SandboxLog.assertingUrlPassed(url);
	}
	
	protected void navigateUrl() {
		String url = Property.getProperty("url");
		SandboxLog.navigateUrl(url);
		driver.get(url);
	}
	
}