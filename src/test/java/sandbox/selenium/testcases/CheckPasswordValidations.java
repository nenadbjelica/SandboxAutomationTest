package sandbox.selenium.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import sandbox.selenium.base.BaseTest;

public class CheckPasswordValidations extends BaseTest {

	private By currentPassValidation = By.cssSelector(":nth-child(1) > div.invalid-feedback");
	private By newPassValidation = By.cssSelector(":nth-child(2) > div.invalid-feedback");
	private By confirmPassValidation = By.cssSelector(":nth-child(3) > div.invalid-feedback");
	
	@BeforeClass
	protected void doLogout() {
		workingSet.profile.openProfileCard();
		workingSet.profile.openChangePasswordForm();
	}

	@Test(priority = 1)
	protected void emptyCurrentNewAndConfirmPass() {
		workingSet.common.clickSubmit();
		workingSet.basePage.assertingValidationText(currentPassValidation, "Current password is required");
		workingSet.basePage.assertingValidationText(newPassValidation, "New password is required");
		workingSet.basePage.assertingValidationText(confirmPassValidation, "Confirm password is required");
	}
	
	@Test(priority = 2)
	protected void wrongCurrentPass() {
		workingSet.profile.inputCurrentPassword("xxxxxx");
		workingSet.profile.inputNewPassword("xxxxxx");
		workingSet.profile.inputConfirmPassword("xxxxxx");
		workingSet.common.clickSubmit();
		workingSet.basePage.assertingValidationText(currentPassValidation, "Incorrect current password");
	}
	
	@Test(priority = 3)
	protected void wrongNewPassLength() {
		workingSet.profile.inputCurrentPassword("xxxxxx");
		workingSet.profile.inputNewPassword("xxxx");
		workingSet.profile.inputConfirmPassword("xxxx");
		workingSet.common.clickSubmit();
		workingSet.basePage.assertingValidationText(newPassValidation, "New password must be at least 6 characters long");
	}

	@Test(priority = 4)
	protected void wrongMatchNewAndConfirmPass() {
		workingSet.profile.inputCurrentPassword("xxxxxx");
		workingSet.profile.inputNewPassword("xxxxxxx");
		workingSet.profile.inputConfirmPassword("xxxxxxxx");
		workingSet.common.clickSubmit();
		workingSet.basePage.assertingValidationText(confirmPassValidation, "Confirm password must match password");
	}
	
}
