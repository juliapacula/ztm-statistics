package database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Context {
    private final MongoClient client;
    private final MongoDatabase database;

    public Context() {
        client = new MongoClient();
        database = client.getDatabase("ztmStatistics");
    }

    public MongoClient getClient() {
        return client;
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}
