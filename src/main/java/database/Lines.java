package database;

import com.mongodb.client.MongoCollection;
import models.Stop;
import org.bson.Document;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Lines extends Context {
    private final MongoCollection<Document> collection;

    public Lines() {
        super();
        collection = this.getDatabase().getCollection("lines");
    }

    public MongoCollection getCollection() {
        return collection;
    }

    public void addStops(Stop[] stops) {
        collection.insertMany(Arrays.stream(stops).map(Stop::writeToDatabase).collect(Collectors.toList()));
    }
}
