package sandbox.selenium.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import sandbox.selenium.base.BaseTest;
import sandbox.selenium.util.Constants;

public class PlaygroundTest extends BaseTest {
	
	@BeforeClass
	protected void openPlaygroundCard() {
		workingSet.playground.openPlaygroundCard();
	}
	
	@Test
	protected void createNewTechnologies() {
		// open and create new technologies
		workingSet.playground.openTechnologiesTab();
		workingSet.playground.createNewTechnology(Constants.INTELLIJ);
		workingSet.playground.createNewTechnology(Constants.JAVA);
		workingSet.playground.createNewTechnology(Constants.SELENIUM);
	}
	
	@Test
	protected void createNewSeniorities() {
		// open and create new seniorities
		workingSet.playground.openSenioritiesTab();
		workingSet.playground.createNewSeniority(Constants.JUNIOR);
		workingSet.playground.createNewSeniority(Constants.MEDIOR);
		workingSet.playground.createNewSeniority(Constants.SENIOR);
	}

	@Test
	protected void createNewTeams() {
		// open and create new teams
		workingSet.playground.openTeamsTab();
		workingSet.playground.createNewTeam(Constants.TEAM_BG);
		workingSet.playground.createNewTeam(Constants.TEAM_NS);
		workingSet.playground.createNewTeam(Constants.TEAM_NI);
	}
	
	@Test(dependsOnMethods = {"createNewTechnologies", "createNewSeniorities", "createNewTeams"})
	protected void createNewPersons() {
		// open and create new persons (Note: technologies all selected)
		workingSet.playground.openPeopleTab();
		workingSet.playground.createNewPerson(Constants.PERSON_BG, Constants.SENIOR, Constants.TEAM_BG);
		workingSet.playground.createNewPerson(Constants.PERSON_NS, Constants.MEDIOR, Constants.TEAM_NS);
		workingSet.playground.createNewPerson(Constants.PERSON_NI, Constants.JUNIOR, Constants.TEAM_NI);
	}
	
	@Test(dependsOnMethods = {"createNewPersons"})
	protected void createNewProject() {
		// open and create new project (Note: persons all selected)
		workingSet.playground.openProjectTab();
		workingSet.playground.createNewProject(Constants.PLAYGROUND_PROJECT);
	}

	@AfterClass
	protected void backToDeshboard() {
		workingSet.common.backToDeshboard();
	}
}
