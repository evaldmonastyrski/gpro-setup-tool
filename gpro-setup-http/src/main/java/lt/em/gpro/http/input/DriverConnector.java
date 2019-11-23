package lt.em.gpro.http.input;

import lt.em.gpro.model.input.Driver;
import lt.em.gpro.model.input.ImmutableDriver;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DriverConnector {
    private static final int FROM_INDEX = 11;
    private static final int TO_INDEX = 37;

    @NotNull private final WebDriver webDriver;

    public DriverConnector(@NotNull WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @NotNull
    public Driver parseDriverSkills() {
        webDriver.get("https://gpro.net/gb/TrainingSession.asp");
        List<WebElement> headers = webDriver.findElements(By.tagName("h1"));
        String driverName = headers.get(1).getText().split(": ")[1];
        List<WebElement> rows = webDriver.findElements(By.tagName("tr")).subList(FROM_INDEX, TO_INDEX);
        List<Integer> myDriverSkills = new ArrayList<>();
        for (WebElement row : rows) {
            String rowEntry = row.getText();
            if (rowEntry.length() > 0) {
                if (rowEntry.contains("%")) {
                    myDriverSkills.add(Integer.parseInt(rowEntry.split("%")[0]));
                    continue;
                }
                myDriverSkills.add(Integer.parseInt(rowEntry.split(":")[1].trim()));
            }
        }

        return ImmutableDriver.builder()
                .name(driverName)
                .energy(myDriverSkills.get(0))
                .overall(myDriverSkills.get(1))
                .concentration(myDriverSkills.get(2))
                .talent(myDriverSkills.get(3))
                .aggressiveness(myDriverSkills.get(4))
                .experience(myDriverSkills.get(5))
                .technicalInsight(myDriverSkills.get(6))
                .stamina(myDriverSkills.get(7))
                .charisma(myDriverSkills.get(8))
                .motivation(myDriverSkills.get(9))
                .reputation(myDriverSkills.get(10))
                .weight(myDriverSkills.get(11))
                .age(myDriverSkills.get(12))
                .build();
    }
}
