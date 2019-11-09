package lt.em.gprosetuphttp.http;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class PropertyValues {
    @NotNull private static final Logger LOGGER = LoggerFactory.getLogger(PropertyValues.class);
    @NotNull private static final String HTTP_PROPERTIES_PATH = "http.properties";

    private final boolean isCleanLogin;
    private final boolean isFlushMemory;

    PropertyValues() {
        boolean cleanLogin = true;
        boolean flushMemory = false;
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(HTTP_PROPERTIES_PATH)) {
            Properties properties = new Properties();
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("Could not find " + HTTP_PROPERTIES_PATH);
            }

            cleanLogin = Boolean.parseBoolean(properties.getProperty("clean_login"));
            flushMemory = Boolean.parseBoolean(properties.getProperty("flush_memory"));
        } catch (FileNotFoundException fileNotFoundException) {
            LOGGER.error("Configuration file was not found {}", fileNotFoundException);
        } catch (IOException ioException) {
            LOGGER.error("No file found: {}", ioException);
        }
        isCleanLogin = cleanLogin;
        isFlushMemory = flushMemory;
    }

    boolean isCleanLogin() {
        return isCleanLogin;
    }

    boolean isFlushMemory() {
        return isFlushMemory;
    }
}
