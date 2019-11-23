package lt.em.gpro.http.input;

import lt.em.gpro.model.input.ImmutableStaffAndFacilities;
import lt.em.gpro.model.input.StaffAndFacilities;
import lt.em.gpro.model.staffandfacilities.ImmutableFacilities;
import lt.em.gpro.model.staffandfacilities.ImmutableStaff;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class FacilitiesConnector {
    private static final int LAST_STAFF_FACILITIES_INDEX = 28;
    @NotNull
    private final WebDriver webDriver;

    public FacilitiesConnector(@NotNull WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @NotNull
    public StaffAndFacilities parseStaffAndFacilities() {
        webDriver.get("https://gpro.net/gb/StaffAndFacilities.asp");
        List<Integer> properties = webDriver.findElements(By.tagName("tr"))
                .subList(0, LAST_STAFF_FACILITIES_INDEX)
                .stream()
                .filter(webElement -> !webElement.getText().isEmpty())
                .map(value -> Integer.parseInt(value.getText().split(": ")[1].stripLeading()))
                .collect(Collectors.toList());

        return ImmutableStaffAndFacilities.builder()
                .overall(properties.get(0))
                .staff(ImmutableStaff.builder()
                        .experience(properties.get(1))
                        .motivation(properties.get(2))
                        .technicalSkill(properties.get(3))
                        .stressHandling(properties.get(4))
                        .concentration(properties.get(5))
                        .efficiency(properties.get(6))
                        .build())
                .facilities(ImmutableFacilities.builder()
                        .windTunnel(properties.get(7))
                        .pitstopTrainingCentre(properties.get(8))
                        .rnDWorkshop(properties.get(9))
                        .rnDDesignCentre(properties.get(10))
                        .engineeringWorkshop(properties.get(11))
                        .alloyAndChemicalLab(properties.get(12))
                        .commercial(properties.get(13))
                        .build())
                .build();
    }
}
