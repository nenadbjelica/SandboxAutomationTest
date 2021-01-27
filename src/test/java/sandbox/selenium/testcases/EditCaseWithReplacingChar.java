package sandbox.selenium.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import sandbox.selenium.base.BaseTest;

public class EditCaseWithReplacingChar extends BaseTest {

	private By elementList = By.cssSelector(".form-control");

	@Test()
	protected void replacingCharacters() {
		// click to open Use case and edit first in the list
		workingSet.useCase.openUseCaseCard();
		workingSet.useCase.editUseCase();

		// going through all elements and replacing string with requested message
		List<Integer> charNumList = workingSet.useCase.getListOfCharacters(elementList);
		for (int i = 0; i < charNumList.size(); i++) {
			int charNum = charNumList.get(i);
			workingSet.basePage.inputByIndex(elementList, inputCustomMessage(charNum), i);
		}

		// click submit and assert that app url is correct after submitting form
		workingSet.common.clickSubmit();
		workingSet.basePage.assertingUrlEndsWithText("use-cases");
		workingSet.common.backToDeshboard();
	}

	private String inputCustomMessage(int charNum) {
		return "This field previously had " + charNum + " characters";
	}

}
