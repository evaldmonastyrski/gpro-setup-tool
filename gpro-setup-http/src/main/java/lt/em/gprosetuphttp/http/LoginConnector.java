package lt.em.gprosetuphttp.http;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

class LoginConnector {
    @NotNull private static final Logger LOGGER = LoggerFactory.getLogger(LoggerFactory.class);
    @NotNull private static final String LOGIN_URL = "http://gpro.net/gb/Login.asp";
    @NotNull private static final String USERNAME_FIELD = "textLogin";
    @NotNull private static final String PASSWORD_FIELD = "textPassword";
    @NotNull private static final String LOGIN_BUTTON = "LogonFake";
    @NotNull private static final String USERNAME_KEY = "username";
    @NotNull private static final String PASSWORD_KEY = "password";

    @NotNull private final WebDriver webDriver;
    @NotNull private final PropertyValues propertyValues;
    @NotNull private final Scanner scanner;
    @NotNull private final Preferences preferences;

    LoginConnector(@NotNull WebDriver webDriver, @NotNull PropertyValues propertyValues) {
        this.webDriver = webDriver;
        this.propertyValues = propertyValues;
        this.scanner = new Scanner(System.in);
        this.preferences = Preferences.userNodeForPackage(LoginConnector.class);
    }

    void login() {
        webDriver.get(LOGIN_URL);

        fillTextfield(USERNAME_FIELD, USERNAME_KEY, "Please enter your username");
        fillTextfield(PASSWORD_FIELD, PASSWORD_KEY, "Please enter your password");
        clickLogin();
    }

    private void fillTextfield(@NotNull String field, @NotNull String persistenceKey, @NotNull String message) {
        WebElement webField = webDriver.findElement(By.name(field));
        String storedText = preferences.get(persistenceKey, null);

        clearPersistedValues();

        if (storedText != null && !propertyValues.isCleanLogin()) {
            webField.sendKeys(storedText);
            return;
        }

        LOGGER.info(message);
        String inputText = scanner.nextLine();
        webField.sendKeys(inputText);
        preferences.put(persistenceKey, inputText);
    }

    private void clickLogin() {
        WebElement loginButton = webDriver.findElement(By.name(LOGIN_BUTTON));
        loginButton.click();
    }

    private void clearPersistedValues() {
        if (propertyValues.isFlushMemory()) {
            try {
                preferences.clear();
            } catch (BackingStoreException backingStoreException) {
                LOGGER.error("Failed to clear preferences {}", backingStoreException);
            }
        }
    }
}
