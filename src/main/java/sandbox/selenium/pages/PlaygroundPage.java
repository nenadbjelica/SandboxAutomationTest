package sandbox.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import sandbox.selenium.base.BasePage;

public class PlaygroundPage extends BasePage {

	public PlaygroundPage(WebDriver driver) {
		super(driver);
	}

	private By playgroundCard = By.cssSelector("[href='/projects'] h5");
	
	private By projectTab = By.cssSelector("[href='/projects']");
	private By teamsTab = By.cssSelector("[href='/roles']");
	private By peopleTab = By.cssSelector("[href='/people']");
	private By senioritiesTab = By.cssSelector("[href='/seniorities']");
	private By technologiesTab = By.cssSelector("[href='/technologies']");
	
	private By creatProject = By.cssSelector("[href='/create-project']");
	private By createTeam = By.cssSelector("[href='/create-role']");
	private By createPerson = By.cssSelector("[href='/create-person']");
	private By createSeniority = By.cssSelector("[href='/create-seniority']");
	private By createTechnology = By.cssSelector("[href='/create-technology']");

	private By projectTitle = By.name("project_title");
	private By selectPeople = By.cssSelector("[placeholder='Select people']");
	private By teamTitle = By.name("role_name");
	private By fullPersonName = By.name("people_name");
	private By selectTechnologies = By.cssSelector("[placeholder='Select technologies']");
	private By selectSeniority = By.cssSelector("[placeholder='Select seniority']");
	private By selectTeam = By.cssSelector("[placeholder='Select team']");
	private By chooseOption = By.cssSelector("[role='option']");
	private By seniorityTitle = By.name("seniority_title");
	private By technologyTitle = By.name("technology_title");
	private By submit = By.cssSelector("[type='submit']");
	
	public void openPlaygroundCard() {
		click(playgroundCard);
	}
	
	public void openProjectTab() {
		click(projectTab);
	}
	
	public void openTeamsTab() {
		click(teamsTab);
	}
	
	public void openPeopleTab() {
		click(peopleTab);
	}
	
	public void openSenioritiesTab() {
		click(senioritiesTab);
	}
	
	public void openTechnologiesTab() {
		click(technologiesTab);
	}
	
	public void createProject() {
		click(creatProject);
	}
	
	public void createTeam() {
		click(createTeam);
	}
	
	public void createPerson() {
		click(createPerson);
	}
	
	public void createTechnology() {
		click(createTechnology);
	}
	
	public void createSeniority() {
		click(createSeniority);
	}
	
	public void inputTeamTitle(String strTeamTitle) {
		input(teamTitle, strTeamTitle);
	}
	
	public void selectAllPeople() {
		click(selectPeople);
		clickAllElements(chooseOption);
	}
	
	public void inputProjectTitle(String strProjectTitle) {
		input(projectTitle, strProjectTitle);
	}
	
	public void inputFullPersonName(String strFullPersonName) {
		input(fullPersonName, strFullPersonName);
	}
	
	public void selectAllTechnologies() {
		click(selectTechnologies);
		clickAllElements(chooseOption);
	}
	
	public void selectSeniority(String strSeniority) {
		input(selectSeniority, strSeniority);
		click(chooseOption);
	}
	
	public void selectTeam(String strTeam) {
		input(selectTeam, strTeam);
		click(chooseOption);
	}
	
	public void inputSeniorityTitle(String strSeniorityTitle) {
		input(seniorityTitle, strSeniorityTitle);
	}
	
	public void inputTechnologyTitle(String strTechnologyTitle) {
		input(technologyTitle, strTechnologyTitle);
	}
	
	public void clickSubmit() {
		click(submit);
	}
	
	public void createNewTechnology(String technology) {
		createTechnology();
		inputTechnologyTitle(technology);
		clickSubmit();
	}
	
	public void createNewSeniority(String seniority) {
		createSeniority();
		inputSeniorityTitle(seniority);
		clickSubmit();
	}
	
	public void createNewTeam(String team) {
		createTeam();
		inputTeamTitle(team);
		clickSubmit();
	}
	
	public void createNewPerson(String personName, String seniority, String team) {
		createPerson();
		inputFullPersonName(personName);
		selectAllTechnologies();
		selectSeniority(seniority);
		selectTeam(team);
		clickSubmit();
	}
	
	public void createNewProject(String projectName) {
		createProject();
		inputProjectTitle(projectName);
		selectAllPeople();
		clickSubmit();
	}
	
}
