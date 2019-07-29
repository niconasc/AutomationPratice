package runner;


import commons.Report_Builder;
import commons.SeleniumRobot;
import commons.Utils;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty", "html:src/main/report",
                "json:src/main/report/cucumber.json",
                "junit:src/main/report/cucumber.xml"
        },
        features = {
                "src/main/resources"
        },
        glue = {
                "steps", "hooks"
        },
        tags = {
                "@AutomationPratice"
        }
)
public class RunTest extends SeleniumRobot {

    @AfterClass
    public static void afterClass() {
        Report_Builder.main();
        Utils.removeEmbeddedImages();
    }

}
