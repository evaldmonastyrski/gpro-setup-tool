package lt.em.gpro.http.input;

import lt.em.gpro.model.input.ImmutablePractiseConditions;
import lt.em.gpro.model.input.PractiseConditions;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PractiseConditionsConnector {
    @NotNull private static final String RAIN_GIF_NAME = "wRain.gif";
    @NotNull private final WebDriver webDriver;

    public PractiseConditionsConnector(@NotNull WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @NotNull
    public PractiseConditions parsePractiseConditions() {
        webDriver.get("https://gpro.net/gb/Qualify.asp");
        int trackId = Integer.parseInt(webDriver.findElement(By.linkText("Track information"))
                .getAttribute("href").split("=")[1]);
        String weather = !webDriver.findElement(By.name("WeatherQ"))
                .getAttribute("src").split("/images/")[1].equals(RAIN_GIF_NAME) ? "DRY" : "WET";

        List<WebElement> headers = webDriver.findElements(By.tagName("h2"));
        String trackName = headers.get(1).getText().split(": ")[1];

        List<WebElement> rows = webDriver.findElements(By.tagName("tr"));

        int trackPower = rows.get(0).findElements(By.tagName("img")).size();
        int trackHandling = rows.get(1).findElements(By.tagName("img")).size();
        int trackAcceleration = rows.get(2).findElements(By.tagName("img")).size();

        String[] weatherInfo = rows.get(6).getText().split(" ");
        int temperature = Integer.parseInt(weatherInfo[1].split("°")[0]);
        int humidity = Integer.parseInt(weatherInfo[2].split("%")[0]);

        return ImmutablePractiseConditions.builder()
                .trackName(trackName)
                .trackId(trackId)
                .trackPower(trackPower)
                .trackHandling(trackHandling)
                .trackAcceleration(trackAcceleration)
                .temperatureQ1(temperature)
                .humidityQ1(humidity)
                .weather(weather)
                .build();
    }
}
