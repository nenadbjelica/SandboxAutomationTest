package sandbox.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import sandbox.selenium.base.BasePage;

public class ReportingIssuesPage extends BasePage {

	public ReportingIssuesPage(WebDriver driver) {
		super(driver);
	}

	private By reportingCard = By.cssSelector("[href='/reports'] h5");
	private By createNewIssue = By.cssSelector("[href='/create-report']");
	private By summary = By.name("summary");
	private By issueType = By.name("type");
	private By severity = By.name("severity");
	private By priority = By.name("priority");
	private By description = By.name("description");
	private By editIssue = By.cssSelector("[href^='/reports']");
	
	public void openReportingCard() {
		click(reportingCard);
	}
	
	public void createNewIssue() {
		click(createNewIssue);
	}
	
	public void inputSummary(String strSummary) {
		input(summary, strSummary);
	}
	
	public void selectIssueType(String value) {
		selectDropdownByValue(issueType, value);
	}
	
	public void selectIssueTypeByRandom() {
		selectDropdownByRandomIndex(issueType);
	}
	
	public void selectSeverity(String value) {
		selectDropdownByValue(severity, value);
	}
	
	public void selectSeverityByRandom() {
		selectDropdownByRandomIndex(severity);
	}
	
	public void selectPriority(String value) {
		selectDropdownByValue(priority, value);
	}
	
	public void selectPriorityByRandom() {
		selectDropdownByRandomIndex(priority);
	}
	
	public void inputDescription(String strDescription) {
		input(description, strDescription);
	}
	
	public void editReportedIssue() {
		click(editIssue);
	}
	
}
	