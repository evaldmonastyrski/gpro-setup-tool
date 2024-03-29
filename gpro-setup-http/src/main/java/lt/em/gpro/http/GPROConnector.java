package lt.em.gpro.http;

import lt.em.gpro.http.input.CarConnector;
import lt.em.gpro.http.input.DriverConnector;
import lt.em.gpro.http.input.FacilitiesConnector;
import lt.em.gpro.http.input.LoginConnector;
import lt.em.gpro.http.input.PractiseConditionsConnector;
import lt.em.gpro.http.input.PractiseConnector;
import lt.em.gpro.model.input.Car;
import lt.em.gpro.model.input.Driver;
import lt.em.gpro.model.output.Practise;
import lt.em.gpro.model.input.PractiseConditions;
import lt.em.gpro.model.output.Setup;
import lt.em.gpro.model.input.StaffAndFacilities;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GPROConnector {
    @NotNull private static final Logger LOGGER = LoggerFactory.getLogger(GPROConnector.class);
    @NotNull private static final String WEB_DRIVER_KEY = "webdriver.chrome.driver";
    @NotNull private static final String APPLE_WEB_DRIVER_PATH = "/usr/local/bin/chromedriver";
    @NotNull private static final String WINODWS_WEB_DRIVER_PATH = "C:\\workspace\\\\chromedriver.exe";

    @NotNull private final WebDriver webDriver;
    @NotNull private final LoginConnector loginConnector;
    @NotNull private final DriverConnector driverConnector;
    @NotNull private final CarConnector carConnector;
    @NotNull private final PractiseConditionsConnector practiseConditionsConnector;
    @NotNull private final PractiseConnector practiseConnector;
    @NotNull private final FacilitiesConnector facilitiesConnector;
    @NotNull private final PractiseActivator practiseActivator;

    public GPROConnector() {
        String webDriverPath = isApple() ? APPLE_WEB_DRIVER_PATH : WINODWS_WEB_DRIVER_PATH;
        System.setProperty(WEB_DRIVER_KEY, webDriverPath);
        @NotNull PropertyValues propertyValues = new PropertyValues();
        @NotNull ChromeOptions options = new ChromeOptions();
        if (propertyValues.isHeadless()) {
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
        }
        webDriver = new ChromeDriver(options);
        loginConnector = new LoginConnector(webDriver, propertyValues);
        driverConnector = new DriverConnector(webDriver);
        carConnector = new CarConnector(webDriver);
        practiseConditionsConnector = new PractiseConditionsConnector(webDriver);
        practiseConnector = new PractiseConnector(webDriver);
        facilitiesConnector = new FacilitiesConnector(webDriver);
        practiseActivator = new PractiseActivator(webDriver);
    }

    public void login() {
        LOGGER.info("Connecting to GPRO website...");
        loginConnector.login();
    }

    @NotNull
    public Driver getDriverData() {
        Driver driver = driverConnector.parseDriverSkills();
        LOGGER.info("Driver skills: {}", driver);
        return driver;
    }

    @NotNull
    public Car getCarData() {
        Car car = carConnector.parseCar();
        LOGGER.info("Car: {}", car);
        return car;
    }

    @NotNull
    public PractiseConditions getPractiseConditionsData() {
        PractiseConditions practiseConditions  = practiseConditionsConnector.parsePractiseConditions();
        LOGGER.info("Practise Conditions: {}", practiseConditions);
        return practiseConditions;
    }

    @NotNull
    public Practise getPractiseData() {
        Practise practise = practiseConnector.parsePractise();
        LOGGER.info("Practise: {}", practise);
        return practise;
    }

    @NotNull
    public StaffAndFacilities getStaffAndFacilitiesData() {
        StaffAndFacilities staffAndFacilities = facilitiesConnector.parseStaffAndFacilities();
        LOGGER.info("Staff & Facilities: {}", staffAndFacilities);
        return staffAndFacilities;
    }

    public void drivePractiseLap(@NotNull Setup setup, @NotNull String tyreCompound) {
        practiseActivator.drivePractiseLap(setup, tyreCompound);
    }

    public void closeBrowser() {
        webDriver.quit();
    }

    private static boolean isApple() {
        return getOsName().startsWith("Mac OS X");
    }

    private static boolean isWindows() {
        return getOsName().startsWith("Windows");
    }

    @NotNull
    private static String getOsName() {
        return System.getProperty("os.name");
    }
}
