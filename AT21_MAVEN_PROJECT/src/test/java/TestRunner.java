import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/feature",
        glue = "pageFeature",
        plugin = {"pretty", "html:target/cucumber-html-report.html"}
)      public class TestRunner extends AbstractTestNGCucumberTests {}