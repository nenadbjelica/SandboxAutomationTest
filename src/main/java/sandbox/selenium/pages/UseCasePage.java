package sandbox.selenium.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import sandbox.selenium.base.BasePage;

public class UseCasePage extends BasePage {

	public UseCasePage(WebDriver driver) {
		super(driver);
	}

	private By useCaseCard = By.cssSelector("[href='/use-cases'] h5");
	private By createUseCase = By.cssSelector("[href='/create-usecase']");
	private By title = By.cssSelector("[name='title']");
	private By description = By.cssSelector("[name='description']");
	private By expectedResult = By.cssSelector("[name='expected_result']");
	private By automatedCheckbox = By.cssSelector("[for='switch']");
	private By editUseCase = By.cssSelector("[href^='/use-cases']");
	
	public void openUseCaseCard() {
		click(useCaseCard);
	}
	
	public void openNewUseCase() {
		click(createUseCase);
	}
	
	public void inputTitle(String strTitle) {
		input(title, strTitle);
	}
	
	public void inputDescription(String strDescription) {
		input(description, strDescription);
	}

	public void inputExpectedResult(String strExpectedResult) {
		input(expectedResult, strExpectedResult);
	}

	public void clickAutomatedCheckbox() {
		click(automatedCheckbox);
	}
	
	public void editUseCase() {
		click(editUseCase);
	}
	
	public List<Integer> getListOfCharacters(By locator) {
		List<WebElement> elements = findElements(locator);
		List<Integer> newlist = new ArrayList<Integer>();
		for (WebElement element : elements) {
			String value = getValue(element);
			// skip empty sting
			int count = 0;
			for (int i = 0; i < value.length(); i++) {
				if (value.charAt(i) != ' ')
					count++;
			}
			newlist.add(count);
		}
		return newlist;
	}
}
