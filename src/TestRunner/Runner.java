package TestRunner;

import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)				
@CucumberOptions(features="features",
				 glue={"com.test.config","StepDefinition"},
				 plugin = {"pretty",
						 	"json:target/cucumber.json",
						 	"junit:target/cucumber.xml",
						 	"html:target/cucumber-reports"},
				 monochrome = true
				)	

public class Runner 				
{		

}
