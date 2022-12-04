package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@CucumberOptions(
        features = "src/test/resources/firstTest.feature",
        glue = {"StepDefinitions"}
)
public class Run extends AbstractTestNGCucumberTests {

    private WebDriver driver;

    public WebDriver setUpWebDriver(){
        WebDriverManager.chromedriver();
        driver = new ChromeDriver();
        return getWebDriver();
    }

    public WebDriver getWebDriver() {
        return  driver;
    }
}
