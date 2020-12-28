package tau.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tau.steps.Base.BaseUtil;

import static org.junit.Assert.assertTrue;

public class Steps extends BaseUtil {

    private BaseUtil baseUtil;

    public Steps(BaseUtil util) {
        this.baseUtil = util;
    }

    private WebDriver driver;

    @Given("I am in the login page of the Para Bank Application")
    public void i_am_in_the_login_page_of_the_Para_Bank_Application() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I enter valid {string} and {string} with {string}")
    public void i_enter_valid_credentials(String username, String password, String userFullName1) {
        baseUtil.userFullName = userFullName1;
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("username")).submit();
    }

    @Then("I should be taken to the Overview page")
    public void i_should_be_taken_to_the_Overview_page() throws Exception {
        String actualuserFullName = driver.findElement(By.className("smallText")).getText().toString();
        assertTrue(actualuserFullName, actualuserFullName.contains(baseUtil.userFullName));
        driver.findElement(By.linkText("Log Out")).click();
        driver.quit();
    }
    }
