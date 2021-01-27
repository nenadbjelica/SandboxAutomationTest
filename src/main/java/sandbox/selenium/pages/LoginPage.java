package sandbox.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import sandbox.selenium.base.BasePage;
import sandbox.selenium.common.CommonFunction;
import sandbox.selenium.log.Property;


public class LoginPage extends BasePage {
	
	private CommonFunction common;

	public LoginPage(WebDriver driver, CommonFunction common) {
		super(driver);
		this.common = common;
	}
	
	private final String USERNAME = Property.getProperty("username");
	private final String PASSWORD = Property.getProperty("password");

	private By loginForm = By.cssSelector("[href='/login']");
	private By username = By.name("email");
	private By password = By.name("password");
	private By logout = By.cssSelector("[href='#top']");
	

	public void openLoginForm() {
		click(loginForm);
	}
	
	public void inputUsername(String strUsername) {
		input(username, strUsername);
	}
	
	public void inputPassword(String strPassword) {
		input(password, strPassword);
	}
	
	public void initialLogin() {
		openLoginForm();
		inputUsername(USERNAME);
		inputPassword(PASSWORD);
		common.clickSubmit();
	}
	
	public void clickToLogout() {
		click(logout);
	}

}
