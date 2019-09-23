package database;

import com.mongodb.client.MongoCollection;
import models.BusLine;
import models.BusStop;
import org.bson.Document;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BusLines extends Context {
    public BusLines() {
        super("bus_lines");
    }

    public void addBusLines(BusLine[] busLines) {
        getCollection().insertMany(Arrays.stream(busLines).map(BusLine::writeToDatabase).collect(Collectors.toList()));
    }
}
