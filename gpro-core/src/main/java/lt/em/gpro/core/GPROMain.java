package lt.em.gpro.core;

import lt.em.gpro.model.input.Car;
import lt.em.gpro.model.input.CombinedData;
import lt.em.gpro.model.input.Driver;
import lt.em.gpro.model.input.PractiseConditions;
import lt.em.gpro.model.output.Setup;
import lt.em.gpro.model.input.StaffAndFacilities;
import lt.em.gpro.http.GPROConnector;
import lt.em.gpro.persistence.GPROPersister;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class GPROMain {
    @NotNull private static final Logger LOGGER = LoggerFactory.getLogger(GPROMain.class);

    public static void main(@NotNull String[] args) {
        new GPROMain().start();
    }

    private void start() {
        LOGGER.info("Application has started");
        GPROConnector gproConnector = new GPROConnector();
        gproConnector.login();

        Driver driver = gproConnector.getDriverData();
        Car car = gproConnector.getCarData();
        PractiseConditions practiseConditions = gproConnector.getPractiseConditionsData();
        StaffAndFacilities staffAndFacilities = gproConnector.getStaffAndFacilitiesData();

        Setup setup = SetupBridge.calculateSetup(driver, car, practiseConditions);
        LOGGER.info("Setup: {}", setup);

        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Please enter the tyre compound you would like to use: \n");

        gproConnector.drivePractiseLap(setup, scanner.nextLine());
        persist(gproConnector, driver, car, practiseConditions, staffAndFacilities);
    }

    private void persist(@NotNull GPROConnector gproConnector,
                         @NotNull Driver driver,
                         @NotNull Car car,
                         @NotNull PractiseConditions practiseConditions,
                         @NotNull StaffAndFacilities staffAndFacilities) {
        CombinedData combinedData = Combiner.createCombinedData(
                driver,
                car,
                practiseConditions,
                staffAndFacilities,
                gproConnector.getPractiseData());
        gproConnector.closeBrowser();

        GPROPersister gproPersister = new GPROPersister();
        gproPersister.persistCombinedData(combinedData);
        gproPersister.closeDatabaseConnection();
    }
}
