package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features/JpetHome.feature",
		glue={"stepDef","hooks"}, monochrome=true,
		plugin = {"pretty", "html:target/cucumber-reports/JpetCapstone.html"}
		)
public class JpetRunner extends AbstractTestNGCucumberTests {

}
