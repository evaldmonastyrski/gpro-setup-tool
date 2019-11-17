package lt.em.gprocore.core;

import lt.em.gpro.model.Car;
import lt.em.gpro.model.Driver;
import lt.em.gpro.model.PractiseConditions;
import lt.em.gpro.model.Setup;
import lt.em.gprocalculator.calculator.CalculatorContext;
import lt.em.gprocore.core.converters.CalculatorConverter;
import lt.em.gprocore.core.utils.Utils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

enum SetupBridge {
    ;
    @NotNull private static final Logger LOGGER = LoggerFactory.getLogger(SetupBridge.class);
    @NotNull private static final String CALCULATOR_DEPENDENCY = "lt.em.gprocalculator.calculator.datamodel.CDriver";

    @NotNull
    static Setup calculateSetup(@NotNull Driver driver, @NotNull Car car, @NotNull PractiseConditions practiseConditions) {
        Setup setup;
        if (Utils.isDependencyAvailable(CALCULATOR_DEPENDENCY)) {
            LOGGER.info("Calculator package is available");
            CalculatorContext.calculatorContext();
            setup = CalculatorConverter.convert(driver, car, practiseConditions);
        } else {
            LOGGER.info("Calculator package is unavailable, default setup will be used");
            setup = Setup.getDefaultSetup();
        }
        return setup;
    }
}
