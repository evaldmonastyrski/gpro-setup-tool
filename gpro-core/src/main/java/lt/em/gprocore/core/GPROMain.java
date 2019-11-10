package lt.em.gprocore.core;

import lt.em.gpro.model.Driver;
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
        Driver driver = new GPROConnector().getDriverData();
        new GPROPersister().persistDriver(driver);
    }
}
