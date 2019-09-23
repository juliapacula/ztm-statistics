package database;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class BusLines extends Context {
    private final MongoCollection<Document> collection;

    public BusLines() {
        super();
        collection = this.getDatabase().getCollection("lines");
    }

    public MongoCollection getCollection() {
        return collection;
    }
}
