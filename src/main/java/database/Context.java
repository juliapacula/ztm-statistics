package database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public abstract class Context {
    private final MongoClient client;
    private final MongoDatabase database;
    private final MongoCollection<Document> collection;

    public Context(String collectionName) {
        client = new MongoClient();
        database = client.getDatabase("ztmStatistics");
        collection = getDatabase().getCollection(collectionName);
    }

    public MongoClient getClient() {
        return client;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }
}
