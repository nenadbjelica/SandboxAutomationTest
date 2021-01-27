package sandbox.selenium.testcases;

import org.testng.annotations.Test;

import sandbox.selenium.base.BaseTest;

public class CreateNewIssue extends BaseTest {

	@Test
	protected void reportNewIssue() {
		// open Reporting issue form and click to create new issue
		workingSet.report.openReportingCard();
		workingSet.report.createNewIssue();
		
		// input summary, issue type, severity, priority, description
		workingSet.report.inputSummary("Summary by Selenium");
		workingSet.report.selectIssueType("Bug");
		workingSet.report.selectSeverity("Medium");
		workingSet.report.selectPriority("Major");
		workingSet.report.inputDescription("Description by Selenium");

		// input text for 4 steps
		workingSet.common.inputCaseTextByStepId("Step 1 by Selenium", 0);
		workingSet.common.addNewStep();
		workingSet.common.inputCaseTextByStepId("Step 2 by Selenium", 1);
		workingSet.common.addNewStep();
		workingSet.common.inputCaseTextByStepId("Step 3 by Selenium", 2);
		workingSet.common.addNewStep();
		workingSet.common.inputCaseTextByStepId("Step 4 by Selenium", 3);

		// click submit and assert that app url is correct after submitting form
		workingSet.common.clickSubmit();
		workingSet.basePage.assertingUrlEndsWithText("reports");
		workingSet.common.backToDeshboard();

	}
}