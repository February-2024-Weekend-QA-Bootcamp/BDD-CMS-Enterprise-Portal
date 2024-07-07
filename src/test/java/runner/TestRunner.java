package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags 		= "@Login",
		features 	= "src/test/java/feature",
		glue 		= {"stepDefinition"},
		monochrome 	= false,
		dryRun 		= false,
		plugin 		= {"pretty","html:target/report.html","json:target/report.json", "junit:target/report.xml"}
		)

public class TestRunner {

}
