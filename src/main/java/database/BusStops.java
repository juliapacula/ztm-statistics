package database;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import models.BusStop;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class BusStops extends Context {
    public BusStops() {
        super("bus_stops");
    }

    public void addStops(BusStop[] stops) {
        getCollection().insertMany(Arrays.stream(stops).map(BusStop::writeToDatabase).collect(Collectors.toList()));
    }

    public MongoCursor<Document> getZones() {
        Bson group = Aggregates.group("$zone._id", Accumulators.first("name", "$zone.name"));

        return getCollection().aggregate(Collections.singletonList(group)).iterator();
    }

    public void addZones() {
        MongoCursor<Document> cursor = getZones();
        while (cursor.hasNext()) {
            getDatabase().getCollection("zones").insertOne(cursor.next());
        }
    }
}
