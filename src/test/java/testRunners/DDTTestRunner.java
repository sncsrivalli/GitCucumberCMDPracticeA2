package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/FeatureFiles/ActitimeDDT.feature",
					glue = "stepdefinitions",
					monochrome = true,
					plugin = {"pretty",
							"html:target/HTML/htmlReport.html",
							"junit:target/JUNIT/junitReport.xml",
							"json:target/JSON/jsonReport.json"})
public class DDTTestRunner {

}
