package sandbox.selenium.base;

import org.openqa.selenium.WebDriver;

import sandbox.selenium.common.CommonFunction;
import sandbox.selenium.pages.LoginPage;
import sandbox.selenium.pages.PlaygroundPage;
import sandbox.selenium.pages.ProfilePage;
import sandbox.selenium.pages.ReportingIssuesPage;
import sandbox.selenium.pages.UseCasePage;

public class WorkingSet {

	public BasePage basePage;
	public ProfilePage profile;
	public LoginPage login;
	public CommonFunction common;
	public UseCasePage useCase;
	public ReportingIssuesPage report;
	public PlaygroundPage playground;

	public WorkingSet(WebDriver driver) {
		basePage = new BasePage(driver);
		profile= new ProfilePage(driver);
		common = new CommonFunction(driver);
		login = new LoginPage(driver, common);
		useCase = new UseCasePage(driver);
		report = new ReportingIssuesPage(driver);
		playground = new PlaygroundPage(driver);
	}
}
