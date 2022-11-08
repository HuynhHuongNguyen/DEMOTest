package demo;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("demo")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "html:target/surefire-reports/RunCucumberTest.html")
public class RunCucumberTest {
}
