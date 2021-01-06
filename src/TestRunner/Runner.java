package TestRunner;

import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;		

@RunWith(Cucumber.class)				
@CucumberOptions(features="features",strict = false,glue={"com.test.config",
															"StepDefinition"})						
public class Runner 				
{		

}
