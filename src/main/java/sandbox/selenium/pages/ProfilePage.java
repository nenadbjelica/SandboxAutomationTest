package sandbox.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import sandbox.selenium.base.BasePage;

public class ProfilePage extends BasePage {
	
	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	
	private By profileCard = By.cssSelector("[href='/profile'] h5");
	private By changePasswordForm = By.cssSelector("[data-testid='submit_btn'][type='button']");
	private By currentPassword = By.name("current_password");
	private By newPassword = By.name("new_password");
	private By confirmPassword = By.name("new_password2");
	

	public void openProfileCard() {
		click(profileCard);
	}
	
	public void openChangePasswordForm() {
		click(changePasswordForm);
	}
	
	public void inputCurrentPassword(String strCurrentPass) {
		input(currentPassword, strCurrentPass);
	}
	
	public void inputNewPassword(String strNewPass) {
		input(newPassword, strNewPass);
	}
	
	public void inputConfirmPassword(String strConfirmPass) {
		input(confirmPassword, strConfirmPass);
	}
	
}