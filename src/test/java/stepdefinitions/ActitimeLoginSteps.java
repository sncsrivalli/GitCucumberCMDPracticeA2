package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActitimeLoginSteps {

	WebDriver driver;
	@Given("User navigates to actitime")
	public void user_navigates_to_actitime() {
	    System.setProperty("webdriver.chrome.driver", "./src/main/resources"
	    		+ "/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://demo.actitime.com/login.do");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("User enters valid credentials")
	public void user_enters_valid_credentials() {
	    driver.findElement(By.id("username")).sendKeys("admin");
	    driver.findElement(By.name("pwd")).sendKeys("manager");
	}

	@And("Clicks on login")
	public void clicks_on_login() {
	    driver.findElement(By.id("loginButton")).click();
	}

	@Then("User should navigate to actitime home page")
	public void user_should_navigate_to_actitime_home_page() {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   wait.until(ExpectedConditions.titleContains("Enter Time-Track"));
	   driver.quit();
	}
}
