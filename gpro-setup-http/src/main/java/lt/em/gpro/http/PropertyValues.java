package lt.em.gpro.http;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyValues {
    @NotNull private static final Logger LOGGER = LoggerFactory.getLogger(PropertyValues.class);
    @NotNull private static final String HTTP_PROPERTIES_PATH = "http.properties";

    private final boolean isCleanLogin;
    private final boolean isFlushMemory;
    private final boolean isHeadless;

    PropertyValues() {
        boolean cleanLogin = true;
        boolean flushMemory = false;
        boolean headless = true;
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(HTTP_PROPERTIES_PATH)) {
            Properties properties = new Properties();
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("Could not find " + HTTP_PROPERTIES_PATH);
            }

            cleanLogin = Boolean.parseBoolean(properties.getProperty("clean_login"));
            flushMemory = Boolean.parseBoolean(properties.getProperty("flush_memory"));
            headless = Boolean.parseBoolean(properties.getProperty("headless"));
        } catch (FileNotFoundException fileNotFoundException) {
            LOGGER.error("Configuration file was not found {}", fileNotFoundException);
        } catch (IOException ioException) {
            LOGGER.error("No file found: {}", ioException);
        }
        isCleanLogin = cleanLogin;
        isFlushMemory = flushMemory;
        isHeadless = headless;
    }

    public boolean isCleanLogin() {
        return isCleanLogin;
    }

    public boolean isFlushMemory() {
        return isFlushMemory;
    }

    boolean isHeadless() {
        return isHeadless;
    }
}
