package sandbox.selenium.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import sandbox.selenium.base.BaseTest;
import sandbox.selenium.util.Constants;
import sandbox.selenium.util.ExcelUtils;

public class CreateUseCaseThree extends BaseTest {
	
	private String title;
	private String description;
	private String expectedResults;
	private String useCaseStep1;
	private String useCaseStep2;
	
	@BeforeClass
	protected void initializeTestData() throws IOException {
		// create workbook instance and get value from row and cell number
	    ExcelUtils.setExcelFile(Constants.PATH_TESTDATA, Constants.SHEET_USECASE);
	    title = ExcelUtils.getCellData(1,3);
	    description = ExcelUtils.getCellData(2,3);
	    expectedResults = ExcelUtils.getCellData(3,3);
	    useCaseStep1 = ExcelUtils.getCellData(4,3);
	    useCaseStep2 = ExcelUtils.getCellData(5,3);
	}

	@Test
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
		
		// input use case steps
		workingSet.common.inputCaseTextByStepId(useCaseStep1, 0);
		workingSet.common.addNewStep();
		workingSet.common.inputCaseTextByStepId(useCaseStep2, 1);
		workingSet.common.addNewStep();
		
		// click submit and assert that app url is correct after submitting form
		workingSet.common.clickSubmit();
		workingSet.basePage.assertingUrlEndsWithText("use-cases");
		workingSet.common.backToDeshboard();
	}
}
