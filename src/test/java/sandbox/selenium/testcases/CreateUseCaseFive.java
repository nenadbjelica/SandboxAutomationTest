package sandbox.selenium.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import sandbox.selenium.base.BaseTest;
import sandbox.selenium.util.Constants;
import sandbox.selenium.util.ExcelUtils;

public class CreateUseCaseFive extends BaseTest {
	
	private String title;
	private String description;
	private String expectedResults;
	private String useCaseStep;
	
	@BeforeClass
	protected void initializeTestData() throws IOException {
		// create workbook instance and get value from row and cell number
	    ExcelUtils.setExcelFile(Constants.PATH_TESTDATA, Constants.SHEET_USECASE);
	    title = ExcelUtils.getCellData(1,5);
	    description = ExcelUtils.getCellData(2,5);
	    expectedResults = ExcelUtils.getCellData(3,5);
	    useCaseStep = ExcelUtils.getCellData(4,5);
	}

	@Test(priority = 1)
	protected void createUseCase() {
		// open Use case form and click to create a new use case
		workingSet.useCase.openUseCaseCard();
		workingSet.useCase.openNewUseCase();
		
		// input title, description and expected results
		workingSet.useCase.inputTitle(title);
		workingSet.useCase.inputDescription(description);
		workingSet.useCase.inputExpectedResult(expectedResults);
		
		// activate automated checkbox
		workingSet.useCase.clickAutomatedCheckbox();
		
		// input use case step
		workingSet.common.inputCaseTextByStepId(useCaseStep, 0);

		// click submit and assert that app url is correct after submitting form
		workingSet.common.clickSubmit();
		workingSet.basePage.assertingUrlEndsWithText("use-cases");
		workingSet.common.backToDeshboard();
	}

}
