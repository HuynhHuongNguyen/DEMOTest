package demo;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/demo"}, glue = "demo")
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
