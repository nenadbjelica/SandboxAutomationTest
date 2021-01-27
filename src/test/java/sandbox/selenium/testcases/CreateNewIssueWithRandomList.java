package sandbox.selenium.testcases;

import org.testng.annotations.Test;

import sandbox.selenium.base.BaseTest;

public class CreateNewIssueWithRandomList extends BaseTest {

	@Test
	protected void reportNewIssue() {
		// open Reporting issue form and click to create new issue
		workingSet.report.openReportingCard();
		workingSet.report.createNewIssue();
		
		// input summary. description and set random index from type, severity and priority list
		workingSet.report.inputSummary("Summary of random issue");
		workingSet.report.selectIssueTypeByRandom();
		workingSet.report.selectSeverityByRandom();
		workingSet.report.selectPriorityByRandom();
		workingSet.report.inputDescription("Description of random issue");

		// input text for one step
		workingSet.common.inputCaseTextByStepId("Text of Step 1", 0);
		
		// click submit and assert that app url is correct after submitting form
		workingSet.common.clickSubmit();
		workingSet.basePage.assertingUrlEndsWithText("reports");
		workingSet.common.backToDeshboard();
	}
	
}