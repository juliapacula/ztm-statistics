package database;

import models.Route;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Routes extends Context {
    public Routes() {
        super("routes");
    }

    public void addRoutes(Route[] routes) {
        getCollection().insertMany(Arrays.stream(routes).map(Route::writeToDatabase).collect(Collectors.toList()));
    }
}
