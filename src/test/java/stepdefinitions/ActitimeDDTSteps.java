package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActitimeDDTSteps {
	WebDriver driver;

	@Given("I want to navigate to actitime")
	public void i_want_to_navigate_to_actitime() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("^I enter (.*) and (.*)$")
	public void i_enter_username_and_password(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
	}

	@When("Hit on enter")
	public void hit_on_enter() {
		driver.findElement(By.id("loginButton")).click();
	}

	@Then("^Actitime home page with (.*) is displayed$")
	public void actitime_home_page_with_success_is_displayed(String status) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.titleContains("Enter Time-Track"));
			System.out.println(status);
		} catch (Exception e) {
			System.out.println(status);
		} finally {
			driver.quit();
		}
	}
}
