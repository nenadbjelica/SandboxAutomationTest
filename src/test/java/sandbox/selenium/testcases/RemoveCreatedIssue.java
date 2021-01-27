package sandbox.selenium.testcases;

import org.testng.annotations.Test;

import sandbox.selenium.base.BaseTest;

public class RemoveCreatedIssue extends BaseTest {

	@Test(priority = 1)
	protected void removingIssue() {
		// remove created issue
		workingSet.report.openReportingCard();
		workingSet.report.editReportedIssue();
		workingSet.common.deleteEntity();
	}

}