package lt.em.gprotool.persistence;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import lt.em.gpro.model.Car;
import lt.em.gpro.model.CombinedData;
import lt.em.gpro.model.Driver;
import lt.em.gpro.model.Practise;
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
    @NotNull private final JacksonDBCollection<CombinedData, String> jacksonDBCollection;

    public GPROPersister() {
        mongoClient = new MongoClient(LOCALHOST, DEFAULT_PORT);
        database = mongoClient.getDB(GPRO_DB);
        LOGGER.info("Connected to MongoDB");
        DBCollection dbCollection = database.getCollection("Combined Data Records");
        jacksonDBCollection = JacksonDBCollection.wrap(dbCollection, CombinedData.class, String.class);
    }

    public void persistCombinedData(@NotNull CombinedData combinedData) {
        jacksonDBCollection.insert(combinedData);
    }

    public void persistDriver(@NotNull Driver driver) {
        DBCollection dbCollection = database.getCollection("Driver Records");
        JacksonDBCollection<Driver, String> driverRecords = JacksonDBCollection.wrap(dbCollection, Driver.class, String.class);
        driverRecords.insert(driver);
    }

    public void persistCar(@NotNull Car car) {
        DBCollection dbCollection = database.getCollection("Car Records");
        JacksonDBCollection<Car, String> driverRecords = JacksonDBCollection.wrap(dbCollection, Car.class, String.class);
        driverRecords.insert(car);
    }

    public void persistPractiseLap(@NotNull Practise practise) {
        DBCollection dbCollection = database.getCollection("Practise Lap Records");
        JacksonDBCollection<Practise, String> driverRecords = JacksonDBCollection.wrap(dbCollection, Practise.class, String.class);
        driverRecords.insert(practise);
    }

    public void closeDatabaseConnection() {
        mongoClient.close();
    }
}
