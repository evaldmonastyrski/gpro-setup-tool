package lt.em.gpro.http.input;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URL;

class IPAdressExtractor {
    @NotNull private static final Logger LOGGER = LoggerFactory.getLogger(IPAdressExtractor.class);
    @NotNull private static final String HTTP_CHECKIP = "http://checkip.amazonaws.com";

    @NotNull
    static String determinePublicIP() {
        try {
            URL whatIsMyIP = new URL(HTTP_CHECKIP);
            BufferedReader in = new BufferedReader(new InputStreamReader(whatIsMyIP.openStream()));

            return in.readLine();
        } catch (MalformedURLException malformedUrlException) {
            LOGGER.error("{} is malformed, could not check IP", HTTP_CHECKIP);
            throw new UncheckedIOException(malformedUrlException);
        } catch (IOException ioException) {
            LOGGER.error("Could not read the IP from {}", HTTP_CHECKIP);
            throw new UncheckedIOException(ioException);
        }
    }
}
