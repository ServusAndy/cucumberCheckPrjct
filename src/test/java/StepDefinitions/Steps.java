package StepDefinitions;

import Runners.Run;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Steps {

    private WebDriver driver;

    @Given("setUp Driver")
    public void setUpDriver() {
        driver = new Run().setUpWebDriver();
    }

    @Given("the user is on Login page")
    public void the_user_is_on_login_page() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
        driver.manage().window().fullscreen();
    }

    @When("the user enters valid user name \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void the_user_enters_valid_credentials(String userName, String password) {
        driver
                   .findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"))
                   .sendKeys(userName);
        driver
                .findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"))
                .sendKeys(password);

    }

    @When("hits Submit")
    public void hits_submit() {
        driver
                .findElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"))
                .click();
        driver.manage().window().fullscreen();
    }

    @Then("the user should be logged successfully")
    public void the_user_should_be_logged_successfully() {
        boolean isVisible = driver
                .findElement(By.xpath("//a[contains(text(),'Log Out')]"))
                .isDisplayed();
        Assert.assertEquals(isVisible,true);
    }

    @After(value = "@User.Login.Successfully")
    public void closeWebDriver(){
        driver.close();
    }
}
