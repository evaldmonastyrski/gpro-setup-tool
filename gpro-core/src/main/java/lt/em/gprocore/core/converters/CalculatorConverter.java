package lt.em.gprocore.core.converters;

import lt.em.gpro.model.Car;
import lt.em.gpro.model.Driver;
import lt.em.gpro.model.PractiseConditions;
import lt.em.gpro.model.Setup;
import lt.em.gprocalculator.calculator.SetupCalculator;
import org.jetbrains.annotations.NotNull;

public enum CalculatorConverter {
    ;

    @NotNull
    public static Setup convert(@NotNull Driver driver, @NotNull Car car, @NotNull PractiseConditions practiseConditions) {
        return SetupConverter.convert(SetupCalculator.calculate(DriverConverter.convert(driver),
                PractiseConditionsConverter.convert(practiseConditions),
                CarConverter.convert(car)));
    }
}
