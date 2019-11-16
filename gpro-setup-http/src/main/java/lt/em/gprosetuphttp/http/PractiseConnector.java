package lt.em.gprosetuphttp.http;

import lt.em.gpro.model.ImmutablePractise;
import lt.em.gpro.model.Practise;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

class PractiseConnector {
    private final static int LAP_INDEX = 14;
    private static final int SECONDS_IN_MINUTE = 60;

    @NotNull
    private final WebDriver webDriver;

    PractiseConnector(@NotNull WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @NotNull
    Practise parsePractise() {
        webDriver.get("https://gpro.net/gb/Qualify.asp");
        List<WebElement> headers = webDriver.findElements(By.tagName("h2"));
        String trackName = headers.get(1).getText().split(": ")[1];

        List<WebElement> rows = webDriver.findElements(By.tagName("tr"));

        int trackPower = rows.get(0).findElements(By.tagName("img")).size();
        int trackHandling = rows.get(1).findElements(By.tagName("img")).size();
        int trackAcceleration = rows.get(2).findElements(By.tagName("img")).size();

        String[] weatherInfo = rows.get(6).getText().split(" ");
        int temperature = Integer.parseInt(weatherInfo[1].split("°")[0]);
        int humidity = Integer.parseInt(weatherInfo[2].split("%")[0]);

        int lapsDriven = Integer.parseInt(rows.get(11).getText().subSequence(30, 31).toString());
        if (lapsDriven != 0) {
            String[] practiseLapDetails = rows.get(LAP_INDEX + lapsDriven - 1).getText().split(" ");

            return ImmutablePractise.builder()
                    .trackName(trackName)
                    .attempt(lapsDriven)
                    .netTime(parseLaptime(practiseLapDetails[3]))
                    .frontWingSetup(Integer.parseInt(practiseLapDetails[4]))
                    .rearWingSetup(Integer.parseInt(practiseLapDetails[5]))
                    .engineSetup(Integer.parseInt(practiseLapDetails[6]))
                    .brakesSetup(Integer.parseInt(practiseLapDetails[7]))
                    .gearSetup(Integer.parseInt(practiseLapDetails[8]))
                    .suspensionSetup(Integer.parseInt(practiseLapDetails[9]))
                    .tyreType(practiseLapDetails[10])
                    .trackPower(trackPower)
                    .trackHandling(trackHandling)
                    .trackAcceleration(trackAcceleration)
                    .temperatureQ1(temperature)
                    .humidityQ1(humidity)
                    .build();
        }

        return ImmutablePractise.builder()
                .trackName(trackName)
                .attempt(0)
                .netTime(0)
                .frontWingSetup(0)
                .rearWingSetup(0)
                .engineSetup(0)
                .brakesSetup(0)
                .gearSetup(0)
                .suspensionSetup(0)
                .tyreType("")
                .trackPower(trackPower)
                .trackHandling(trackHandling)
                .trackAcceleration(trackAcceleration)
                .temperatureQ1(temperature)
                .humidityQ1(humidity)
                .build();
    }

    private static double parseLaptime(String laptimeString) {
        int length = laptimeString.length();
        String[] split = laptimeString.substring(0, length - 1).split(":");
        return Double.parseDouble(split[0]) * SECONDS_IN_MINUTE + Double.parseDouble(split[1]);
    }
}
