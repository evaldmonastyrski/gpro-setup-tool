package lt.em.gprosetuphttp.http;

import lt.em.gpro.model.Driver;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GPROConnector {
    @NotNull private static final Logger LOGGER = LoggerFactory.getLogger(GPROConnector.class);
    @NotNull private static final String WEB_DRIVER_KEY = "webdriver.chrome.driver";
    @NotNull private static final String WEB_DRIVER_PATH = "/usr/local/bin/chromedriver";

    @NotNull private final WebDriver webDriver;
    @NotNull private final LoginConnector loginConnector;
    @NotNull private final DriverConnector driverConnector;

    public GPROConnector() {
        System.setProperty(WEB_DRIVER_KEY, WEB_DRIVER_PATH);
        @NotNull PropertyValues propertyValues = new PropertyValues();
        @NotNull ChromeOptions options = new ChromeOptions();
        if (propertyValues.isHeadless()) {
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
        }
        webDriver = new ChromeDriver(options);
        loginConnector = new LoginConnector(webDriver, propertyValues);
        driverConnector = new DriverConnector(webDriver);
    }

    @NotNull
    public Driver getDriverData() {
        LOGGER.info("Connecting to GPRO website...");
        loginConnector.login();
        Driver driver = driverConnector.parseDriverSkills();
        LOGGER.info("Driver skills: {}", driver);
        webDriver.quit();
        return driver;
    }
}
