package lt.em.gprotool.persistence;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.em.gpro.model.Driver;
import org.bson.Document;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GPROPersister {
    @NotNull private static final Logger LOGGER = LoggerFactory.getLogger(GPROPersister.class);
    @NotNull private static final String LOCALHOST = "localhost";
    @NotNull private static final String GPRO_DB = "gpro_db";
    private static final int DEFAULT_PORT = 27017;

    @NotNull private final MongoClient mongoClient;
    @NotNull private final MongoDatabase database;

    public GPROPersister() {
        mongoClient = new MongoClient(LOCALHOST, DEFAULT_PORT);
        database = mongoClient.getDatabase(GPRO_DB);
        LOGGER.info("Connected to MongoDB");
    }

    public void persistDriver(@NotNull Driver driver) {
        MongoCollection<Document> driverRecords = database.getCollection("Driver Records");
        Document document = new Document("1", driver);
        LOGGER.info("Ready to persistDriver: {} to {}", document, driverRecords);
        mongoClient.close();
    }
}
