package runnerFile;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features={"src/test/java/features/ApiDemo.feature"},
		glue={"stepDefn"},
		strict=true,
		monochrome=true,
		plugin={"pretty","html:target/cucumber-reports/cucumber-html-report","json:target/cucumber-reports/cucumber-json-report.json"}
		)

public class APITestRunnerTestNG extends AbstractTestNGCucumberTests{
	
}

