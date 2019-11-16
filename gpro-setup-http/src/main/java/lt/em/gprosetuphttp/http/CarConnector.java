package lt.em.gprosetuphttp.http;

import lt.em.gpro.model.*;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

class CarConnector {
    @NotNull
    private final WebDriver webDriver;

    CarConnector(@NotNull WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @NotNull
    Car parseCar() {
        webDriver.get("https://gpro.net/gb/UpdateCar.asp");
        List<Integer> myCarProperties = new ArrayList<>();
        List<WebElement> rows = webDriver.findElements(By.tagName("tr"));
        for (String carCharacter : rows.get(2).getText().split(" ")) {
            myCarProperties.add(Integer.parseInt(carCharacter));
        }

        return ImmutableCar.builder()
                .power(myCarProperties.get(0))
                .handling(myCarProperties.get(1))
                .acceleration(myCarProperties.get(2))
                .chassis(ImmutableChassis.builder()
                        .level(getLevel(rows.get(5), "newLvlCha"))
                        .wear(getWear(rows.get(5), "newWearCha"))
                        .build())
                .engine(ImmutableEngine.builder()
                        .level(getLevel(rows.get(6), "newLvlEng"))
                        .wear(getWear(rows.get(6), "newWearEng"))
                        .build())
                .frontWing(ImmutableFrontWing.builder()
                        .level(getLevel(rows.get(7), "newLvlFW"))
                        .wear(getWear(rows.get(7), "newWearFW"))
                        .build())
                .rearWing(ImmutableRearWing.builder()
                        .level(getLevel(rows.get(8), "newLvlRW"))
                        .wear(getWear(rows.get(8), "newWearRW"))
                        .build())
                .underbody(ImmutableUnderbody.builder()
                        .level(getLevel(rows.get(9), "newLvlUB"))
                        .wear(getWear(rows.get(9), "newWearUB"))
                        .build())
                .sidepods(ImmutableSidepods.builder()
                        .level(getLevel(rows.get(10), "newLvlSid"))
                        .wear(getWear(rows.get(10), "newWearSid"))
                        .build())
                .cooling(ImmutableCooling.builder()
                        .level(getLevel(rows.get(11), "newLvlCoo"))
                        .wear(getWear(rows.get(11), "newWearCoo"))
                        .build())
                .gearbox(ImmutableGearbox.builder()
                        .level(getLevel(rows.get(12), "newLvlGea"))
                        .wear(getWear(rows.get(12), "newWearGea"))
                        .build())
                .brakes(ImmutableBrakes.builder().
                        level(getLevel(rows.get(13), "newLvlBra"))
                        .wear(getWear(rows.get(13), "newWearBra"))
                        .build())
                .suspension(ImmutableSuspension.builder().
                        level(getLevel(rows.get(14), "newLvlSus"))
                        .wear(getWear(rows.get(14), "newWearSus"))
                        .build())
                .electronics(ImmutableElectronics.builder().
                        level(getLevel(rows.get(15), "newLvlEle"))
                        .wear(getWear(rows.get(15), "newWearEle"))
                        .build())
                .build();
    }

    private static int getLevel(@NotNull WebElement element, @NotNull String id) {
        return Integer.parseInt(element.findElement(By.id(id)).getText());
    }

    private static int getWear(@NotNull WebElement element, @NotNull String id) {
        String text = element.findElement(By.id(id)).getText();
        return Integer.parseInt(text.substring(0, text.length() -1));
    }
}
