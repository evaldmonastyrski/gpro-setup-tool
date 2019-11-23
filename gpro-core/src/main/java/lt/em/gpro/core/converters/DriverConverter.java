package lt.em.gpro.core.converters;

import lt.em.gpro.model.input.Driver;
import lt.em.gprocalculator.calculator.datamodel.CDriver;
import lt.em.gprocalculator.calculator.datamodel.ImmutableCDriver;
import org.jetbrains.annotations.NotNull;

enum DriverConverter {
    ;

    @NotNull
    static CDriver convert(@NotNull Driver driver) {
        return ImmutableCDriver.builder()
                .name(driver.getName())
                .energy(driver.getEnergy())
                .overall(driver.getOverall())
                .concentration(driver.getConcentration())
                .talent(driver.getTalent())
                .aggressiveness(driver.getAggressiveness())
                .experience(driver.getExperience())
                .technicalInsight(driver.getTechnicalInsight())
                .stamina(driver.getStamina())
                .charisma(driver.getCharisma())
                .motivation(driver.getMotivation())
                .reputation(driver.getReputation())
                .weight(driver.getWeight())
                .age(driver.getAge())
                .build();
    }
}
