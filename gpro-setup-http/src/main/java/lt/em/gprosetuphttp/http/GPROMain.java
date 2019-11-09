package lt.em.gprosetuphttp.http;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GPROMain {
    @NotNull
    private static final Logger LOGGER = LoggerFactory.getLogger(GPROMain.class);

    public static void main(String[] args) {
        new GPROMain().start();
    }

    private void start() {
        LOGGER.info("Application has started");
    }
}
