package lt.em.gprosetuphttp.http;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

class LoginConnector {
    @NotNull private static final Logger LOGGER = LoggerFactory.getLogger(LoggerFactory.class);
    @NotNull private static final String LOGIN_URL = "http://gpro.net/gb/Login.asp";
    @NotNull private static final String USERNAME_FIELD = "textLogin";
    @NotNull private static final String PASSWORD_FIELD = "textPassword";
    @NotNull private static final String LOGIN_BUTTON = "LogonFake";

    @NotNull private final WebDriver webDriver;
    @NotNull private final Scanner scanner;

    LoginConnector(@NotNull WebDriver webDriver) {
        this.webDriver = webDriver;
        this.scanner = new Scanner(System.in);
    }

    void login() {
        webDriver.get(LOGIN_URL);

        fillUserName();
        fillPassword();
        clickLogin();
    }

    private void fillUserName() {
        WebElement usernameField = webDriver.findElement(By.name(USERNAME_FIELD));
        LOGGER.info("Please enter your username");
        usernameField.sendKeys(scanner.nextLine());
    }

    private void fillPassword() {
        WebElement passwordField = webDriver.findElement(By.name(PASSWORD_FIELD));
        LOGGER.info("Please enter your password");
        passwordField.sendKeys(scanner.nextLine());
    }

    private void clickLogin() {
        WebElement loginButton = webDriver.findElement(By.name(LOGIN_BUTTON));
        loginButton.click();
    }
}
