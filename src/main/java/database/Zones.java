package database;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import models.Zone;
import org.bson.Document;

public class Zones extends Context {
    private final MongoCollection<Document> collection;

    public Zones() {
        super();
        collection = this.getDatabase().getCollection("zones");
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }

    public FindIterable getZones() {
        return getCollection().find();
    }

    public void addZone(Zone zone) {
        getCollection().insertOne(zone.writeToDatabase());
    }
}
