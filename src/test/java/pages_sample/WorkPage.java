package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.*;

public class WorkPage {
    @FindBy(how = How.ID, using = "name") // By.id("name")
    private WebElement nameInput; // WebElement nameInput = driver.findElement(By.id("name"));
    @FindBy(how = How.ID, using = "job") // By.name("age")
    private WebElement jobInput;
    @FindBy(how = How.ID, using = "submit")
    private WebElement addPersonBtn;
    @FindBy(how = How.ID, using = "modal_button")
    private WebElement addBtn;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/span[2]")
    private WebElement editBtn;
    //@FindBy(how = How.CLASS_NAME, using = "error") // By.className("error)
    //private WebElement errorText;

    public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html";
    }

    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterJob(String job) {
        jobInput.clear();
        jobInput.sendKeys(job);
    }

    public void clickAdd() {
        addBtn.click();
    }

    public void clickAddPerson() { addPersonBtn.click(); }

    public void clickEdit() { editBtn.click(); }

    public void enterNameJobAndClickAdd(String name, String job) {
        enterNameJobAndClickAdd(name, job);
    }

    public void enterNameJobAndClickSubmit(String name, String job) {
        enterName(name);
        enterJob(job);
        addBtn.click();
    }
}
