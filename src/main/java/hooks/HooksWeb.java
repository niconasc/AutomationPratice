package hooks;

import commons.PropertiesManager;
import commons.SeleniumRobot;
import commons.Utils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;

import java.io.IOException;


public class HooksWeb extends SeleniumRobot {
    private static String path = "src/main/resources/properties/web.properties";
    PropertiesManager propertiesManager = new PropertiesManager();

    @Before(value = "@web")
    public void beforeWeb() {
        inicializarNavegador(propertiesManager.getProp(path, "navegador"));
    }

    @After(value = "@web")
    public void after() throws IOException {
        if (getWebDriver() != null) {
            waitPageToLoad();
            quitDriver();
            Utils.killallChromeDriver();
        }
    }

    @AfterStep(value = "@web")
    public void afterStepWeb(Scenario scenario) {
        Utils.embeddImagesInReportWeb(scenario);
    }
}
