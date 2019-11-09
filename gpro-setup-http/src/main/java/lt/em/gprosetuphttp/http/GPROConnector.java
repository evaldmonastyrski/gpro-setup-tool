package lt.em.gprosetuphttp.http;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GPROConnector {
        @NotNull private static final Logger LOGGER = LoggerFactory.getLogger(GPROConnector.class);

        public void connect() {
            LOGGER.info("Connecting...");
        }
}
