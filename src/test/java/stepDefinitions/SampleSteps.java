package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @Given("^I am on the locators page$")
    public void iAmOnTheLocatorsPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    @Then("^I should see both locators page headers$")
    public void iShouldSeeLocatorsPageHeader() throws Throwable {
        assertEquals("Heading 1", driver.findElement(By.id("heading_1")).getText());
        assertEquals("Heading 2 text", driver.findElement(By.id("heading_2")).getText());
    }

    @And("^Buttons in Locators page are clickable$")
    public void iShouldSeeEnabledLocatorButtons() throws Throwable {
        assertTrue(driver.findElement(By.name("randomButton1")).isEnabled());
        assertTrue(driver.findElement(By.name("randomButton2")).isEnabled());
    }

    @Then("^I see error: \"(.*)\"$")
    public void iSeeError(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("error")).getText());
    }

    @Then("^I am not navigated to age message page$")
    public void iAmNotInAgeMessagePage(String message) throws Throwable {
        assertFalse(driver.getCurrentUrl().contains("https://kristinek.github.io/site/examples/age_2.html"));
    }


    @Given("^I (?:am on|open) feedback page$")
    public void iAmOnFeedbackPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
    }

    @When("^I enter name in feedback: \"([^\"]*)\"$")
    public void iEnterNameInFeedback(String name) throws Throwable {
        driver.findElement(By.id("fb_name")).clear();
        driver.findElement(By.id("fb_name")).sendKeys(name);
    }

    @When("^I enter age in feedback: \"([^\"]*)\"$")
    public void iEnterAgeInFeedback(String age) throws Throwable {
        driver.findElement(By.id("fb_age")).clear();
        driver.findElement(By.id("fb_age")).sendKeys(age);
    }

    @When("^I click send feedback$")
    public void iClickSendFeedback() throws Throwable {
        driver.findElement(By.className("w3-btn-block")).click();
    }

    @Then("^I can see name \"([^\"]*)\" in feedback check$")
    public void iCanSeeNameInFeedbackCheck(String name) throws Throwable {
        assertEquals(name, driver.findElement(By.id("name")).getText());
    }

    @Then("^I can see age \"([^\"]*)\" in feedback check$")
    public void iCanSeeAgeInFeedbackCheck(String age) throws Throwable {
        assertEquals(age, driver.findElement(By.id("age")).getText());
    }
    // i just need a separator for the task

    @Given("^i am on enter a number page$")
    public void iAmOnEnterANumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^i enter a number \"([^\"]*)\"too small$")
    public void iEnterANumberTooSmall(String smallNumber) {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(smallNumber);
    }

    @When("^i click submit$")
    public void iClickSubmit() throws Throwable {
        driver.findElement(By.className("w3-btn")).click();
    }

    @Then("^i get error message: \"([^\"]*)\"$")
    public void iGetError(String errorMessage) throws Throwable {
        assertTrue(errorMessage, driver.findElement(By.id("ch1_error")).isDisplayed());
    }

    @When("^i enter a number \"([^\"]*)\" too big$")
    public void iEnterANumberTooBig(String bigNumber) {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(bigNumber);
    }

    @When("^i enter text \"([^\"]*)\"$")
    public void iEnterText(String text) {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(text);
    }

    @When("^i enter number \"([^\"]*)\"$")
    public void iEnterNumber(String number) {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);
    }

    @Then("^i am god$")
    public void iAMGod() {
        Alert alert = driver.switchTo().alert();
        String message = driver.switchTo().alert().getText();
        System.out.println(message);  // idk if this is needed but its p nice
        alert.accept();
    }
}

