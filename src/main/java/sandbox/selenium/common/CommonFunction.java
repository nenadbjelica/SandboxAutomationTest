package sandbox.selenium.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import sandbox.selenium.base.BasePage;

public class CommonFunction extends BasePage {

	public CommonFunction(WebDriver driver) {
		super(driver);
	}

	private By submit = By.cssSelector("[type='submit']");
	private By addNewStep = By.cssSelector(".addTestStep");
	private By deleteButton = By.cssSelector(".delete-button");
	private By confirmDelete = By.cssSelector(".btn-danger");
	private By deshboard = By.cssSelector("[href='/dashboard']");
	

	public void clickSubmit() {
		click(submit);
		waitFor(1000);
	}
	
	public void backToDeshboard() {
		waitFor(250);
		click(deshboard);
		waitFor(250);
	}
	
	public void addNewStep() {
		click(addNewStep);
	}
	
	public void deleteEntity() {
		click(deleteButton);
		click(confirmDelete);
	}
	
	public void inputCaseTextByStepId(String strStepText, int stepId) {
		input(getStepId(stepId), strStepText);
	}
	
	private By getStepId(int stepId) {
		return By.cssSelector("[data-id='" + stepId + "']");
	}
	
}
