package runner;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("src/test/resources/feature")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "steps")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty, io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm")
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME, value = "src/test/resources/feature")
public class RunTests {
}