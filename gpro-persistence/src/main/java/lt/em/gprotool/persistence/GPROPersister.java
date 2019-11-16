package lt.em.gprotool.persistence;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import lt.em.gpro.model.Driver;
import org.jetbrains.annotations.NotNull;
import org.mongojack.JacksonDBCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GPROPersister {
    @NotNull private static final Logger LOGGER = LoggerFactory.getLogger(GPROPersister.class);
    @NotNull private static final String LOCALHOST = "localhost";
    @NotNull private static final String GPRO_DB = "gpro_db";
    private static final int DEFAULT_PORT = 27017;

    @NotNull private final MongoClient mongoClient;
    @NotNull private final DB database;

    public GPROPersister() {
        mongoClient = new MongoClient(LOCALHOST, DEFAULT_PORT);
        database = mongoClient.getDB(GPRO_DB);
        LOGGER.info("Connected to MongoDB");
    }

    public void persistDriver(@NotNull Driver driver) {
        DBCollection dbCollection = database.getCollection("Driver Records");
        JacksonDBCollection<Driver, String> driverRecords = JacksonDBCollection.wrap(dbCollection, Driver.class, String.class);
        driverRecords.insert(driver);
        mongoClient.close();
    }
}
