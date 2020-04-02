package runnerFile;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features={"src/test/java/features/ApiDemo.feature"},
		glue={"stepDefn"},
		strict=true,
		monochrome=true,
		plugin={"pretty","html:target/cucumber-reports/cucumber-html-report","json:target/cucumber-reports/cucumber-json-report.json"}
		)

public class APITestRunnerJUnit{
	
}
