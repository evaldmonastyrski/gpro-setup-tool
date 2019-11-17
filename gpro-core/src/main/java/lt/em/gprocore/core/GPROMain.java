package lt.em.gprocore.core;

import lt.em.gpro.model.CombinedData;
import lt.em.gprosetuphttp.http.GPROConnector;
import lt.em.gprotool.persistence.GPROPersister;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GPROMain {
    @NotNull private static final Logger LOGGER = LoggerFactory.getLogger(GPROMain.class);

    public static void main(@NotNull String[] args) {
        new GPROMain().start();
    }

    private void start() {
        LOGGER.info("Application has started");
        GPROConnector gproConnector = new GPROConnector();
        gproConnector.login();
        CombinedData combinedData = Combiner.createCombinedData(
                gproConnector.getDriverData(),
                gproConnector.getCarData(),
                gproConnector.getPractiseConditionsData(),
                gproConnector.getPractiseData(),
                gproConnector.getStaffAndFacilitiesData());
        gproConnector.closeBrowser();

        GPROPersister gproPersister = new GPROPersister();
        gproPersister.persistCombinedData(combinedData);
        gproPersister.closeDatabaseConnection();
    }
}
