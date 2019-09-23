package database;

import com.mongodb.client.FindIterable;
import models.Zone;

public class Zones extends Context {
    public Zones() {
        super("zones");
    }

    public FindIterable getZones() {
        return getCollection().find();
    }

    public void addZone(Zone zone) {
        getCollection().insertOne(zone.writeToDatabase());
    }
}
