package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",  
    //specific file feature run e.g.  features/feature file name
    glue = "stepDefinitions",
    //plugin= {"pretty"}, // for report generate
    plugin = { "html:target/cucumber-reports/reports" },
   // tags = "@activity2", // to run all feature file then need to reove tags
    //tags = "@SmokeTest and @RegressionTest",  // to run specific tag
    		monochrome=true //like this
)

public class ActivitiesRunner {

}
