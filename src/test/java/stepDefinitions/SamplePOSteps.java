package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.*;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SamplePOSteps {
    private WebDriver driver;
    static AgePage agePage;
    static WorkPage workPage;
    static AgeSubmittedPage ageSubmittedPage;


    public SamplePOSteps() {
        this.driver = Hooks.driver;
        agePage = PageFactory.initElements(Hooks.driver, AgePage.class);
        workPage = PageFactory.initElements(Hooks.driver, WorkPage.class);
        ageSubmittedPage = PageFactory.initElements(Hooks.driver, AgeSubmittedPage.class);
    }

    @When("^I enter name: \"([^\"]*)\" using PO$")
    public void iEnterName(String name) throws Throwable {
        agePage.enterName(name);
    }

    @And("^I enter age: (\\d+) using PO$")
    public void iEnterAge(int age) throws Throwable {
        agePage.enterAge(age);
    }

    @Given("^I (?:am on|open) age page using PO$")
    public void iAmOnAgePage() throws Throwable {
        driver.get(agePage.getPageUrl());
    }

    @And("^I click submit age using PO$")
    public void iClickSubmitAge() throws Throwable {
        agePage.clickSubmit();
    }

    @Then("^I see message: \"(.*)\" using PO$")
    public void iSeeMessage(String message) throws Throwable {
        ageSubmittedPage.checkMessageText(message);
    }

    @When("^I enter values using PO:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        agePage.enterName(valuesToEnter.get("name"));
        agePage.enterAge(valuesToEnter.get("age"));
    }

    @Then("^I see error: \"([^\"]*)\" using PO$")
    public void iSeeErrorInAgePage(String errorText) throws Throwable{
        agePage.checkErrorMessage(errorText);
    }

    @Then("^I remain in age page using PO$")
    public void iAminAgePage() throws Throwable{
        assertEquals(agePage.getPageUrl(), driver.getCurrentUrl());
    }
    // separator for me and myself only

    @Given("^i am on the page$")
    public void iAmOnWorkPageGiven() throws Throwable {
        driver.get(workPage.getPageUrl());
    }

    @When("^i click add person button using PO$")
    public void iAddPerson() throws Throwable {
        workPage.clickAddPerson();
    }

    @And("^i enter name: \"([^\"]*)\" using PO$")
    public void iEnterWorkName(String name) throws Throwable {
        workPage.enterName(name);
    }

    @And("^i enter job: \"([^\"]*)\" using PO$")
    public void iEnterJobName(String job) throws Throwable {
        workPage.enterJob(job);
    }

    @And("^i click add button using PO$")
    public void iClickAddButton() throws Throwable {
        workPage.clickAdd();
    }

    @Then("^i see \"([^\"]*)\" and \"([^\"]*)\" on the list/page idk$")
    public void iSeeThings(String name, String job) throws Throwable {
        // i think i need to make a list and look if the string is there
        // yet i dont posses the knowledge and the clock is against me
    }

    // oke am finsihing this up am gon use the ye ole way

    @When("^i click edit icon$")
    public void iEditPerson() throws Throwable {
        driver.findElement(By.className("w3-closebtn editbtn w3-padding w3-margin-right w3-medium")).click();
    }

    @And("^i edit \"([^\"]*)\" name$")
    public void iEditName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^i edit \"([^\"]*)\" job$")
    public void iEditJob(String job) throws Throwable {
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @And("^i click edit button$")
    public void iClickEditBtn() throws Throwable {
        driver.findElement(By.id("modal_button")).click();
    }

    @And("^i click delete icon$")
    public void iClickDeleteIcon() throws Throwable {
        driver.findElement(By.className("w3-closebtn closebtn w3-padding w3-margin-right w3-medium")).click();
    }

    @Then("^person gets removed from this realm$")
    public void personGetRedacted() throws Throwable{
         /*i can try to explain the idea i would use
        i would use assert false and put the name as the "expected"
        that does imply that i should've incorporated the name in the method
        and therefore also included in the scenario outline
        c:
        */
    }

    // gonna be honest i dont think i can squeeze something more for today
    // also i dont want to pull an allnighter for this, i hope you understand
}

