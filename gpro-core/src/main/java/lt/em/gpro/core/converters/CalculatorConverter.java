package lt.em.gpro.core.converters;

import lt.em.gpro.model.input.Car;
import lt.em.gpro.model.input.Driver;
import lt.em.gpro.model.input.PractiseConditions;
import lt.em.gpro.model.output.Setup;
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
