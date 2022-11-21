package demo;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@CucumberOptions(features = {"src/test/resources/demo"}, glue = "demo")
@Listeners({ExtentITestListenerClassAdapter.class})
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
