package in.podtest.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/Login.feature"},
        glue = {"in.podtest.cucumber.stepdefinitions", "in.podtest.cucumber.hooks"},
        tags =  "@jira100",
        plugin = {"html:target/cucumber.html"}
)

public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
