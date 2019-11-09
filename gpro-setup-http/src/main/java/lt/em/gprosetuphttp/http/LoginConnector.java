package lt.em.gprosetuphttp.http;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class LoginConnector {
    @NotNull private static final String LOGIN_URL = "http://gpro.net/gb/Login.asp";
    @NotNull private static final String USERNAME_FIELD = "textLogin";
    @NotNull private static final String PASSWORD_FIELD = "textPassword";
    @NotNull private static final String LOGIN_BUTTON = "LogonFake";

    @NotNull private final WebDriver webDriver;

    LoginConnector(@NotNull WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    void login() {
        webDriver.get(LOGIN_URL);
        WebElement usernameField = webDriver.findElement(By.name(USERNAME_FIELD));
        usernameField.sendKeys("evaldmon");
        WebElement passwordField = webDriver.findElement(By.name(PASSWORD_FIELD));
        passwordField.sendKeys("hCeT8AYR");
        WebElement loginButton = webDriver.findElement(By.name(LOGIN_BUTTON));
        loginButton.click();
    }
}
