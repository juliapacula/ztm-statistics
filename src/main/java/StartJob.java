import api.BusLineApi;
import api.BusStopsApi;
import api.RouteApi;
import api.StopApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import database.BusLines;
import database.BusStops;
import database.Routes;
import models.BusLine;
import models.BusStop;
import models.Route;
import models.Stop;

import java.util.Date;

public class StartJob {
    public static void main(String[] args) {
        loadStops();
    }

    public static void loadZones() {
        BusStops stopsCollection = new BusStops();
        stopsCollection.addZones();
    }

    public static void loadBusStops() {
        BusStopsApi stopsApi = new BusStopsApi();
        BusStops stopsCollection = new BusStops();
        try {
            BusStop[] stops = stopsApi.getStops();
            stopsCollection.addStops(stops);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void loadBusLines() {
        BusLineApi busLineApi = new BusLineApi();
        BusLines busLinesCollection = new BusLines();
        try {
            BusLine[] busLines = busLineApi.getLines();
            busLinesCollection.addBusLines(busLines);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void loadRoutes() {
        RouteApi routeApi = new RouteApi();
        Routes routesCollection = new Routes();
        try {
            Route[] routes = routeApi.getRoutes();
            routesCollection.addRoutes(routes);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void loadStops() {
        StopApi stopApi = new StopApi();
        try {
            Stop[] routes = stopApi.getStops(new Date(), 12);
            System.out.println(routes.length);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
