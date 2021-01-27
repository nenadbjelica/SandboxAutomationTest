package sandbox.selenium.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import sandbox.selenium.base.BaseTest;

public class CheckLoginValidations extends BaseTest {

	private By usernameValidation = By.cssSelector(":nth-child(1) > div.invalid-feedback");
	private By passwordValidation = By.cssSelector(":nth-child(2) > div.invalid-feedback");
	
	@BeforeClass
	protected void doLogout() {
		workingSet.login.clickToLogout();
		workingSet.login.openLoginForm();
	}

	@Test(priority = 1)
	protected void emptyUsernameAndPassword() {
		workingSet.common.clickSubmit();
		workingSet.basePage.assertingValidationText(usernameValidation, "Email field is required");
		workingSet.basePage.assertingValidationText(passwordValidation, "Password is required");
	}
	
	@Test(priority = 2)
	protected void wrongUsernameAndPassword() {
		workingSet.login.inputUsername("xxxx@gmail.com");
		workingSet.login.inputPassword("xxxxxxxx");
		workingSet.common.clickSubmit();
		workingSet.basePage.assertingValidationText(usernameValidation, "User not found");
	}

	@Test(priority = 3)
	protected void correctUsernameAndWrongPassword() {
		workingSet.login.inputUsername("bjelica1984@gmail.com");
		workingSet.login.inputPassword("xxxxxxxx");
		workingSet.common.clickSubmit();
		workingSet.basePage.assertingValidationText(passwordValidation, "Password incorrect");
	}
	
	@Test(priority = 4)
	protected void correctPasswordAndShortUsername() {
		workingSet.login.inputUsername("xxxxx@gmail.com");
		workingSet.login.inputPassword("xxx");
		workingSet.common.clickSubmit();
		workingSet.basePage.assertingValidationText(passwordValidation, "Password must be at least 6 characters long");
	}
	
	@AfterClass
	protected void loginAgain() {
		login();
	}

}
