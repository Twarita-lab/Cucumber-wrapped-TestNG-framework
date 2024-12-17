package cucumberRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/Features",
					glue="stepDefinitions",
					tags = "@Regression",
					monochrome=true,
					plugin= { "pretty", "html:Reports/regression_cucumber-reports.html" })
public class Regression extends AbstractTestNGCucumberTests{

}
