package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDefinitions"},
    		plugin = {
    		        "pretty",
    		        "html:target/cucumber-reports/report.html",
    		        "json:target/cucumber-reports/report.json",
    		        "junit:target/cucumber-reports/report3.xml"},
    monochrome = true
)
public class TestRunner {
}


