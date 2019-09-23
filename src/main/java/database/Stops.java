package database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import models.Stop;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Stops extends Context {
    private final MongoCollection<Document> collection;

    public Stops() {
        super();
        collection = this.getDatabase().getCollection("stops");
    }

    public MongoCollection getCollection() {
        return collection;
    }

    public void addStops(Stop[] stops) {
        collection.insertMany(Arrays.stream(stops).map(Stop::writeToDatabase).collect(Collectors.toList()));
    }

    public MongoCursor<Document> getZones() {
        Bson group = Aggregates.group("$zone._id", Accumulators.first("name", "$zone.name"));

        return collection.aggregate(Collections.singletonList(group)).iterator();
    }

    public void addZones() {
        MongoCursor<Document> cursor = getZones();
        while (cursor.hasNext()) {
            getDatabase().getCollection("zones").insertOne(cursor.next());
        }
    }
}
