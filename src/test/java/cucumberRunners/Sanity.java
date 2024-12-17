package cucumberRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/Features",
					glue="stepDefinitions",
					tags = "@Sanity",
					monochrome=true,
					plugin= { "pretty", "html:Reports/sanity_cucumber-reports.html" })
public class Sanity extends AbstractTestNGCucumberTests{

}
