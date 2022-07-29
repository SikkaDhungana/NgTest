package steps;

import com.fasterxml.jackson.core.io.JsonStringEncoder;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepDefinitions {
 WebDriver driver;



    @Given("^Navigate to Techfios page$")
    public void navigate_to_Techfios_page() throws Throwable {

       driver = new ChromeDriver();
        System.setProperty("WebDriver.chrome.driver", "drivers/chromedriver.exe");
        driver.get("https://www.techfios.com/billing/?ng=admin/");
    }


    @When("^User logged in using username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_logged_in_using_username_as_and_password_as(String arg1, String arg2) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("demo.techfois.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("abc123");
        driver.findElement(By.xpath("//*[@id='signIn']")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Then("^Home page should be displayed$")
    public void home_page_should_be_displayed() throws Throwable {
String expectedText="Gmail";
String actualText=driver.findElement(By.xpath("//*[@id='gbq1']/div/a/span")).getText();
Assert.assertTrue("Login not successful", expectedText.equals(actualText));
    }

}
