package lt.em.gpro.http;

import lt.em.gpro.model.output.Setup;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

class PractiseActivator {
    @NotNull
    private final WebDriver webDriver;

    PractiseActivator(@NotNull WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    void drivePractiseLap(@NotNull Setup setup, @NotNull String tyreCompound) {
        webDriver.get("https://gpro.net/gb/Qualify.asp");
        webDriver.findElement(By.name("FWing")).sendKeys(String.valueOf(setup.getFrontWing()));
        webDriver.findElement(By.name("RWing")).sendKeys(String.valueOf(setup.getRearWing()));
        webDriver.findElement(By.name("Engine")).sendKeys(String.valueOf(setup.getEngine()));
        webDriver.findElement(By.name("Brakes")).sendKeys(String.valueOf(setup.getBrakes()));
        webDriver.findElement(By.name("Gear")).sendKeys(String.valueOf(setup.getGear()));
        webDriver.findElement(By.name("Suspension")).sendKeys(String.valueOf(setup.getSuspension()));
        Select dropdown = new Select(webDriver.findElement(By.id("Tyres")));
        dropdown.selectByVisibleText(tyreCompound);
        webDriver.findElement(By.name("DriveLap")).click();
    }
}
