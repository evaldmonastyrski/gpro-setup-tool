package lt.em.gprosetuphttp.http;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GPROConnector {
    @NotNull private static final Logger LOGGER = LoggerFactory.getLogger(GPROConnector.class);
    @NotNull private static final String WEB_DRIVER_KEY = "webdriver.chrome.driver";
    @NotNull private static final String WEB_DRIVER_PATH = "/usr/local/bin/chromedriver";

    @NotNull private final PropertyValues propertyValues;
    @NotNull private final LoginConnector loginConnector;

    public GPROConnector() {
        System.setProperty(WEB_DRIVER_KEY, WEB_DRIVER_PATH);
        @NotNull WebDriver webDriver = new ChromeDriver();
        propertyValues = new PropertyValues();
        loginConnector = new LoginConnector(webDriver, propertyValues);
    }

    public void connect() {
        LOGGER.info("Connecting to GPRO website...");
        loginConnector.login();
    }
}
